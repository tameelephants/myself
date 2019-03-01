package cn.cj.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章点赞实体类
 * @author elephant
 *
 */
public class ArticlePraise implements Serializable{

	private static final long serialVersionUID = -7331482377280140240L;
	
	private Long articlePraiseId;
	
	private Date articlePraiseCreateTime;
	
	private Long articlePraiser;
	
	private Long articleId;

	public Long getArticlePraiseId() {
		return articlePraiseId;
	}

	public void setArticlePraiseId(Long articlePraiseId) {
		this.articlePraiseId = articlePraiseId;
	}

	public Date getArticlePraiseCreateTime() {
		return articlePraiseCreateTime;
	}

	public void setArticlePraiseCreateTime(Date articlePraiseCreateTime) {
		this.articlePraiseCreateTime = articlePraiseCreateTime;
	}

	public Long getArticlePraiser() {
		return articlePraiser;
	}

	public void setArticlePraiser(Long articlePraiser) {
		this.articlePraiser = articlePraiser;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

}
