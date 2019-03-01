package cn.cj.controller.back;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.cj.entity.Article;
import cn.cj.entity.ArticleContentImg;
import cn.cj.entity.Label;
import cn.cj.entity.User;
import cn.cj.service.article.ArticleContentImgService;
import cn.cj.service.article.ArticleService;
import cn.cj.service.label.LabelService;
import cn.cj.tools.Constant;
import cn.cj.tools.LayuiPage;
import cn.cj.tools.LayuiTableMap;
import cn.cj.tools.OtherUtils;

@Controller
@RequestMapping("back")
public class BackController {

	Logger logger = LoggerFactory.getLogger(BackController.class);

	@Autowired
	private ArticleService articleService;

	@Autowired
	private LabelService labelService;

	@Autowired
	private ArticleContentImgService articleContentService;

	/**
	 * 进入后台首页页面
	 * @return
	 */
	@RequestMapping("index")
	public String index(){
		return "/back/index";
	}

	/**
	 * 进入写文章页面(后台)
	 * @return
	 */
	@RequestMapping("addArticle")
	public String addArticle(HttpServletRequest request){
		//获取标签集合
		try {
			List<Label> labelList = labelService.selectAllLabelList();
			request.setAttribute("ramdonAboutArticle", OtherUtils.getCustomRandom(6));
			request.setAttribute("labelList", labelList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/back/addArticle";
	}

	/**
	 * 进入文章列表页面(后台)
	 * @return
	 */
	@RequestMapping("articleList")
	public String articleList(){
		return "/back/articleList";
	}

	/**
	 * 文章内容粘贴图片事件(后台)
	 * @param ramdonAboutArticle
	 * @param request
	 * @param blob
	 * @return
	 */
	@RequestMapping("pasteArticleImg")
	@ResponseBody
	public String pasteArticleImg(@RequestParam("ramdonAboutArticle")String ramdonAboutArticle,
			HttpServletRequest request, @RequestParam("clipboardData")MultipartFile blob){
		Map<String, Object> result = new HashMap<>();
		ArticleContentImg record = new ArticleContentImg();
		String random = OtherUtils.getCustomRandom(8);
		try {
			//修改
			String path = request.getSession().getServletContext().getRealPath("/");
			ArticleContentImg articleContentImg = articleContentService.selectArticleConttentImgByRandom(ramdonAboutArticle);
			if(null != articleContentImg){
				if(blob!=null){
					record.setArticleContentId(articleContentImg.getArticleContentId());
					record.setArticleContentUrl(articleContentImg.getArticleContentUrl()+",../statics/img/articleContentImg/article_ContentImg"+ramdonAboutArticle+random+".png");
					Integer flag = articleContentService.updateByPrimaryKey(record);
					if(flag > 0){
						result.put(Constant.ARTICLE_CODE, 1);
						result.put(Constant.ARTICLE_INFO, "修改成功");
					}
				}
			}else{
				//新增
				record.setArticleContentRandom(ramdonAboutArticle);
				record.setArticleContentUrl("../statics/img/articleContentImg/article_ContentImg"+ramdonAboutArticle+random+".png");
				Integer flag = articleContentService.insertSelective(record);
				if(flag > 0){
					result.put(Constant.ARTICLE_CODE, 2);
					result.put(Constant.ARTICLE_INFO, "新增成功");
				}
			}
			blob.transferTo(new File(path+"/statics/img/articleContentImg/article_ContentImg"+ramdonAboutArticle+random+".png"));
		} catch (Exception e) {
			logger.debug(e.toString());
			result.put(Constant.ARTICLE_CODE, -1);
			result.put(Constant.ARTICLE_INFO, "上传失败");
		}
		return JSON.toJSONString(result);
	}
	
	/**
	 * 文章列表(后台)
	 * @param page
	 * @return
	 */
	@RequestMapping("queryArticleList")
	@ResponseBody
	public Object queryArticleList(@RequestParam("page")Integer page, @RequestParam("limit") Integer limit,
			@RequestParam("StartTime") String startTime, @RequestParam("EndTime") String endTime, 
			@RequestParam("KeyWords") String keyWords){
		LayuiTableMap<Article,Label> layuiMap = null;
		try {
			LayuiPage pages = new LayuiPage(page, limit, keyWords, startTime, endTime);
			List<Article> articlList = articleService.selectAllArticleInfo(pages);
			List<String> labelList = new ArrayList<>();
			for (Article article : articlList) {
				String labelStr = article.getArticleLabel();
				String[] labelArr = labelStr.split(",");
				for (int i = 0; i < labelArr.length; i++) {
					Label label = labelService.selectByPrimaryKey(Long.valueOf(labelArr[i]));
					labelList.add(label.getLabelName());
				}
				String str = labelList.toString();
				int leftIndex = str.indexOf("[");
				str = str.substring(leftIndex+1, str.length()-1);
				article.setArticleLabel(str);
				labelList.clear();
			}

			Integer totalCount = articleService.selectArticleTotalCount();
			layuiMap = new LayuiTableMap<Article,Label>(0, "", articlList, totalCount);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.toString());
		}
		return JSON.toJSONString(layuiMap,SerializerFeature.DisableCircularReferenceDetect);
	}

	/**
	 * 写文章(后台)
	 * @param multipartFile
	 * @param request
	 * @param article_title
	 * @param article_content
	 * @param article_label
	 * @return
	 */
	@RequestMapping(value = "addArticle", method = RequestMethod.POST)
	@ResponseBody
	public String addArticle(@RequestParam("article_bgimg") MultipartFile multipartFile, HttpServletRequest request,
		   String article_title, String article_content,
		   String[] article_label, @RequestParam("ramdonAboutArticle") String ramdonAboutArticle){

		Map<String, Object> result = new HashMap<String, Object>();
		Article article = new Article();
		try {
			User user = (User) request.getSession().getAttribute(Constant.SESSION_USER);
			//获取作者
			article.setArticleAuthor(Long.valueOf(user.getUserId().toString()));
			
			//获取到文章内容表中的每个路径			
			ArticleContentImg contentImg = articleContentService.selectArticleConttentImgByRandom(ramdonAboutArticle);
			String urlImg[] =contentImg.getArticleContentUrl().split(",");
			for (int j = 0; j < urlImg.length; j++) {
				int index = article_content.indexOf("blob:http://localhost:8080/");
				if(index != -1){
					String target = article_content.substring(index,index+63);
					article_content = article_content.replace(target, urlImg[j]);
				}
			}
			//获取文章内容
			article.setArticleContent(article_content);
			//获取发布人
			article.setArticleCreater(Long.valueOf(user.getUserId().toString()));
			//时间
			article.setArticleCreateTime(new Date());
			//拼接标签(查询数据库进行)
			String labelStr=StringUtils.join(article_label,',');
			article.setArticleLabel(labelStr);
			article.setArticleTitle(article_title);
			//文件的原始名
			String originalFileName = multipartFile.getOriginalFilename();
			//文件的大小
			//Long  size = multipartFile.getSize();
			if(multipartFile!=null){
				//将文件复制到目标目录
				String path = request.getSession().getServletContext().getRealPath("/");
				String random = OtherUtils.getCustomRandom(5);
				article.setArticleBgimg("../statics/img/article_bgimg"+random+originalFileName);
				articleService.insertSelective(article);
				multipartFile.transferTo(new File(path+"/statics/img/article_bgimg"+random+originalFileName));
				result.put(Constant.ARTICLE_INFO, "保存成功");
				result.put(Constant.ARTICLE_CODE, "1");
			}
		} catch (Exception e) {
			result.put(Constant.ARTICLE_INFO, "保存失败");
			result.put(Constant.ARTICLE_CODE, "-1");
			logger.debug(e.toString());
		}
		return JSON.toJSONString(result);
	}

	/**
	 * 删除文章(后台)
	 * 修改delete_flag(逻辑删除)
	 * @param articleId
	 * @return
	 */
	@RequestMapping("putawayArticle")
	@ResponseBody
	public String putawayArticle(@RequestParam("articleId") Integer articleId,@RequestParam("isPutaway") Integer isPutaway){
		Map<String, Object> result = new HashMap<>();
		try {
			Article article = new Article();
			article.setArticleId(Long.valueOf(articleId));
			article.setIsPutaway(isPutaway);
			if(articleService.updateByPrimaryKey(article) > 0){
				if(isPutaway == 1){
					result.put(Constant.ARTICLE_INFO, "成功发布文章");
				}else if(isPutaway == 0){
					result.put(Constant.ARTICLE_INFO, "成功下架文章");
				}
				result.put(Constant.ARTICLE_CODE, "1");	
			}
		} catch (Exception e) {
			result.put(Constant.ARTICLE_INFO, "文章操作异常");
			result.put(Constant.ARTICLE_CODE, "-1");
			logger.debug(e.toString());
		}
		return JSON.toJSONString(result);
	}

	/**
	 * 删除文章(后台)
	 * 修改delete_flag(逻辑删除)
	 * @param articleId
	 * @return
	 */
	@RequestMapping("deleteArticle")
	@ResponseBody
	public String deleteArticle(@RequestParam("articleId") Integer articleId){
		Map<String, Object> result = new HashMap<>();
		try {
			Article article = new Article();
			article.setArticleId(Long.valueOf(articleId));
			article.setArticleDeleteFlag("Y");
			article.setIsPutaway(0);
			if(articleService.updateByPrimaryKey(article) > 0){
				result.put(Constant.ARTICLE_INFO, "成功删除文章");
				result.put(Constant.ARTICLE_CODE, "1");	
			}
		} catch (Exception e) {
			result.put(Constant.ARTICLE_INFO, "文章操作异常");
			result.put(Constant.ARTICLE_CODE, "-1");
			logger.debug(e.toString());
		}
		return JSON.toJSONString(result);
	}
}
