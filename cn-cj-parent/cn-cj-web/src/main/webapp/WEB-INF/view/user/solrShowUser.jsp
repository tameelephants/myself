<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="styleSheet"
	href="${pageContext.request.contextPath}/statics/css/user.css" />
</head>
<body>
	<table>
		<tr>
			<th>用户名</th>
			<th>昵称</th>
			<th>邮箱</th>
			<th>上次登录时间</th>
		</tr>
		<c:forEach var="user" items="${userList }">
			<tr>
				<td>${user.userAccount }</td>
				<td>${user.userName }</td>
				<td>${user.userEmail }</td>
				<td>${user.lastLoginTime }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>