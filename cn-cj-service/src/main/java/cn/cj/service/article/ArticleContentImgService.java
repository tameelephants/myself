package cn.cj.service.article;

import cn.cj.entity.ArticleContentImg;

public interface ArticleContentImgService {
	int deleteByPrimaryKey(Long articleContentId) throws Exception;

    int insertSelective(ArticleContentImg record) throws Exception;

    ArticleContentImg selectByPrimaryKey(Long articleContentId) throws Exception;

    int updateByPrimaryKey(ArticleContentImg record) throws Exception;
    
    
    
    /**
	 * 通过随机数获取当前对象 
	 * @param ramdonAboutArticle
	 * @return
	 */
    ArticleContentImg selectArticleConttentImgByRandom(String ramdonAboutArticle) throws Exception;

}
