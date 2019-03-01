<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部导航</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/css/index_top.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/layui/css/layui.css">
</head>
<body>
	<!-- header nav -->
	<nav id="header">
	<ul class="daohang_ul">
		<li class="daohang_li active"><img
			src="${pageContext.request.contextPath }/statics/img/0ccd15cc-0e89-4c95-85d9-d7d996423f55.jpg.80x80.png"
			width="27px" height="27px" title="被驯服的象的个人博客" alt="被驯服的象的个人博客">
		</li>
		<li class="daohang_li">首页</li>
		<li class="daohang_li">日记</li>
		<li class="daohang_li">技术专区</li>
		<li class="daohang_li">下载专区</li>
		<shiro:hasRole name="admin">
			<li class="daohang_li" onclick="location.href='${pageContext.request.contextPath}/back/index'">后台管理</li>
		</shiro:hasRole>
	</ul>

	<!-- 搜索 -->
	<div class="search_area">
		<form name="solrSearch_form" class="solrSearch_form" action=""
			method="get">
			<input type="text" name="">
			<button type="submit" id="search">
				<i class="glyphicon glyphicon-search"></i>
			</button>
		</form>
	</div>
	</nav>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/layui/layui.all.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/index.js"></script>
</html>