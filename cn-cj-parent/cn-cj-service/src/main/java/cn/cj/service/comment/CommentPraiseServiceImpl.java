package cn.cj.service.comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cj.dao.CommentPraiseMapper;
import cn.cj.entity.CommentPraise;

/**
 * 评论点赞业务层
 * @author Elephant
 *
 */

@Service
public class CommentPraiseServiceImpl implements CommentPraiseService {
	
	Logger logger = LoggerFactory.getLogger(CommentPraiseServiceImpl.class);
	
	@Autowired
	private CommentPraiseMapper commentPraiseMapper;

	public int deleteByPrimaryKey(Long commentPraiseId) throws Exception {
		try {
			return commentPraiseMapper.deleteByPrimaryKey(commentPraiseId);
		} catch (Exception e) {
			logger.debug("删除评论点赞失败");
			throw new Exception();
		}
	}

	public int insertSelective(CommentPraise record) throws Exception {
		try {
			return commentPraiseMapper.insertSelective(record);
		} catch (Exception e) {
			logger.debug("新增评论点赞失败");
			throw new Exception();
		}
	}

	public CommentPraise selectByPrimaryKey(Long commentPraiseId) throws Exception {
		try {
			return commentPraiseMapper.selectByPrimaryKey(commentPraiseId);
		} catch (Exception e) {
			logger.debug("查询评论点赞失败");
			throw new Exception();
		}
	}

	public int updateByPrimaryKey(CommentPraise record) throws Exception {
		try {
			return commentPraiseMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			logger.debug("更新评论点赞失败");
			throw new Exception();
		}
	}

}
