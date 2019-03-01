<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>后台首页</title>
<meta name='keywords' content='后台'>
<meta name='description' content='后台'>
</head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/layui/css/layui.css">
<script src="${pageContext.request.contextPath }/statics/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/statics/layui/layui.js"></script>
<script 
	src="${pageContext.request.contextPath }/statics/js/back/index.js"></script>
<body class="layui-layout-body" layadmin-themealias="default">

	<!--头部导航栏-->
	<ul class="layui-nav" style="text-align: right;">
		<li class="layui-nav-item"><a href="javascript:;">关于我<span
				class="layui-badge-dot"></span></a></li>
		<li class="layui-nav-item"><a href="javascript:;"><img
				src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="${pageContext.request.contextPath }/back/repairInfo" 
						target="menuFrame">修改信息</a>
				</dd>
				<dd>
					<a href="javascript:;">退出</a>
				</dd>
			</dl></li>
	</ul>
	<!--左边侧边导航-->
	<div class="layui-row">
		<ul class="layui-nav layui-nav-side layui-nav-tree left_controller"
			lay-filter="test">
			<div class="layui-logo" lay-href="home/console.html"
				style="margin: 22px 35%;">
				<span>Logo</span>
			</div>
			<li class="layui-nav-item"><a href="javascript:;">用户管理</a></li>
			<li class="layui-nav-item layui-nav-itemed"><a
				href="javascript:;">文章管理</a>
				<dl class="layui-nav-child">
					<dd>
						<a href="${pageContext.request.contextPath }/back/articleList"
						 target="menuFrame">文章列表</a>
					</dd>
					<dd>
						<a href="${pageContext.request.contextPath }/back/addArticle"
							target="menuFrame">写文章</a>
					</dd>
				</dl></li>

			<li class="layui-nav-item"><a href="javascript:;">评论管理</a></li>

			<li class="layui-nav-item"><a href="javascript:;">设置</a>
				<dl class="layui-nav-child">
					<dd>
						<a href="${pageContext.request.contextPath }/back/repairInfo"
							target="menuFrame">基本信息</a>
					</dd>
					<dd>
						<a href="javascript:;">忘记密码</a>
					</dd>
				</dl></li>

			<li class="layui-nav-item put-away">
				<a href="javascript:;">收起</a>
			</li>
		</ul>
	</div>

	<div class="center_controller">
		<iframe id="menuFrame" name="menuFrame"
			src="${pageContext.request.contextPath }/back/repairInfo"
			style="overflow: visible;" scrolling="yes" frameborder="no"
			width="100%" height="100%;" />
	</div>
</body>
</html>