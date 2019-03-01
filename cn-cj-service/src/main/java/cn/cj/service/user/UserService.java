package cn.cj.service.user;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;

import cn.cj.entity.Permissions;
import cn.cj.entity.Roles;
import cn.cj.entity.User;

public interface UserService {

	/**
	 * 根据账号密码获取当前用户信息
	 * @param user
	 * @return
	 */
	User getUserInfoByUser(String userName);
	
	/**
	 * 登录认证业务处理
	 * @param user
	 * @return
	 */
	User doLogin(User user,String rememberMe) throws AuthenticationException;

	/**
	 * 通过用户名查找角色
	 * @param userName
	 * @return
	 */
	Roles getRoleByAccount(String userName);

	/**
	 * 通过用户角色查询当前权限集合
	 * @param role
	 * @return
	 */
	List<Permissions> getPermissionsByRole(Roles role);

	/**
	 * 注册
	 * @param user
	 */
	Integer addUserByRegister(User user);

}
