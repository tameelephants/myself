package cn.cj.service.article;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cj.dao.ArticleMapper;
import cn.cj.entity.Article;
import cn.cj.tools.LayuiPage;

@Service
public class ArticleServiceImpl implements ArticleService {

	private Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

	@Autowired
	private ArticleMapper articleMapper;

	public int deleteByPrimaryKey(Long articleId)  throws Exception{
		try {
			return articleMapper.deleteByPrimaryKey(articleId);
		} catch (Exception e) {
			logger.debug(e.toString());
			throw new Exception();
		}
	}

	public int insertSelective(Article record)  throws Exception{
		try {
			return articleMapper.insertSelective(record);
		} catch (Exception e) {
			logger.debug(e.toString());
			throw new Exception();
		}
	}

	public Article selectByPrimaryKey(Long articleId)  throws Exception{
		try {
			return articleMapper.selectByPrimaryKey(articleId);
		} catch (Exception e) {
			logger.debug(e.toString());
			throw new Exception();
		}
	}

	public int updateByPrimaryKey(Article record) throws Exception{
		try {
			return articleMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			logger.debug(e.toString());
			throw new Exception();
		}
	}

	public List<Article> selectAllArticleInfo(LayuiPage pages) throws Exception{
		try {
			return articleMapper.selectAllArticleInfo(pages);
		} catch (Exception e) {
			logger.debug(e.toString());
			throw new Exception();
		}
	}

	public Integer selectArticleTotalCount() throws Exception {
		try {
			return articleMapper.selectArticleTotalCount();
		} catch (Exception e) {
			logger.debug(e.toString());
			throw new Exception();
		}
	}

}
