package cn.cj.controller.user;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.cj.entity.User;
import cn.cj.service.user.UserService;
import cn.cj.tools.Constant;
import cn.cj.tools.OtherUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserService userService;

	//首页页面跳转
	@RequestMapping("index")
	public String index(){
		return "/index";
	}

	//权限不足页面跳转
	@RequestMapping("error")
	public String error(){
		return "/error";
	}

	//登录页面跳转
	@RequestMapping("login")
	public String login(){
		return "../../login";
	}

	//登录处理
	@RequestMapping("doLogin")
	@ResponseBody
	//登录需要修改成ajax
	public Object doLogin(User user,@RequestParam(value="rememberMe",defaultValue="0")String rememberMe, HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			User users = userService.doLogin(user,rememberMe);
			if(null != users){
				if(users.getIsDisable().equals("N")){
					result.put(Constant.LOGIN_CODE, "0");
					result.put(Constant.LOGIN_INFO, "我们已经发送一封邮箱到"+ users.getUserEmail() +"，请激活邮箱进行验证");
					//发送邮件
				}else if(users.getIsDisable().equals("Y")){
					result.put(Constant.LOGIN_CODE, "1");
					result.put(Constant.LOGIN_INFO, "登录成功");
				}
			}
		} catch(ExcessiveAttemptsException e){
			logger.debug("登录次数超过6次，账号锁定10分钟");
			result.put(Constant.LOGIN_CODE, "-1");
			result.put(Constant.LOGIN_INFO, "登录次数超过6次，账号锁定10分钟");
		} catch (IncorrectCredentialsException e) {
			logger.debug("密码不正确");
			result.put(Constant.LOGIN_CODE, "-1");
			result.put(Constant.LOGIN_INFO, "用户名/密码不正确");
		} catch (LockedAccountException e) {
			logger.debug("账号被锁定");
			result.put(Constant.LOGIN_CODE, "-1");
			result.put(Constant.LOGIN_INFO, "当前账号被锁定");
		} catch (DisabledAccountException e) {
			logger.debug("账号被禁用");
			result.put(Constant.LOGIN_CODE, "-1");
			result.put(Constant.LOGIN_INFO, "当前账号被禁用");
		} catch (ExpiredCredentialsException e) {
			logger.debug("当前账号已过期");
			result.put(Constant.LOGIN_CODE, "-1");
			result.put(Constant.LOGIN_INFO, "当前账号已过期");
		} catch (UnknownAccountException e) {
			logger.debug("用户名未知");
			result.put(Constant.LOGIN_CODE, "-1");
			result.put(Constant.LOGIN_INFO, "用户名/密码不正确");
		} catch (NullPointerException e) {
			logger.debug("账号或密码为空值");
			result.put(Constant.LOGIN_CODE, "-1");
			result.put(Constant.LOGIN_INFO, "用户名/密码为空");
		} catch(AuthenticationException e){
			logger.debug("用户名错误");
			result.put(Constant.LOGIN_CODE, "-1");
			result.put(Constant.LOGIN_INFO, "用户名/密码不正确");
		}
		return JSON.toJSONString(result);
	}

	//产生图片验证码
	@RequestMapping("createverifyCode")
	public void verifyCode(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException{
		//设置没有缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		//设置时间
		response.setDateHeader("Expires", 0);
		//告诉浏览器服务器传输的数据类型
		response.setContentType("image/jpeg");
		//获取4位自定义随机数
		String verifyCode = OtherUtils.getCustomRandom(4);
		int width = 60;
		int height = 36;
		//调用创建图片方法
		OtherUtils.outputImg(width,height,response.getOutputStream(),verifyCode);
		//清除当前自定义验证码并重新放入
		session.removeAttribute("verifyCode");
		session.setAttribute("verifyCode", verifyCode.toLowerCase());
	}

	//注册
	@RequestMapping(value = "doRegister",method = RequestMethod.POST)
	@ResponseBody
	public Object doRegister(HttpServletRequest request,HttpServletResponse response, 
			@Param("verifyCode")String verifyCode,@Param("register_userAccount")String register_userAccount,
			@Param("register_userPassword")String register_userPassword,@Param("register_userEmail")String register_userEmail) throws IOException{
		Map<String, Object> result = new HashMap<String, Object>();
		User user = new User();
		user.setUserAccount(register_userAccount);
		SimpleHash md5Password = new SimpleHash("MD5",register_userPassword,register_userAccount,1024);
		user.setUserPassword(md5Password.toHex().toString());
		user.setUserEmail(register_userEmail);
		HttpSession session = request.getSession(true);
		String verifyCodeSession = (String) session.getAttribute("verifyCode");
		//判断验证码是否相等
		if(verifyCode.equals(verifyCodeSession)){
			User isUser = userService.getUserInfoByUser(user.getUserAccount());
			if(null == isUser){
				//注册
				Integer flag = userService.addUserByRegister(user);
				if(flag <= 0){
					result.put(Constant.REGISTER_CODE, "-1");
					result.put(Constant.REGISTER_INFO, "当前注册出错，请联系管理员");
					logger.debug("注册插入用户数据失败");
				}else{
					result.put(Constant.REGISTER_CODE, "1");
					result.put(Constant.REGISTER_INFO, "注册成功");	
				}
			}else{
				if(isUser.getIsDisable().equals("N")){
					result.put(Constant.REGISTER_CODE, "2");
					result.put(Constant.REGISTER_INFO, "该用户已被注册");
					logger.debug("该用户已经注册，但是没有进行邮箱验证");
					//发送邮件
				}else if(isUser.getIsDisable().equals("Y")){
					result.put(Constant.REGISTER_CODE, "3");
					result.put(Constant.REGISTER_INFO, "该用户已被注册");
				}
			}
		}else{
			result.put(Constant.REGISTER_CODE, "4");
			result.put(Constant.REGISTER_INFO, "验证码不正确");
		}
		//		response.setCharacterEncoding("UTF-8");
		//		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		//		response.getWriter().write("<font color='green' size='25'>注册成功...3秒之后跳转到登录页</font>");
		//     response.setHeader("Refresh", "3;URL="+request.getContextPath()+"/user/index");
		return JSON.toJSONString(result);
	}
}




//以下代码注释因为在spring-mybatis.xml文件中有配置

//1.创建一个默认的securityManager核心
//DefaultSecurityManager securityManager = new DefaultSecurityManager();
//2.设置认证策略(至少需要验证一个)
//ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
//authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
//3.设置权限策略
//ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
//authorizer.setPermissionResolver(new WildcardPermissionResolver());
//4.自定义数据源
//4.5 注入自定义数据源的Template参数
//securityManager.setRealm(new MyRealm());
//5.通过shiro提供的工具类设置securityManager管理器
//SecurityUtils.setSecurityManager(securityManager);
//6.获得和系统交互的对象
//Subject subject = SecurityUtils.getSubject();
//7.设置用户名和密码验证token
//UsernamePasswordToken token = new UsernamePasswordToken(user.getUserAccount(),user.getUserPassword());
//8.subject.login()