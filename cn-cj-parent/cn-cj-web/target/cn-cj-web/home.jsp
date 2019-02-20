<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <link type="text/css" rel="styleSheet"  href="<c:url value="/statics/css/user.css"></c:url>" /> --%>
<style type="text/css">
	.error{
		color:red;
	}
</style>
</head>
<body>

	<form action="${pageContext.request.contextPath}/user/login" method="post" id="form-user">
		<input name="userAccount" class="userAccount" value="" >
		<input name="userPassword" type="password" class="userPassword" >
		<strong class="error">${result.info}</strong>
		<button type="button" class="login" onclick="isCheck()">登录</button>
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery.js"></script>
	<script type="text/javascript">
		function isCheck(){
			var userAccount = $(".userAccount").val();
			var userPassword = $(".userPassword").val();
			var error = $(".error");
			if($.trim(userAccount) == ""){
				error.html("用户名不能为空");
				return false;
			}else if($.trim(userPassword) == ""){
				error.html("密码不能为空");
				return false;
			}else{
				error.html("");
				$("#form-user").submit();
			}
		}
	</script>
	
	

<%-- <script type="text/javascript" src='${pageContext.request.contextPath }/statics/js/user.js'></script> --%>
</body>
</html>