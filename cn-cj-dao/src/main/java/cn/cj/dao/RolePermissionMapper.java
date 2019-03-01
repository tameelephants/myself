package cn.cj.dao;

import cn.cj.entity.RolePermission;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}