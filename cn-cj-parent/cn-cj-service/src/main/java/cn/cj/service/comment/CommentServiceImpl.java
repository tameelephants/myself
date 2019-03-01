package cn.cj.service.comment;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cj.dao.CommentMapper;
import cn.cj.entity.Comment;
import cn.cj.entity.User;
import cn.cj.tools.Constant;
import cn.cj.tools.LayuiPage;
import cn.cj.tools.ServiceException;

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
			throw new ServiceException("业务层删除评论失败", e);
		}
	}

	public int insertSelective(Comment record) throws Exception {
		try {
			return commentMapper.insertSelective(record);
		} catch (Exception e) {
			logger.debug("业务层新增评论失败");
			throw new ServiceException("业务层新增评论失败", e);
		}
	}

	public Comment selectByPrimaryKey(Long commentId) throws Exception {
		try {
			return commentMapper.selectByPrimaryKey(commentId);
		} catch (Exception e) {
			logger.debug("业务层查询评论失败");
			throw new ServiceException("业务层查询评论失败", e);
		}
	}

	public int updateByPrimaryKey(Comment record) throws Exception {
		try {
			return commentMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			logger.debug("业务层更新评论失败");
			throw new ServiceException("业务层更新评论失败", e);
		}
	}

	public List<Comment> selectAllCommentByArticleId(Long articleId, LayuiPage page) throws Exception{
		try {
			return commentMapper.selectAllCommentByArticleId(articleId, page.getPageX(),page.getLimit());
		} catch (Exception e) {
			logger.debug("获取评论集合失败");
			throw new ServiceException("获取评论集合失败", e);
		}
	}

	
	public void addComment(String commentContext, Long articleId, HttpSession session) throws Exception {
		try {
			Comment comment = new Comment();
			User user = (User) session.getAttribute(Constant.SESSION_USER);
			comment.setArticleId(articleId);
			if(commentContext != null) {
				comment.setCommentContent(commentContext);
				comment.setCommentCreateTime(new Date());
				comment.setCommenter(user.getUserId());
			    commentMapper.insertSelective(comment);
			}else {
				logger.debug("业务层评论不能为空!");
			}
			
		} catch (Exception e) {
			logger.debug("业务层评论失败");
			throw new ServiceException("业务层评论文章失败", e);
		}
	}

}
