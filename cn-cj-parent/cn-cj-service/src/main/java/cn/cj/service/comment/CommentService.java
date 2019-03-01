package cn.cj.service.comment;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.cj.entity.Comment;
import cn.cj.tools.LayuiPage;

public interface CommentService {
	int deleteByPrimaryKey(Long commentId) throws Exception;

	int insertSelective(Comment record) throws Exception;

	Comment selectByPrimaryKey(Long commentId) throws Exception;

	int updateByPrimaryKey(Comment record) throws Exception;

	/**
	 * 通过文章Id获取评论列表
	 * @param articleId，page, limit
	 * @return Comment
	 */
	List<Comment> selectAllCommentByArticleId(Long articleId, LayuiPage page)  throws Exception;

	/**
	 * 添加文章评论信息
	 * @param commentContext
	 * @param articleId
	 * @param session
	 * @throws Exception
	 */
	void addComment(String commentContext, Long articleId, HttpSession session) throws Exception;

}
