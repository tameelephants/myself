package cn.cj.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *  评论实体类
 * @author elephant
 *
 */
public class Comment implements Serializable{

	private static final long serialVersionUID = 7108303163061209975L;

	private Long commentId;
	
	private String commentContent;
	
	private Date commentCreateTime;
	
	private Long commenter;
	
	private Long articleId;
	
	private Long praiseNum;
	
	
	//评论人信息
	private User commentor;
	
	public User getCommentor() {
		return commentor;
	}

	public void setCommentor(User commentor) {
		this.commentor = commentor;
	}

	//作者回复
	private Reply reply;
	
	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentCreateTime() {
		return commentCreateTime;
	}

	public void setCommentCreateTime(Date commentCreateTime) {
		this.commentCreateTime = commentCreateTime;
	}

	public Long getCommenter() {
		return commenter;
	}

	public void setCommenter(Long commenter) {
		this.commenter = commenter;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public Long getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Long praiseNum) {
		this.praiseNum = praiseNum;
	}
}
