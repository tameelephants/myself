<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="qq" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章详情</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/article.css">
<style type="text/css">
#header {
	background-color: white !important;
}

#footer {
	background-color: rgb(234, 234, 234) !important;
}
</style>
</head>
<body style="background-color: rgb(234, 234, 234)">
	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }">
	<input type="hidden" id="articleId" value="22">
	<!-- public top -->
	<%@ include file="common/index_top.jsp"%>
	<div class="mainBody">
		<!-- title img -->
		<div class="titleImg">
			<!-- linear-gradient -->
			<div class="linearGradient"></div>
			<!-- title character -->
			<div>
				<h3>${article.articleTitle }</h3>
				<div class="authorInfo">
					<span class="author">${article.userAuthor.userName }</span>
					&nbsp;|&nbsp; <span class="dayAgo"><b>3</b>天前</span>
				</div>
			</div>
		</div>

		<!-- articleInfo -->
		<div class="articleInfo">
			<!-- mainLeft -->
			<div class="mainLeft">
				<!-- keyword -->
				<div class="keyword_controller">
					<ul class="keyword_ul">
						<qq:forEach items="${labelList }" var="label">
							<li>${label.labelName }</li>
						</qq:forEach>
					</ul>
				</div>
				<!-- articleContent -->
				<div class="articleContent_controller">
					<div>${article.articleContent }</div>
					<!-- 个性签名 -->
					<div class="gexing">
						<p>好看的皮囊千变一律,有趣的灵魂万里挑一</p>
						<div class='article_praise_controller'>
							<qq:if test="${praiseNum == 0 }">
								<img width='15px' class="dianzan" height='15px' src='${pageContext.request.contextPath }/statics/img/praiseBefore.png'><span class="articlePraiseSpanHui">${article.articlePraise }</span>
							</qq:if>
							<qq:if test="${praiseNum == 1 }">
								<img width='15px' class="dianzan" height='15px' src='${pageContext.request.contextPath }/statics/img/praiseAfter.png'><span class=articlePraiseSpanBlue>${article.articlePraise }</span>
							</qq:if>
						</div>
					</div>
					<!-- commend -->
					<div class="showImg">
						<img src="" width="120px" height="120px" class="img1" ojbk="1">
						<img src="" width="120px" height="120px" class="img2" ojbk="2">
						<img src="" width="120px" height="120px" class="img3" ojbk="3">
					</div>
					<h3 class="tishi"></h3>
					<div class="commend">
						<div class="faceList">
							<ul>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/0.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/1.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/2.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/3.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/5.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/4.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/6.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/7.gif"
									width="22px" height="22px"></li>
							</ul>
							<ul>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/24.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/25.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/26.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/27.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/28.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/29.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/30.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/31.gif"
									width="22px" height="22px"></li>
							</ul>
							<ul>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/8.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/9.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/10.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/11.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/12.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/13.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/14.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/15.gif"
									width="22px" height="22px"></li>
							</ul>
							<ul>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/16.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/17.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/18.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/19.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/20.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/21.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/30.gif"
									width="22px" height="22px"></li>
								<li><img
									src="${pageContext.request.contextPath }/statics/layui/images/face/22.gif"
									width="22px" height="22px"></li>
							</ul>
						</div>
						<div>
							<form action="" method="post" enctype="multipart/form-data"
								method="post">
								<div class="toolTab">
									<ul>
										<li style="font-size: 20px;"
											class="layui-icon layui-icon-face-smile" title="表情"></li>
										<li style="font-size: 22px;"
											class="layui-icon layui-icon-picture-fine" title="图片"><input
											type="file" class="upload-file"></li>
									</ul>
								</div>
								<!-- contenteditable可以设置是否可以输入 -->
								<button class="layui-btn layui-btn-sm layui-btn-normal"
									style="margin-left: 92%; margin-top: -40px;">发表</button>
								<div contenteditable="true" class="textarea"></div>
							</form>
						</div>
					</div>

					<!-- show commend -->
					<div class="showCommend">
						<div>

							<div class="jingxuanpinglun">
								<!-- 评论标题 -->
								<h3>精选评论</h3>
							</div>

							<div class="comment_controller">
								<%-- <div class="nicknameAndImg">
									<!-- 头像,昵称 -->
									<div class="nicknameAndImg_controller">
										<img alt="头像" title="头像" src="${pageContext.request.contextPath }/statics/img/0ccd15cc-0e89-4c95-85d9-d7d996423f55.jpg.80x80.png">
										<p>被驯服的象</p>
										<p>2018-09-30 21:20:20</p>
									</div>
									<!-- 文本内容 -->
									<div class="contextAndPraise">
										<div class="commendConetnt">我觉得这位大佬说的很对!</div>
										
										<shiro:hasRole name="admin">
											<span class="reply">回复</span>
										</shiro:hasRole>
									
										<div class="replyInfo" style="display: none;">
											<input class="replyInput" placeholder="在此进行回复" name="" value="" style="display: inline-block;" />
											<button type="button" class="layui-btn layui-btn-sm replyCommit" style="display: inline-blocl;">提交</button>
											<span style="display: none">其实这个问题很简单</span>
										</div>
										
										<div class="replyContent">
												
										</div>
										
									</div>
								</div> --%>
								<div class="nicknameAndImgs"></div>

							</div>

							<!-- load more -->
							<div class="loadmore">加载更多</div>
						</div>

					</div>
				</div>
			</div>

			<!-- mainRight -->
			<div class="mainRight">
				<!-- hot title -->
				<!-- commend -->
				<div class="newArticle">
					<div class="newArticle_controller">
						<h3>
							<b>热门</b>
						</h3>
						<div class="li_controller">
							<h4>程序员漫游指南</h4>
							<p>这是你的办公室,这是你的电脑,这是你的电话,上岗记得打个电话</p>
						</div>
						<div class="li_controller">
							<h4>说一说你了解的springmvc</h4>
							<p>springmvc的原理首先是用户发送一个请求给前端控制器,也就是dispatcher servlet</p>
						</div>
						<div class="li_controller">
							<h4>你在项目的那些地方有用过线程</h4>
							<p>首先线程的实现方式有3中,继承thread类,实现runnable接口和实现callable接口</p>
						</div>
						<div class="advertising">
							<img alt="" title="这里是广告模块"
								src="${pageContext.request.contextPath }/statics/img/180321100813838.jpg"
								width="100%" height="110px">
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>

	<!-- fixbar -->
	<div class="fixbar">
		<ul>
			<li><a class="layui-icon layui-icon-dialogue" href="#"></a></li>
			<li><a class="layui-icon layui-icon-star" href="#"></a></li>
			<li><a class="layui-icon layui-icon-release" href="#"></a></li>
		</ul>
	</div>
	</div>



	<!-- public bottom -->
	<%@ include file="common/index_bottom.jsp"%>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/statics/js/article.js"></script>
</body>
</html>