package cn.cj.service.article;

import java.util.List;

import cn.cj.entity.Article;
import cn.cj.tools.LayuiPage;

public interface ArticleService {
    int deleteByPrimaryKey(Long articleId) throws Exception;

    int insertSelective(Article record) throws Exception;

    Article selectByPrimaryKey(Long articleId) throws Exception;

    int updateByPrimaryKey(Article record) throws Exception;

    /**
     * 	展示文章列表(后台)
     * @param pages
     * @return
     * @throws Exception
     */
	List<Article> selectAllArticleInfo(LayuiPage pages) throws Exception;

    /**
     *  获取文章列表总数量(后台)
     * @return
     * @throws Exception
     */
	Integer selectArticleTotalCount() throws Exception;

}
