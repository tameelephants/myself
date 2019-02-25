package cn.cj.controller.article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import cn.cj.entity.ArticlePraise;
import cn.cj.entity.Comment;
import cn.cj.entity.Label;
import cn.cj.entity.User;
import cn.cj.service.article.ArticleService;
import cn.cj.service.comment.ArticlePraiseService;
import cn.cj.service.comment.CommentPraiseService;
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
	
	@Autowired
	private CommentPraiseService commentPraiseService;

	@Autowired
	private ArticlePraiseService articlePraiseService;
	
	//文章展示页面跳转
//	@RequestMapping("articleInfos")
//	public String articleInfo(){
//		return "/articles";
//	}
	
	//文章展示页面跳转
	@RequestMapping("articleInfo")
	public String articleInfos(@RequestParam("articleId") String articleId,HttpServletRequest request, HttpSession session){
		try {
			User user = (User)session.getAttribute(Constant.SESSION_USER);
			Article article = articleService.selectByPrimaryKey(Long.valueOf(articleId));
			int praiseNum = articlePraiseService.isDoPraise(article.getArticleId(),user.getUserId());
			String [] labelNum = article.getArticleLabel().split(",");
			List<Label> labelList = new ArrayList<>();
			for (int i = 0; i < labelNum.length; i++) {
				Label label = labelService.selectByPrimaryKey(Long.valueOf(labelNum[i]));
				labelList.add(label);
			}
			request.setAttribute("praiseNum", praiseNum);
			request.setAttribute("article", article);
			request.setAttribute("labelList", labelList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/article";
	}
		
	
	/**
	 * 通过文章Id获取当前文章评论信息
	 */
	@RequestMapping("loadCommentAndOthers")
	@ResponseBody
	public String loadCommentAndOthers(@RequestParam("articleId")Long articleId, int pages, int limit, HttpSession session){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			LayuiPage page = new LayuiPage(pages, limit);
			List<Comment> commentList = commentService.selectAllCommentByArticleId(articleId,page);
			User user = (User)session.getAttribute(Constant.SESSION_USER);
			List<String> lists = new ArrayList<>();
			for (Comment comment : commentList) {
				int isPraise = commentPraiseService.isDoPraise(comment.getCommentId(),  user.getUserId());
				lists.add(String.valueOf(isPraise));
			}
			result.put("praiseList", lists);
			result.put(Constant.ARTICLE_CODE, 1);
			result.put("commentList", commentList);
		} catch (Exception e) {
			result.put(Constant.ARTICLE_CODE, -1);
			result.put(Constant.ARTICLE_INFO, "查询错误");
			e.printStackTrace();
		}
		return JSON.toJSONString(result,SerializerFeature.DisableCircularReferenceDetect);
	}
	
	
	/**
	 * 评论点赞
	 */
	@RequestMapping("doPraiseAboutComment")
	@ResponseBody
	public String doPraiseAboutComment(@RequestParam("commentId") Long commentId, @RequestParam("praiseNum")Long praiseNum, HttpSession session){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			User user = (User)session.getAttribute(Constant.SESSION_USER);
			if(null != user){
				commentPraiseService.doPraise(commentId, user.getUserId(), praiseNum);
				result.put(Constant.COMMENT_CODE, "1");
				result.put(Constant.COMMENT_INFO, "点赞成功!");
			}
		} catch (Exception e) {
			logger.debug("评论点赞失败");
			result.put(Constant.COMMENT_CODE, "-1");
			result.put(Constant.COMMENT_INFO, "点赞失败!");
		}
		return JSON.toJSONString(result);
	}
	
	/**
	 * 文章点赞
	 * @param articleId
	 * @param praiseNum
	 * @param session
	 * @return
	 */
	@RequestMapping("doPraiseAboutArticle")
	@ResponseBody
	public String doPraiseAboutArticle(@RequestParam("articleId") Long articleId, @RequestParam("praiseNum")Long praiseNum, HttpSession session){
		Map<String, Object> result = new HashMap<>();
		try {
			User user = (User)session.getAttribute(Constant.SESSION_USER);
			if(null != user){
				articlePraiseService.doPraise(articleId,user.getUserId(),praiseNum);
				result.put(Constant.ARTICLE_CODE, "1");
				result.put(Constant.ARTICLE_CODE, "点赞成功");
			}
		} catch (Exception e) {
			logger.debug("文章点赞失败");
			result.put(Constant.ARTICLE_CODE, "-1");
			result.put(Constant.ARTICLE_CODE, "点赞失败");
		}
		return JSON.toJSONString(result);
	}
}
