package cn.cj.dao;

import java.util.List;

import cn.cj.entity.Article;
import cn.cj.tools.LayuiPage;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long articleId);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long articleId);

    int updateByPrimaryKey(Article record);

    /**
     * 获取文章列表(后台)
     * @param pages
     * @return
     */
	List<Article> selectAllArticleInfo(LayuiPage pages);
	
	/**
	 * 获取文章列表总数量(后台)
	 * @return
	 */
	Integer selectArticleTotalCount();

}