package cn.cj.service.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.cj.entity.Permissions;
import cn.cj.entity.Roles;
import cn.cj.entity.User;
import cn.cj.service.user.UserService;

public class MyRealm extends AuthorizingRealm {
	private Logger log = LoggerFactory.getLogger(AuthorizingRealm.class);
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired	
	private UserService userService;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//权限验证调用
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("进入自定Realm,权限验证方法");
		String userName = (String) principals.getPrimaryPrincipal();
		Roles role = userService.getRoleByAccount(userName);
		List<Permissions> permissions = userService.getPermissionsByRole(role);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获取当前subject中的角色
		info.addRole(role.getRoleName());
		List<String> permissionNameList = new ArrayList<String>();
		for (int i = 0; i < permissions.size(); i++) {
			String permissionName = permissions.get(i).getPermissionName();
			log.debug(permissionName);
			permissionNameList.add(permissionName);
		}
		//获取当前subject中的权限集合
		info.addStringPermissions(permissionNameList);
		return info;
	}

	//登录认证调用
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log.info("try login...");
		//参数token为Controller里面传来的参数user对象
		String userName = (String) token.getPrincipal();
		//内部封装(通过用户名查询当前数据库对应的对象并获取密码,通过自定义的sql执行)
		User user = userService.getUserInfoByUser(userName);
/*		if(Boolean.TRUE.equals(user.getLocked())){
			throw new LockedAccountException();
		}
*/		//如果用户名正确
		if(null != user){
			//这里返回的SimpleAuthenticationInfo第二个参数user.getUserPassword()是从数据库获取的数据!
			//token中传过来的密码是前台没有加密的,而对比的数据库密码却是加密过的,
			//所以通过配置文件的设置的1024,md5,此处的加盐设置用来匹配数据库密码!
			ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUserAccount());
			return new SimpleAuthenticationInfo(userName,user.getUserPassword(),credentialsSalt,getName());
		}
		return null;
	}

}
