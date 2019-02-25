package cn.cj.dao;

import org.apache.ibatis.annotations.Param;

import cn.cj.entity.ArticlePraise;

public interface ArticlePraiseMapper {
	int deleteByPrimaryKey(Long articlePraiseId);

	int insertSelective(ArticlePraise record);

	ArticlePraise selectByPrimaryKey(Long articlePraiseId);

	int updateByPrimaryKey(ArticlePraise record);

	/**
	 * 判断当前用户是否点赞过某文章
	 * @param articleId
	 * @param userId
	 * @return
	 */
	int isDoPraise(@Param("articleId")Long articleId, @Param("userId")Long userId);
}
