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

import cn.cj.entity.Article;
import cn.cj.entity.Label;
import cn.cj.service.article.ArticleService;
import cn.cj.service.label.LabelService;
import cn.cj.tools.Constant;

@Controller
@RequestMapping("article")
public class ArticleController {
	
	Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private LabelService labelService;
	
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
	public String loadCommentAndOthers(@RequestParam("articleId") Long articleId){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Article article = articleService.selectByPrimaryKey(articleId);
			result.put(Constant.ARTICLE_CODE, 1);
			result.put("article", article);
		} catch (Exception e) {
			result.put(Constant.ARTICLE_CODE, -1);
			result.put(Constant.ARTICLE_INFO, "查询错误");
			e.printStackTrace();
		}
		System.err.println(JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	
}
