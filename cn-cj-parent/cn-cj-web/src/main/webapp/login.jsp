<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>被驯服的象</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/layui/css/layui.css">
<link type="text/css" rel="styleSheet"
	href="<c:url value="/statics/css/login.css"></c:url>" />
</head>
<body>   
	<div class="loginAll">
		
		<input type="hidden" value="${pageContext.request.contextPath }" id="path">
		
		
		<ul class="login_controller">
			<li class="flip-container" >
				<a href="javascript:void(0);" class="flipper">
				
					<!-- 正面 -->
					<div class="front">
						
						<!-- 嵌入登录 -->
						<div class="login-big">
							<div class="login-small">
								<!-- 表单标题 -->
								<div class="login-title"><img src="${pageContext.request.contextPath }/statics/img/logo.png"></div>
								
								<!-- 登录提示信息 -->
								<div class="error login_error">
									<c:if test="${not empty LOGIN_INFO}">
										<span><i class="layui-icon layui-icon-close-fill"></i></span>
									</c:if>
								</div>
								
								<!-- 表单组件 -->
								<div class="login-form">
									<form action="${pageContext.request.contextPath}/user/doLogin"
										method="post" id="login-user">
										
										<div style="margin:5px 0px;">
										
											<!-- 用户名 -->
											<div class="layui-form-item">
												<div class="layui-input-inline">
													<div class="icon_account"><i class="layui-icon layui-icon-username"></i></div>
													<input id="tableIn_login" tabIndex="1" type="text" name="userAccount" required
															lay-verify="required" placeholder="请输入邮箱/手机号/用户名" autocomplete="off"
															class="layui-input userAccount border-green">
												</div>
											</div>
											<!-- 密码框 -->
											<div class="layui-form-item showPwd">
												<div class="layui-input-inline reloadPwd login-reload">
														<div class="icon_account"><i class="layui-icon layui-icon-password"></i></div>
													<input tabIndex="2" type="password" name="userPassword" required
														lay-verify="required" placeholder="请输入密码" autocomplete="off"
														class="layui-input userPassword border-green">
														<div onclick="showPwd(this)" class="show_pwd"><i class="glyphicon glyphicon-eye-open" style="font-size: 18px;"></i></div>
												</div>
											</div>
											<!-- 复选框 -->
											<div class="rememberMe_controller">
											    <div class="rememberMes">
											      <input class="rememberMe" type="checkbox" checked name="rememberMe" value="1" title="记住我"><label>记住我</label>
											    </div>
											</div>  
											<!-- 登录按钮 -->
											<div class="layui-form-item">
											    <div class="layui-btn layui-btn-fluid" onclick="loginOrRegister(this)">
											      	<button tabIndex="3" onkeydown="if(event.keyCode==9)document.getElementById('tableIn_login').focus();" class="layui-btn login" type="button" >登录</button>
											    </div>
											</div>
											
										</div>
										
									</form>
								</div>
								<!-- 忘记密码 -->
								<div class="login-help">
									<span class="register" onclick="overturn()">注册新用户</span>
									<span class="forgetPassword">忘记密码？</span>
								</div>
								<!-- 一键登录 -->
								<div class="login-others">
									<span>其他登录</span>
									<span class="yijian_img">
										<img alt="QQ登录" width="30px" height="30px" src="${pageContext.request.contextPath }/statics/img/QQ.png">
										<img alt="微博登录" width="30px" height="30px" src="${pageContext.request.contextPath }/statics/img/blog.png">
										<img alt="微信登录" width="30px" height="30px" src="${pageContext.request.contextPath }/statics/img/wechat.png">
									</span>
								</div>
							</div>
						</div>
						
						
					</div>
					
					
					<!-- 背面 -->
					<div class="back">
					
					
						<!-- 嵌入注册 -->
						<div class="login-big">
							<div class="login-small">
								<!-- 表单标题 -->
								<div class="login-title"><img src="${pageContext.request.contextPath }/statics/img/logoRed.png"></div>
								
								<!-- 注册提示信息 -->
								<div class="error register_error">
									<c:if test="${not empty REGISTER_INFO}">
										<span><i class="layui-icon layui-icon-close-fill">&nbsp;</i> ${REGISTER_INFO }请输入邮箱</span>
									</c:if>
									
								</div>
								
								<!-- 表单组件 -->
								<div class="login-form">
									<form action="${pageContext.request.contextPath}/user/doRegister"
										method="post" id="register-user" style="margin-top:-10px;">
										
										<div>
										
											<!-- 用户名 -->
											<div class="layui-form-item">
												<div class="layui-input-inline">
													<div class="icon_account"><i class="layui-icon layui-icon-username"></i></div>
													<input id="tableIn_register" onblur="isUserAccount()" type="text" name="userAccount" required
															lay-verify="required" placeholder="请输入邮箱/手机号/用户名" autocomplete="off"
															class="layui-input register-userAccount border-red">
												</div>
											</div>
											<!-- 密码框 -->
											<div class="layui-form-item showPwd">
												<div class="layui-input-inline reloadPwd register-reload">
													<div class="icon_account"><i class="layui-icon layui-icon-password"></i></div>
													<input onblur="isUserPassword()" type="password" name="userPassword" required
														lay-verify="required" placeholder="请输入密码" autocomplete="off"
														class="layui-input register-userPassword border-red">
													<div onclick="showPwd(this)" class="show_pwd eg"><i class="glyphicon glyphicon-eye-open" style="font-size: 18px;"></i></div>
												</div>
											</div>
											
											<!-- 邮箱 -->
											<div class="layui-form-item">
												<div class="layui-input-inline ">
													<div class="icon_account glyphiconEnvelope"><i class="glyphicon glyphicon-envelope"></i></div>
													<input onblur="isUserEamil()" type="text" name="userEmail" required
															lay-verify="required" placeholder="请输入邮箱" autocomplete="off"
															class="layui-input border-red register-userEmail">
												</div>
											</div>
											
											<!-- 验证码 -->
											<div class="layui-form-item showPwd">
												<div class="layui-input-inline">
													<div class="icon_account"><i class="layui-icon layui-icon-vercode"></i></div>
													<input type="text" name="verifyCode" required
														lay-verify="required" placeholder="请输入验证码" autocomplete="off"
														class="layui-input userPassword border-red verifyCode" value="11">
														<div class="verification_img"><img id="verification" onclick="aginCreateverifyCode()" src="${pageContext.request.contextPath }/user/createverifyCode"></div>
<%-- 														<span style="color:red;">${imgError }</span> --%>
												</div>
											</div>
											
											<!-- 注册按钮 -->
											<div class="layui-form-item marginBottom">
											    <div onclick="loginOrRegister(this)" style="background-color:rgb(245,42,132);border-radius:5px;" class="layui-btn layui-btn-fluid">
											      	<button style="background-color:rgb(245,42,132);" class="layui-btn register" type="button">立即注册</button>
											    </div>
											</div>
										</div>
									</form>
									
									<div onclick="overback()">点击返回登录页面</div>
								</div>
								
							</div>
						</div>
						
						
					</div>
				</a>
			</li>
		</ul>
		
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/js/jquery.js"></script>
	<script type="text/javascript" 
		src="${pageContext.request.contextPath }/statics/js/login.js"></script>
	<script type="text/javascript" 
		src="${pageContext.request.contextPath }/statics/layui/layui.js"></script>


</body>
</html>