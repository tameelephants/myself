package cn.cj.entity;

import java.io.Serializable;

public class RolePermission implements Serializable{
	private static final long serialVersionUID = 2440221085823032140L;

	private Long roleId;

    private Long peimissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPeimissionId() {
        return peimissionId;
    }

    public void setPeimissionId(Long peimissionId) {
        this.peimissionId = peimissionId;
    }
}