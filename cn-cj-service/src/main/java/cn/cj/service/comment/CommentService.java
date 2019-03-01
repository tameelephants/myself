package cn.cj.service.comment;

import cn.cj.entity.Comment;

public interface CommentService {
	int deleteByPrimaryKey(Long commentId) throws Exception;

	int insertSelective(Comment record) throws Exception;

	Comment selectByPrimaryKey(Long commentId) throws Exception;

	int updateByPrimaryKey(Comment record) throws Exception;
}
