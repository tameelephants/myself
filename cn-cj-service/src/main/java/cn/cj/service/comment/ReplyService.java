package cn.cj.service.comment;

import cn.cj.entity.Reply;

public interface ReplyService {
	int deleteByPrimaryKey(Long replyId) throws Exception;

	int insertSelective(Reply record) throws Exception;

	Reply selectByPrimaryKey(Long replyId) throws Exception;

	int updateByPrimaryKey(Reply record) throws Exception;
}
