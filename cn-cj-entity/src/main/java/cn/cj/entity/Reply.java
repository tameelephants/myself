package cn.cj.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 回复实体类
 * @author Elephant
 *
 */
public class Reply implements Serializable{

	private static final long serialVersionUID = -6758976786014772448L;

	private Long replyId;
	
	private Long commentId;
	
	private String replyContent;
	
	private Date replyCreateTime;
	
	private Long replier;

	public Long getReplyId() {
		return replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyCreateTime() {
		return replyCreateTime;
	}

	public void setReplyCreateTime(Date replyCreateTime) {
		this.replyCreateTime = replyCreateTime;
	}

	public Long getReplier() {
		return replier;
	}

	public void setReplier(Long replier) {
		this.replier = replier;
	}
	
	
}
