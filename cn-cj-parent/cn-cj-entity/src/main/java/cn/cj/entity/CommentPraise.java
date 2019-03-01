package cn.cj.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论点赞实体类
 * @author elephant
 *
 */
public class CommentPraise implements Serializable{

	private static final long serialVersionUID = 745413864246527946L;
	
	private Long commentPraiseId;
	
	private Date commentPraiseCreateTime;
	
	private Long commentPraiser;
	
	private Long commentId;

	public Long getCommentPraiseId() {
		return commentPraiseId;
	}

	public void setCommentPraiseId(Long commentPraiseId) {
		this.commentPraiseId = commentPraiseId;
	}

	public Date getCommentPraiseCreateTime() {
		return commentPraiseCreateTime;
	}

	public void setCommentPraiseCreateTime(Date commentPraiseCreateTime) {
		this.commentPraiseCreateTime = commentPraiseCreateTime;
	}

	public Long getCommentPraiser() {
		return commentPraiser;
	}

	public void setCommentPraiser(Long commentPraiser) {
		this.commentPraiser = commentPraiser;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	} 
}
