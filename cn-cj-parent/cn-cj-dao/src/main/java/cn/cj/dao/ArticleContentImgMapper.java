package cn.cj.dao;

import cn.cj.entity.ArticleContentImg;

public interface ArticleContentImgMapper {
	
	int deleteByPrimaryKey(Long articleContentId);
	
	int insertSelective(ArticleContentImg record);
	
	int updateByPrimaryKey(ArticleContentImg record);
	
	ArticleContentImg selectByPrimaryKey(Long articleContentId);
	
	
	
	/**
	 * 通过随机数获取当前对象 
	 * @param ramdonAboutArticle
	 * @return
	 */
	ArticleContentImg selectArticleConttentImgByRandom(String ramdonAboutArticle);
}
