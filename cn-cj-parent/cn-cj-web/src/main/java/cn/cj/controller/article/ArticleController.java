package cn.cj.controller.article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.cj.entity.Article;
import cn.cj.entity.Comment;
import cn.cj.entity.Label;
import cn.cj.service.article.ArticleService;
import cn.cj.service.comment.CommentService;
import cn.cj.service.label.LabelService;
import cn.cj.tools.Constant;
import cn.cj.tools.LayuiPage;

@Controller
@RequestMapping("article")
public class ArticleController {
	
	Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private LabelService labelService;

	@Autowired
	private CommentService commentService;
	
	//文章展示页面跳转
//	@RequestMapping("articleInfos")
//	public String articleInfo(){
//		return "/articles";
//	}
	
	//文章展示页面跳转
	@RequestMapping("articleInfo")
	public String articleInfos(@RequestParam("articleId") String articleId,HttpServletRequest request){
		try {
			Article article = articleService.selectByPrimaryKey(Long.valueOf(articleId));
			String [] labelNum = article.getArticleLabel().split(",");
			List<Label> labelList = new ArrayList<>();
			for (int i = 0; i < labelNum.length; i++) {
				Label label = labelService.selectByPrimaryKey(Long.valueOf(labelNum[i]));
				labelList.add(label);
			}
			request.setAttribute("article", article);
			request.setAttribute("labelList", labelList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/article";
	}
		
	
	/**
	 * 通过文章Id获取当前文章信息,文章评论集合,文章回复集合
	 */
	@RequestMapping("loadCommentAndOthers")
	@ResponseBody
	public String loadCommentAndOthers(@RequestParam("articleId")Long articleId, int pages, int limit){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			LayuiPage page = new LayuiPage(pages, limit);
			List<Comment> commentList = commentService.selectAllCommentByArticleId(articleId,page);
			result.put(Constant.ARTICLE_CODE, 1);
			result.put("commentList", commentList);
		} catch (Exception e) {
			result.put(Constant.ARTICLE_CODE, -1);
			result.put(Constant.ARTICLE_INFO, "查询错误");
			e.printStackTrace();
		}
		System.err.println("geshi"+JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect));
		return JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
	}
	
}
