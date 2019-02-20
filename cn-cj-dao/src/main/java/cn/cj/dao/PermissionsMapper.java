package cn.cj.dao;

import java.util.List;

import cn.cj.entity.Permissions;

public interface PermissionsMapper {
    int deleteByPrimaryKey(Long permissionId);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    Permissions selectByPrimaryKey(Long permissionId);

    int updateByPrimaryKeySelective(Permissions record);

    
    
    /**
     * 通过用户角色获取当前用户权限列表
     * @param roleName
     * @return
     */
	List<Permissions> getPermissionsByRoleName(String roleName);
}