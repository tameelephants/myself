package cn.cj.service.label;

import java.util.List;

import cn.cj.entity.Label;

public interface LabelService {
	int deleteByPrimaryKey(Long articleId) throws Exception;

    int insertSelective(Label record) throws Exception;

    Label selectByPrimaryKey(Long articleId) throws Exception;

    int updateByPrimaryKey(Label record) throws Exception;

    
    
    //获取所有标签
	List<Label> selectAllLabelList() throws Exception;
}
