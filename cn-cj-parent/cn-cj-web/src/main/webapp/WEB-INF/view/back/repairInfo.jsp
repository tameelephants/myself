<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员个人信息</title>
</head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/layui/css/layui.css">
<body>
	<input style="display: none;"
		value="${pageContext.request.contextPath }" id="path">
	<div class="layui-tab" lay-unauto="" lay-allowclose="true" lay-filter="layadmin-layout-tabs">
			<ul class="layui-tab-title" id="LAY_app_tabsheader">
				<li class="layui-this"><span>基本信息</span> 
					<i class="layui-icon layui-unselect layui-tab-close">ဆ</i>
				</li>
			</ul>
		</div>
		<form class="layui-form" action="" lay-filter="example">
		  <div class="layui-form-item">
		    <label class="layui-form-label">用户名称</label>
		    <div class="layui-input-block">
		      <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
		    </div>
		  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">用户邮箱</label>
	    <div class="layui-input-block">
	      <input type="email" name="email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  
	  <div class="layui-form-item">
	    <label class="layui-form-label">性别</label>
	    <div class="layui-input-block">
	      <input type="radio" name="sex" value="0" title="男" checked="">
		      <div class="layui-unselect layui-form-radio layui-form-radioed">
		      	<i class="layui-anim layui-icon"></i>
		      	<div>男</div>
		      </div>
	      <input type="radio" name="sex" value="1" title="女">
	      <div class="layui-unselect layui-form-radio">
		      <i class="layui-anim layui-icon"></i>
		      <div>女</div>
	      </div>
	    </div>
	  </div>
	  
	  <div class="layui-form-item">
	    <label class="layui-form-label">用户地址</label>
	    <div class="layui-input-block">
	      <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
	    </div>
	  </div>
	  
	  <div class="layui-upload">
		  <button type="button" class="layui-btn" id="test1">上传图片</button>
		  <input class="layui-upload-file" type="file" accept="undefined" name="file">
		  <div class="layui-upload-list">
		    <img class="layui-upload-img" id="demo1">
		    <p id="demoText"></p>
		  </div>
	</div>
	 
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
	    </div>
	  </div>
	</form>
</div>
	
	
	<script src="${pageContext.request.contextPath }/statics/js/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/layui/layui.js"></script>
		<script
		src="${pageContext.request.contextPath }/statics/contextMenu/js/jquery.contextMenu.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/contextMenu/js/jquery.ui.position.js"></script>
		
</body>
</html>