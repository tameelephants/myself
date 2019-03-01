package cn.cj.service.comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cj.dao.ReplyMapper;
import cn.cj.entity.Reply;

/**
 * 回复评论业务层
 * @author Elephant
 *
 */

@Service
public class ReplyServiceImpl implements ReplyService {
	
	Logger logger = LoggerFactory.getLogger(ReplyServiceImpl.class);
	
	@Autowired
	private ReplyMapper replyMapper;

	public int deleteByPrimaryKey(Long replyId) throws Exception {
		try {
			return replyMapper.deleteByPrimaryKey(replyId);
		} catch (Exception e) {
			logger.debug("业务层删除回复失败");
			throw new Exception();
		}
	}

	public int insertSelective(Reply record) throws Exception {
		try {
			return replyMapper.insertSelective(record);
		} catch (Exception e) {
			logger.debug("业务层新增回复失败");
			throw new Exception();
		}
	}

	public Reply selectByPrimaryKey(Long replyId) throws Exception {
		try {
			return replyMapper.selectByPrimaryKey(replyId);
		} catch (Exception e) {
			logger.debug("业务层查询回复失败");
			throw new Exception();
		}
	}

	public int updateByPrimaryKey(Reply record) throws Exception {
		try {
			return replyMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			logger.debug("业务层更新回复失败");
			throw new Exception();
		}
	}

}
