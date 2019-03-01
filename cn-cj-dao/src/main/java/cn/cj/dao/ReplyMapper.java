package cn.cj.dao;

import cn.cj.entity.Reply;

public interface ReplyMapper {
	int deleteByPrimaryKey(Long replyId);

	int insertSelective(Reply record);

	Reply selectByPrimaryKey(Long replyId);

	int updateByPrimaryKey(Reply record);
	
	Reply selectReplyInfoByCommentId(Long commentId);
}
