package cn.cj.dao;

import cn.cj.entity.CommentPraise;

public interface CommentPraiseMapper {
	int deleteByPrimaryKey(Long commentPraiseId);

	int insertSelective(CommentPraise record);

	CommentPraise selectByPrimaryKey(Long commentPraiseId);

	int updateByPrimaryKey(CommentPraise record);
}
