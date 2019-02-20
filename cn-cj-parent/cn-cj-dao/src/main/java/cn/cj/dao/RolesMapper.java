package cn.cj.dao;

import org.apache.ibatis.annotations.Param;

import cn.cj.entity.Roles;

public interface RolesMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);
    
    /**
     * 通过用户名获取当前角色
     * @param userName
     * @return
     */
	Roles getRoleByAccount(@Param("userAccount") String userAccount);
}