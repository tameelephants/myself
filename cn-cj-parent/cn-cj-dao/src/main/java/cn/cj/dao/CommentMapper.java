package cn.cj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cj.entity.Comment;

public interface CommentMapper {
	int deleteByPrimaryKey(Long commentId);

	int insertSelective(Comment record);

	Comment selectByPrimaryKey(Long commentId);

	int updateByPrimaryKey(Comment record);
	
	/**
	 * 获取评论集合
	 * @param articleId,pageX,limit
	 * @return commentList
	 */
	List<Comment> selectAllCommentByArticleId(@Param("articleId") Long articleId, @Param("pageX") Integer pageX, @Param("limit") Integer limit);
}
