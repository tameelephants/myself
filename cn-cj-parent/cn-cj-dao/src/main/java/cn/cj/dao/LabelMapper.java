package cn.cj.dao;

import java.util.List;

import cn.cj.entity.Label;

public interface LabelMapper {
	int deleteByPrimaryKey(Long articleId);

    int insertSelective(Label record);

    Label selectByPrimaryKey(Long articleId);

    int updateByPrimaryKey(Label record);

    
    /**
     * 获取所有标签集合
     * @return
     */
	List<Label> selectAllLabelList();
}
