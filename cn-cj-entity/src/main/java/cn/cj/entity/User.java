package cn.cj.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class User  implements Serializable{
	
	private static final long serialVersionUID = -7153612087805159649L;
	
	
    private Long userId;
	
    private String userName;
	
    private String userAccount;
	
    private String userPassword;
	
    private String openId;
	
    private String userImg;
	
    private Date lastLoginTime;
	
    private Long roleId;
	
    private String isDisable;
	
    private String userEmail;

    public Long getUserId() {
        return userId;
    }
    @Field("user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    @Field("user_name")
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }
    @Field("user_account")
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }
    @Field("user_password")
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getOpenId() {
        return openId;
    }
    @Field("open_id")
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getUserImg() {
        return userImg;
    }
    @Field("user_img")
    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    @Field("last_login_time")
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getRoleId() {
        return roleId;
    }
    @Field("role_id")
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getIsDisable() {
        return isDisable;
    }
    @Field("is_disable")
    public void setIsDisable(String isDisable) {
        this.isDisable = isDisable == null ? null : isDisable.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }
    @Field("user_email")
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }
}