<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="qq" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/layui/css/layui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/contextMenu/css/jquery.contextMenu.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/back/addArticle.css">
<body>
	<input style="display: none;"
		value="${pageContext.request.contextPath }" id="path">
	<div style="width: 100%;"
		class="layui-col-xs10 layui-col-sm10 layui-col-md10">

		<!--选项卡-->
		<div class="layui-tab" lay-unauto="" lay-allowclose="true"
			lay-filter="layadmin-layout-tabs">
			<ul class="layui-tab-title" id="LAY_app_tabsheader">
				<li class="layui-this"><span>写文章</span> <i
					class="layui-icon layui-unselect layui-tab-close">ဆ</i></li>
			</ul>
		</div>
		<div class=" load_controller">
			<form class="layui-form" id="articleSubmit" enctype="multipart/form-data">
				
				<!--标题-->
				<div class="layui-form-item">
					<label class="layui-form-label">标题</label>
					<div class="layui-input-block">
						<input type="text" name="article_title" autocomplete="off" class="layui-input article_title">
					</div>
				</div>
				
				<!--标签-->
				<div class="layui-form-item">
					<label class="layui-form-label">标签</label>
					<div class="layui-input-block">
						<qq:forEach items="${labelList }" var="label">
							<input type="checkbox" class="article_label" name="article_label" value="${label.labelId }" title="${label.labelName }">
							<div class="layui-unselect layui-form-checkbox">
								<span>${label.labelName }</span>
								<i class="layui-icon layui-icon-ok"></i>
							</div>
						</qq:forEach>
					</div>
				</div>
				
				<!-- 内容 -->
				<div>
					<%
						String ramdonAboutArticle = (String) request.getAttribute("ramdonAboutArticle");
					%>
					<input value="<%=ramdonAboutArticle%>" style="display: none;"
						id="ramdonAboutArticle" />
				    <label class="article_content">内容</label>
					<div contentEditable="true" id="textarea"></div>
				</div>
    
				<div class="layui-card upload_controller">
					<label class="upload">背景图</label>
					<span class="a_controller">
						<a href="javascript:;" class="file">请选择文章背景图 <input type="file"
							name="article_bgimg" id="article_bgimg"></a>
					</span>
				</div>

				<!-- 按钮 -->
				<div class="layui-form-item btn_controller">
					<div class="layui-input-block">
						<button class="layui-btn save" type="button">保存</button>
						<button type="reset" class="layui-btn layui-btn-primary" type="button">取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/statics/js/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/layui/layui.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/contextMenu/js/jquery.contextMenu.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/contextMenu/js/jquery.ui.position.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/back/addArticle.js"></script>
</body>
