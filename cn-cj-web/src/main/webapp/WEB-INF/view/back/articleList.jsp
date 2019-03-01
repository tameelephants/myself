<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/layui/css/layui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/back/articleList.css">
<body>
	<div style="width: 100%;"
		class="layui-col-xs10 layui-col-sm10 layui-col-md10">
		<input style="display: none;" id="path"
			value="${pageContext.request.contextPath }">
		<!--选项卡-->
		<div class="layui-tab" lay-unauto="" lay-allowclose="true"
			lay-filter="layadmin-layout-tabs">
			<ul class="layui-tab-title" id="LAY_app_tabsheader">
				<li class="layui-this"><span>文章列表</span> <i
					class="layui-icon layui-unselect layui-tab-close">ဆ</i></li>
			</ul>
		</div>


		<div class="artilceList_controller">
			<div class="row" id="divParams">
				<div class="panel col-md-12">
					<br />
					<div class="demoTable">
						标题：
						<div class="layui-inline">
							<input name="id" class="layui-input" id="keyword"
								placeholder="请输入标题">
						</div>
						时间段：
						<div class="layui-inline">
							<input class="layui-input" id="timearea" placeholder="请选择查询时间段"
								type="text">
						</div>
						<button class="layui-btn" data-type="reload"
							onclick="initTable();">搜索</button>
					</div>
					<table class="layui-table" id="demo" lay-filter="demo"></table>
				</div>
			</div>
			<script type="text/html" id="barDemo">
				{{# if (d.isPutaway =="0"){}}
  					<a class="layui-btn layui-btn-normal layui-btn-sm" lay-event="detail">发布</a>
				{{#}}}
				{{# if (d.isPutaway =="1"){}}
  					<a class="layui-btn layui-btn-warm layui-btn-sm" lay-event="detail">下架</a>
				{{#}}}

  					<a class="layui-btn layui-btn-sm" lay-event="edit">编辑</a>
	
				{{# if (d.articleDeleteFlag =="N"){}}
  					<a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del">删除</a>
				{{#}}}
				{{# if (d.articleDeleteFlag =="Y"){}}
  					<a class="layui-btn layui-btn-disabled layui-btn-sm" lay-event="del">禁用</a>
				{{#}}}
			</script>
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/statics/js/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/layui/layui.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/back/articleList.js"></script>
</body>
