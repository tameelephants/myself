package cn.cj.entity;

import java.io.Serializable;

public class Permissions implements Serializable{
	private static final long serialVersionUID = 4011408714602159539L;

	private Long permissionId;

    private String permissionName;

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }
}