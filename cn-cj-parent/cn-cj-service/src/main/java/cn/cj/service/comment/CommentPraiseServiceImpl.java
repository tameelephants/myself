package cn.cj.service.comment;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cj.dao.CommentMapper;
import cn.cj.dao.CommentPraiseMapper;
import cn.cj.entity.Comment;
import cn.cj.entity.CommentPraise;
import cn.cj.tools.ServiceException;

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
	
	@Autowired
	private CommentMapper commentMapper;

	public int deleteByPrimaryKey(Long commentPraiseId) throws Exception {
		try {
			return commentPraiseMapper.deleteByPrimaryKey(commentPraiseId);
		} catch (Exception e) {
			logger.debug("删除评论点赞失败");
			throw new ServiceException("删除评论点赞失败");
		}
	}

	public int insertSelective(CommentPraise record) throws Exception {
		try {
			return commentPraiseMapper.insertSelective(record);
		} catch (Exception e) {
			logger.debug("新增评论点赞失败");
			throw new ServiceException("新增评论点赞失败");
		}
	}

	public CommentPraise selectByPrimaryKey(Long commentPraiseId) throws Exception {
		try {
			return commentPraiseMapper.selectByPrimaryKey(commentPraiseId);
		} catch (Exception e) {
			logger.debug("查询评论点赞失败");
			throw new ServiceException("查询评论点赞失败");
		}
	}

	public int updateByPrimaryKey(CommentPraise record) throws Exception {
		try {
			return commentPraiseMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			logger.debug("更新评论点赞失败");
			throw new ServiceException("更新评论点赞失败");
		}
	}

	public int isDoPraise(Long commentId, Long userId) throws Exception {
		try {
			return commentPraiseMapper.isDoPraise(commentId, userId);
		} catch (Exception e) {
			logger.debug("查询点赞数失败");
			throw new ServiceException("查询点赞数失败");
		}
	}

	public int doPraise(Long commentId, Long userId, Long praiseNum) throws Exception{
		try {
			CommentPraise cp = new CommentPraise();
			Comment comment = new Comment();
			synchronized(this){
				comment.setPraiseNum(praiseNum);
				comment.setCommentId(commentId);
				commentMapper.updateByPrimaryKey(comment);
			}
			cp.setCommentPraiseCreateTime(new Date());
			cp.setCommentId(commentId);
			cp.setCommentPraiser(userId);
			return commentPraiseMapper.insertSelective(cp);
		} catch (Exception e) {
			logger.debug("点赞失败");
			throw new ServiceException("点赞失败");
		}
	}

}
