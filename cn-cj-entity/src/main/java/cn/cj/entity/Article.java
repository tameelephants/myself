package cn.cj.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Article implements Serializable{
	private static final long serialVersionUID = 730303880829804895L;

	private Long articleId;

    private String articleTitle;

    private String articleLabel;

    private Date articleCreateTime;

    private Long articleCreater;

    private Long articleAuthor;

    private Date articleDeleteTime; 

    private Long articleDeleter;

    private String articleDeleteFlag;

    private Date articleUpdateTime;

    private Long articleUpdater;

    private Long articlePraise;

    private Long articleClickNum;

    private String articleContent;
    
    private String articleBgimg;
    
    private int isPutaway;
    
    
    
    
    //文章作者
    private User userAuthor;
    //文章发布人
    private User userCreater;
    //文章评论集合
    private List<Comment> commentList;
    
    
    
	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public User getUserAuthor() {
		return userAuthor;
	}

	public void setUserAuthor(User userAuthor) {
		this.userAuthor = userAuthor;
	}

	public User getUserCreater() {
		return userCreater;
	}

	public void setUserCreater(User userCreater) {
		this.userCreater = userCreater;
	}

	public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleLabel() {
        return articleLabel;
    }

    public void setArticleLabel(String articleLabel) {
        this.articleLabel = articleLabel == null ? null : articleLabel.trim();
    }

    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    public Long getArticleCreater() {
        return articleCreater;
    }

    public void setArticleCreater(Long articleCreater) {
        this.articleCreater = articleCreater;
    }

    public Long getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(Long articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public Date getArticleDeleteTime() {
        return articleDeleteTime;
    }

    public void setArticleDeleteTime(Date articleDeleteTime) {
        this.articleDeleteTime = articleDeleteTime;
    }

    public Long getArticleDeleter() {
        return articleDeleter;
    }

    public void setArticleDeleter(Long articleDeleter) {
        this.articleDeleter = articleDeleter;
    }

    public String getArticleDeleteFlag() {
        return articleDeleteFlag;
    }

    public void setArticleDeleteFlag(String articleDeleteFlag) {
        this.articleDeleteFlag = articleDeleteFlag == null ? null : articleDeleteFlag.trim();
    }

    public Date getArticleUpdateTime() {
        return articleUpdateTime;
    }

    public void setArticleUpdateTime(Date articleUpdateTime) {
        this.articleUpdateTime = articleUpdateTime;
    }

    public Long getArticleUpdater() {
        return articleUpdater;
    }

    public void setArticleUpdater(Long articleUpdater) {
        this.articleUpdater = articleUpdater;
    }

    public Long getArticlePraise() {
        return articlePraise;
    }

    public void setArticlePraise(Long articlePraise) {
        this.articlePraise = articlePraise;
    }

    public Long getArticleClickNum() {
        return articleClickNum;
    }

    public void setArticleClickNum(Long articleClickNum) {
        this.articleClickNum = articleClickNum;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

	public String getArticleBgimg() {
		return articleBgimg;
	}

	public void setArticleBgimg(String articleBgimg) {
		this.articleBgimg = articleBgimg;
	}

	public int getIsPutaway() {
		return isPutaway;
	}

	public void setIsPutaway(int isPutaway) {
		this.isPutaway = isPutaway;
	}

	public Article(Long articleId, String articleTitle, String articleLabel, Date articleCreateTime,
			Long articleCreater, Long articleAuthor, Date articleDeleteTime, Long articleDeleter,
			String articleDeleteFlag, Date articleUpdateTime, Long articleUpdater, Long articlePraise,
			Long articleClickNum, String articleContent, String articleBgimg, int isPutaway, User userAuthor,
			User userCreater) {
		super();
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.articleLabel = articleLabel;
		this.articleCreateTime = articleCreateTime;
		this.articleCreater = articleCreater;
		this.articleAuthor = articleAuthor;
		this.articleDeleteTime = articleDeleteTime;
		this.articleDeleter = articleDeleter;
		this.articleDeleteFlag = articleDeleteFlag;
		this.articleUpdateTime = articleUpdateTime;
		this.articleUpdater = articleUpdater;
		this.articlePraise = articlePraise;
		this.articleClickNum = articleClickNum;
		this.articleContent = articleContent;
		this.articleBgimg = articleBgimg;
		this.isPutaway = isPutaway;
		this.userAuthor = userAuthor;
		this.userCreater = userCreater;
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
}