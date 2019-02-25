package cn.cj.dao;

import org.apache.ibatis.annotations.Param;

import cn.cj.entity.CommentPraise;

public interface CommentPraiseMapper {
	int deleteByPrimaryKey(Long commentPraiseId);

	int insertSelective(CommentPraise record);

	CommentPraise selectByPrimaryKey(Long commentPraiseId);

	int updateByPrimaryKey(CommentPraise record);
	
	/**
	 * 查询是否点过赞
	 * @param commentId
	 * @param userId
	 * @return
	 */
	int isDoPraise(@Param("commentId")Long commentId,@Param("userId")Long userId);
}
