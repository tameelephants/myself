package cn.cj.entity;

import java.io.Serializable;

public class ArticleContentImg implements Serializable{
	
	private static final long serialVersionUID = -5815013358739219238L;

	private Long articleContentId;
	
	private String articleContentUrl;
	
	private String articleContentRandom;
	

	public String getArticleContentRandom() {
		return articleContentRandom;
	}

	public void setArticleContentRandom(String articleContentRandom) {
		this.articleContentRandom = articleContentRandom;
	}

	public Long getArticleContentId() {
		return articleContentId;
	}

	public void setArticleContentId(Long articleContentId) {
		this.articleContentId = articleContentId;
	}

	public String getArticleContentUrl() {
		return articleContentUrl;
	}

	public void setArticleContentUrl(String articleContentUrl) {
		this.articleContentUrl = articleContentUrl;
	}
	
	
}
