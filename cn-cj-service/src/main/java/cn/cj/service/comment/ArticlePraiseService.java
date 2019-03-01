package cn.cj.service.comment;

import cn.cj.entity.ArticlePraise;

public interface ArticlePraiseService {
	int deleteByPrimaryKey(Long articlePraiseId) throws Exception;

	int insertSelective(ArticlePraise record) throws Exception;

	ArticlePraise selectByPrimaryKey(Long articlePraiseId) throws Exception;

	int updateByPrimaryKey(ArticlePraise record) throws Exception;
}
