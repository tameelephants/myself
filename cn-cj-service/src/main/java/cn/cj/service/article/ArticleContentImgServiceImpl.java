package cn.cj.service.article;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cj.dao.ArticleContentImgMapper;
import cn.cj.entity.ArticleContentImg;

@Service
public class ArticleContentImgServiceImpl implements ArticleContentImgService{

	private Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
	
	@Autowired
	private ArticleContentImgMapper articleContentImgMapper;
	
	public int deleteByPrimaryKey(Long articleContentId) throws Exception {
		try {
			return articleContentImgMapper.deleteByPrimaryKey(articleContentId);
		} catch (Exception e) {
			logger.debug("删除文章内容截图失败");
			throw new Exception();
		}
	}

	public int insertSelective(ArticleContentImg record) throws Exception {
		try {
			return articleContentImgMapper.insertSelective(record);
		} catch (Exception e) {
			logger.debug("新增文章内容截图失败");
			throw new Exception();
		}
	}

	public ArticleContentImg selectByPrimaryKey(Long articleContentId) throws Exception {
		try {
			return articleContentImgMapper.selectByPrimaryKey(articleContentId);
		} catch (Exception e) {
			logger.debug("查询文章内容截图失败");
			throw new Exception();
		}
	}

	public int updateByPrimaryKey(ArticleContentImg record) throws Exception {
		try {
			return articleContentImgMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			logger.debug("更新文章内容截图失败");
			throw new Exception();
		}
	}

	public ArticleContentImg selectArticleConttentImgByRandom(String ramdonAboutArticle) throws Exception {
		try {
			return articleContentImgMapper.selectArticleConttentImgByRandom(ramdonAboutArticle);
		} catch (Exception e) {
			logger.debug("通过随机数获取截图失败");
			throw new Exception();
		}
	}

}