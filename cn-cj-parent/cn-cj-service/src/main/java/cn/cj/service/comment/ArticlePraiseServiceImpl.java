package cn.cj.service.comment;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cj.dao.ArticleMapper;
import cn.cj.dao.ArticlePraiseMapper;
import cn.cj.entity.Article;
import cn.cj.entity.ArticlePraise;
import cn.cj.tools.ServiceException;
/**
 * 文章点赞业务层
 * @author Elephant
 *
 */

@Service
public class ArticlePraiseServiceImpl implements ArticlePraiseService {
	
	Logger logger = LoggerFactory.getLogger(ArticlePraiseServiceImpl.class);
	
	@Autowired
	private ArticlePraiseMapper articlePraiseMapper;
	
	@Autowired
	private ArticleMapper articleMapper;
	
	public int deleteByPrimaryKey(Long articlePraiseId) throws Exception {
		try {
			return articlePraiseMapper.deleteByPrimaryKey(articlePraiseId);
		} catch (Exception e) {
			logger.debug("删除文章点赞失败");
			throw new Exception();
		}
	}

	public int insertSelective(ArticlePraise record) throws Exception {
		try {
			return articlePraiseMapper.insertSelective(record);
		} catch (Exception e) {
			logger.debug("新增文章点赞失败");
			throw new Exception();
		}
	}

	public ArticlePraise selectByPrimaryKey(Long articlePraiseId) throws Exception {
		try {
			return articlePraiseMapper.selectByPrimaryKey(articlePraiseId);
		} catch (Exception e) {
			logger.debug("查询文章点赞失败");
			throw new Exception();
		}
	}

	public int updateByPrimaryKey(ArticlePraise record) throws Exception {
		try {
			return articlePraiseMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			logger.debug("更新文章点赞失败");
			throw new ServiceException("更新文章点赞失败",e);
		}
	}

	public int doPraise(Long articleId, Long userId, Long praiseNum) throws Exception{
		try {
			Article article = new Article();
			ArticlePraise ap = new ArticlePraise();
			synchronized(this){
				article.setArticlePraise(praiseNum);
				article.setArticleId(articleId);
				articleMapper.updateByPrimaryKey(article);
			}
			ap.setArticlePraiseCreateTime(new Date());
			ap.setArticlePraiser(userId);
			ap.setArticleId(articleId);
			return articlePraiseMapper.insertSelective(ap);
			
		} catch (Exception e) {
			logger.debug("文章点赞失败");
			throw new ServiceException("文章点赞失败",e);
		}
	}

	public int isDoPraise(Long articleId, Long userId) throws Exception {
		try {
			return articlePraiseMapper.isDoPraise(articleId,userId);
		} catch (Exception e) {
			logger.debug("查询文章点赞失败");
			throw new ServiceException("查询文章点赞失败",e);
		}
	}

}
