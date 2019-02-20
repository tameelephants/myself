package cn.cj.service.comment;

import cn.cj.entity.CommentPraise;

public interface CommentPraiseService {
	int deleteByPrimaryKey(Long commentPraiseId) throws Exception;

	int insertSelective(CommentPraise record) throws Exception;

	CommentPraise selectByPrimaryKey(Long commentPraiseId) throws Exception;

	int updateByPrimaryKey(CommentPraise record) throws Exception;
}
