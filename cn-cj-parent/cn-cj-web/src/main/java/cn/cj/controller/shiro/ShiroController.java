package cn.cj.controller.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
/**
 * 使用配置文件的方法读取shiro权限
 * @author chenjie
 *
 */
public class ShiroController {
	public static void main(String[] args) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:conf/shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("chenjie","352049432");
		subject.login(token);
		if(subject.isAuthenticated()){
			System.err.println("登录成功");
			//判断角色
			if(subject.hasRole("admin")){
				System.out.println("有admin角色");
			}else{
				System.out.println("没有admin角色");
			}
			//判断权限
			if(subject.isPermitted("del")){
				System.out.println("有del权限");
			}else{
				System.out.println("没有del权限");
			}
			//判断是否同时具有多个权限
			if(subject.isPermittedAll("del","update")){
				System.out.println("有del和update权限");
			}else{
				System.out.println("没有del和update权限");
			}
		}
	}
}
