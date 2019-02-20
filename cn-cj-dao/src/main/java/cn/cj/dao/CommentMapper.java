package cn.cj.dao;

import java.util.List;

import cn.cj.entity.Comment;

public interface CommentMapper {
	int deleteByPrimaryKey(Long commentId);

	int insertSelective(Comment record);

	Comment selectByPrimaryKey(Long commentId);

	int updateByPrimaryKey(Comment record);
	
	List<Comment> selectAllCommentByArticleId(Long articleId);
}
