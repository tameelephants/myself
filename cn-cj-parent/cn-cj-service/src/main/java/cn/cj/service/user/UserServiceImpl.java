package cn.cj.service.user;


import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cj.dao.PermissionsMapper;
import cn.cj.dao.RolesMapper;
import cn.cj.dao.UserMapper;
import cn.cj.entity.Permissions;
import cn.cj.entity.Roles;
import cn.cj.entity.User;
import cn.cj.tools.Constant;

@Service
public class UserServiceImpl implements UserService{
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired RolesMapper rolesMapper;
	
	@Autowired
	private PermissionsMapper permissionMapper;
	
	
	public User getUserInfoByUser(String userName) {
		User users = null;
		if(null != userName){
			users = userMapper.selectByUserAccount(userName);
		}
		return users;
	}

	public User doLogin(User user,String rememberMe) throws AuthenticationException{
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserAccount(),user.getUserPassword());
		//用户勾选记住我
		if(rememberMe.equals("1")){
			token.setRememberMe(true);
			
		}
		subject.login(token);
		User users = getUserInfoByUser(user.getUserAccount());
		
		//加盐匹配密码(此处的encodedPassword是用户前台输入的密码进行1024次md5加密)
		SimpleHash hash = new SimpleHash("md5", user.getUserPassword(),
				user.getUserAccount(), 1024);
		String encodedPassword = hash.toHex();
		//对比encodedPassword和数据库查询到的密码是否匹配(*用户输入和数据库的进行对比)
		if(null != users && 
				users.getUserPassword().equals(encodedPassword)){
			User us = new User();
			us.setLastLoginTime(new Date());
			us.setUserId(users.getUserId());
			//插入最后登陆时间
			int flag = userMapper.updateByPrimaryKeySelective(us);
			if(flag <= 0){
				logger.debug("用户最后一次登陆时间插入失败");
			}
		}
		session.setAttribute(Constant.SESSION_USER, users);
		return users;
	}

	public Roles getRoleByAccount(String userName) {
		return rolesMapper.getRoleByAccount(userName);
	}

	public List<Permissions> getPermissionsByRole(Roles role) {
		return permissionMapper.getPermissionsByRoleName(role.getRoleName());
	}

	public Integer addUserByRegister(User user) {
		return userMapper.insertSelective(user);
	}

	
}
