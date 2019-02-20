package cn.cj.service.comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cj.dao.CommentMapper;
import cn.cj.entity.Comment;

/**
 * 评论业务层
 * @author Elephant
 *
 */

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	
	private Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

	public int deleteByPrimaryKey(Long commentId) throws Exception {
		try {
			return commentMapper.deleteByPrimaryKey(commentId);
		} catch (Exception e) {
			logger.debug("业务层删除评论失败");
			throw new Exception();
		}
	}

	public int insertSelective(Comment record) throws Exception {
		try {
			return commentMapper.insertSelective(record);
		} catch (Exception e) {
			logger.debug("业务层新增评论失败");
			throw new Exception();
		}
	}

	public Comment selectByPrimaryKey(Long commentId) throws Exception {
		try {
			return commentMapper.selectByPrimaryKey(commentId);
		} catch (Exception e) {
			logger.debug("业务层查询评论失败");
			throw new Exception();
		}
	}

	public int updateByPrimaryKey(Comment record) throws Exception {
		try {
			return commentMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			logger.debug("业务层更新评论失败");
			throw new Exception();
		}
	}

}
