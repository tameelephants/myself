<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<html>

<!-- 网页三要素 -->
<!-- 标题 -->
<title>被驯服的象的个人博客</title>
<!-- 关键字搜索 -->
<meta name="keywords" content="被驯服的象">
<!-- 关于当前网页的描述 -->
<meta name="description" content="小众轻阅读,记录日常的生活!">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/css/index.css">
<body>

	<div id="thisPage">
		<div>
			<!-- public header -->
			<%@ include file="common/index_top.jsp"%>
			<!-- headline news -->
			<div id="headerline">
				<span>技术专区</span>
				<h2>SpringMVC工作原理与机制</h2>
				<p>by:被驯服的象</p>
			</div>

			<!-- child nav -->
			<div class="childNav">
				<div class="childNav-child">
					<span> <a href="#">spring</a>
					</span> <span> <a href="#">hibernate</a>
					</span> <span> <a href="#">websocket</a>
					</span> <span> <a href="#">activemq</a>
					</span> <span> <a href="#">solr</a>
					</span> <span> <a href="#">shiro</a>
					</span> <span> <a href="#">redis</a>
					</span>
				</div>
			</div>
		</div>


		<!-- main body -->
		<div id="mainBody" style="background-color: rgb(234, 234, 234)">
			<div class="body">

				<!-- left nav -->
				<div class="leftBody">
					<!-- <table class="table_demo">
                    <thead>
                        <tr>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>性别</th>
                        </tr>
                    </thead>
                </table> -->

					<!-- carousel -->
					<div class="layui-carousel" id="lunbo">
						<div carousel-item>
							<div>
								<a
									href="${pageContext.request.contextPath }/article/articleInfo?articleId=22"><img
									height="383px"
									src="${pageContext.request.contextPath }/statics/img/180828012300500.jpg"></a>
							</div>
							<div>
								<img height="383px"
									src="${pageContext.request.contextPath }/statics/img/180828105347992.jpg">
							</div>
							<div>
								<img height="383px"
									src="${pageContext.request.contextPath }/statics/img/180829122443368.jpg">
							</div>
							<div>
								<img height="383px"
									src="${pageContext.request.contextPath }/statics/img/180909053041227.jpg">
							</div>
						</div>
					</div>
					<%--   <div class="layui-row fourImg" style="position:relative;">
                    <div style="position:absolute; background-color:rgba(0,0,0,0.2); z-index:100; height:90px; width:230px; top:15px;"></div>
                    <img class="layui-col-md3" style="margin:15px 0px !important; margin-right:5px !important;"
                         src="${pageContext.request.contextPath }/statics/img/180828102238658 .jpg">
                    <div style="position:absolute; left:240px; z-index:100; background-color:rgba(0,0,0,0.2); height:90px; width:230px; top:15px;"></div>
                    <img class="layui-col-md3"
                         src="${pageContext.request.contextPath }/statics/img/1809030912504691.jpg">
                    <div style="position:absolute; left:480px; z-index:100; background-color:rgba(0,0,0,0.2); height:90px; width:230px; top:15px;"></div>
                    <img class="layui-col-md3"
                         src="${pageContext.request.contextPath }/statics/img/1809020953501881.jpg">
                    <div style="position:absolute; left:720px; z-index:100; background-color:rgba(0,0,0,0.2); height:90px; width:230px; top:15px;"></div>
                    <img class="layui-col-md3"
                         src="${pageContext.request.contextPath }/statics/img/180829123952506.jpg">
                </div> --%>


					<!-- first news -->
					<div class="toutiao">
						<div style="padding: 25px;">
							<div style="text-align: left;">
								<h3>头条</h3>
							</div>
							<div class="toutiao_div_controller">
								<ul class="toutiao_ul">
									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180908013009892.jpg">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 &nbsp;></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/1809030912504691.jpg"
													width="" height="">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 ></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180902103758607.png"
													width="" height="">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 ></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/1809020953501881.jpg"
													width="" height="">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 ></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180902114908240.jpg"
													width="" height="">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 ></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180903092527763.jpg"
													width="" height="">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 ></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>
								</ul>
							</div>
						</div>
					</div>

					<!-- important select -->
					<div class="toutiao jingxuan">
						<div style="padding: 25px;">
							<div style="text-align: left;">
								<h3>精选</h3>
							</div>
							<div class="toutiao_div_controller">
								<ul class="toutiao_ul">
									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180908013009892.jpg">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 &nbsp;></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/1809030912504691.jpg"
													width="" height="">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 ></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180902103758607.png"
													width="" height="">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 ></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/1809020953501881.jpg"
													width="" height="">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 ></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180902114908240.jpg"
													width="" height="">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 ></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180903092527763.jpg"
													width="" height="">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 ></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180908013009892.jpg">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 &nbsp;></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180908013009892.jpg">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 &nbsp;></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180908013009892.jpg">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 &nbsp;></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180908013009892.jpg">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 &nbsp;></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180908013009892.jpg">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 &nbsp;></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>

									<li><a>
											<div>
												<img
													src="${pageContext.request.contextPath }/statics/img/180908013009892.jpg">
											</div>
											<article class="article">
												<p>
													<span>造梦者</span><strong>这里是标题</strong>
												</p>
												<p>
													这个是关于本文的一个介绍，这是关于本文的一个介绍，这是关于本文的一个介绍，这是一个关于本文的一个介绍这个是关于本文的一个介绍，这是关于本文的一个介绍,这是关于本文的一个介绍</p>
												<p>
													<span>阅读全文 &nbsp;></span><span><b>3</b>天前</span>
												</p>
											</article>
									</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<!-- right nav -->
				<div class="rightBody">
					<!-- at latest news -->
					<div class="newArticle">
						<div class="newArticle_controller">
							<h3>
								<b>最新</b>
							</h3>
							<div class="li_controller">
								<ul>
									<li><a href="#"><i></i>spring整合mybatis</a></li>
									<li><a href="#"><i></i>jvm的工作原理和机制</a></li>
									<li><a href="#"><i></i>异常的分类</a></li>
									<li><a href="#"><i></i>怎么处理多并发</a></li>
									<li><a href="#"><i></i>集合的分类</a></li>
									<li><a href="#"><i></i>什么是Ioc和Aop</a></li>
								</ul>
							</div>
							<div class="advertising">
								<img alt="" title="这里是广告模块"
									src="${pageContext.request.contextPath }/statics/img/180902023827816.jpg"
									width="100%">
							</div>
						</div>
					</div>

					<!-- commend -->
					<div class="newArticle">
						<div class="newArticle_controller">
							<h3>
								<b>推荐</b>
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
		<!-- public botttom -->
		<%@ include file="common/index_bottom.jsp"%>
	</div>
</body>
</html>
