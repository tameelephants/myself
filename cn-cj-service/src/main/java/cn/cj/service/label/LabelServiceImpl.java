package cn.cj.service.label;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cj.dao.LabelMapper;
import cn.cj.entity.Label;

@Service
public class LabelServiceImpl implements LabelService {

	Logger logger = LoggerFactory.getLogger(LabelServiceImpl.class);
	
	@Autowired
	private LabelMapper labelMapper;
	
	public int deleteByPrimaryKey(Long articleId) throws Exception {
		try {
			return labelMapper.deleteByPrimaryKey(articleId);
		} catch (Exception e) {
			logger.debug("删除标签失败",e);
			throw new Exception();
		}
	}

	public int insertSelective(Label record) throws Exception {
		try {
			return labelMapper.insertSelective(record);
		} catch (Exception e) {
			logger.debug("新增标签失败",e);
			throw new Exception();
		}
	}

	public Label selectByPrimaryKey(Long articleId) throws Exception {
		try {
			return labelMapper.selectByPrimaryKey(articleId);
		} catch (Exception e) {
			logger.debug("查询标签失败",e);
			throw new Exception();
		}
	}

	public int updateByPrimaryKey(Label record) throws Exception {
		try {
			return labelMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			logger.debug("修改标签失败",e);
			throw new Exception();
		}
	}

	public List<Label> selectAllLabelList() throws Exception{
		try {
			return labelMapper.selectAllLabelList();
		} catch (Exception e) {
			logger.debug("获取所有标签失败",e);
			throw new Exception();
		}
	}

}
