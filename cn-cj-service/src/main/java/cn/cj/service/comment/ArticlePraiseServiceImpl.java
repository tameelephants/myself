package cn.cj.service.comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cj.dao.ArticlePraiseMapper;
import cn.cj.entity.ArticlePraise;
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
			throw new Exception();
		}
	}

}
