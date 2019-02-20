package cn.cj.dao;

import cn.cj.entity.ArticlePraise;

public interface ArticlePraiseMapper {
	int deleteByPrimaryKey(Long articlePraiseId);

	int insertSelective(ArticlePraise record);

	ArticlePraise selectByPrimaryKey(Long articlePraiseId);

	int updateByPrimaryKey(ArticlePraise record);
}
