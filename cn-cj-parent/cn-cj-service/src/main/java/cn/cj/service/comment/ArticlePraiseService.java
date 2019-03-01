package cn.cj.service.comment;

import cn.cj.entity.ArticlePraise;

public interface ArticlePraiseService {
	int deleteByPrimaryKey(Long articlePraiseId) throws Exception;

	int insertSelective(ArticlePraise record) throws Exception;

	ArticlePraise selectByPrimaryKey(Long articlePraiseId) throws Exception;

	int updateByPrimaryKey(ArticlePraise record) throws Exception;

	/**
	 * 文章点赞
	 * @param articleId
	 * @param userId
	 * @param praiseNum
	 * @return
	 */
	int doPraise(Long articleId, Long userId, Long praiseNum) throws Exception;

	/**
	 * 查询当前用户是否点赞过某文章
	 * @param articleId 某文章
	 * @param userId 当前用户
	 * @return
	 */
	int isDoPraise(Long articleId, Long userId) throws Exception;
}
