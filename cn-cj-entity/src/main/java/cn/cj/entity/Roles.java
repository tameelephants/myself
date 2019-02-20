package cn.cj.entity;

import java.io.Serializable;

public class Roles implements Serializable{
	private static final long serialVersionUID = -1410707714702477026L;

	private Long roleId;

    private String roleName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}