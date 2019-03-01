package cn.cj.service.comment;

import cn.cj.entity.CommentPraise;

public interface CommentPraiseService {
	int deleteByPrimaryKey(Long commentPraiseId) throws Exception;

	int insertSelective(CommentPraise record) throws Exception;

	CommentPraise selectByPrimaryKey(Long commentPraiseId) throws Exception;

	int updateByPrimaryKey(CommentPraise record) throws Exception;
	
	/**
	 * 评论点赞
	 * @param commentId
	 * @param userId
	 */
	int doPraise(Long commentId, Long userId, Long praiseNum) throws Exception;
	
	/**
	 * 查询当前用户是否点赞过某评论
	 * @param commentId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	int isDoPraise(Long commentId, Long userId) throws Exception;
}
