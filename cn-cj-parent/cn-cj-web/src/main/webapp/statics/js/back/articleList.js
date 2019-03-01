var path = document.getElementById("path").value;
$(document).ready(function () {
	$(".artilceList_controller").css("height",$(window).height()-61);
	initTable();
});

layui.use('laydate', function () {
	var laydate = layui.laydate;
	//时间选择器
	laydate.render({
		elem: '#timearea'
			, range: true
	});

});
function initTable() {
	var timeArea = $("#timearea").val();
	var startTime = "";
	var endTime = "";
	if (timeArea) {
		startTime = timeArea.split(" - ")[0];//开始时间
		endTime = timeArea.split(" - ")[1];//结束时间
	}
	layui.use('table', function () {
		var table = layui.table;
		//执行渲染
		table.render({
			id: 'demo',//这里的demo不需要加#
			elem: '#demo' //指定原始表格元素选择器（推荐id选择器）
				, height: $(window).height()-145 //容器高度
				, cols: [[{ checkbox: true }
				, { field: 'articleId', title: '文章编号', width: 180, sort: true }
				, { field: 'articleTitle', title: '文章标题', width: 200 }
				, { field: 'userAuthor.userName', title: '文章作者', width: 100, 
					templet:function(d){
						return d.userAuthor.userName;
					}
				}
				, { field: 'articlePraise', title: '点赞数', width: 100, sort: true }
				, { field: 'articleClickNum', title: '点击量', width: 100, sort: true }
				, { field: 'isPutaway', title: '是否发布', width: 100, sort: true,
					templet:function(d){
						return  d.isPutaway == '0' ? "<span style='color:red; font-weight:800;'>尚未发布</span>":"<span style='color:green; font-weight:800;' class='layui-red'>已发布</span>";
					}	
				}
				, { field: 'userCreater.userAccount', title: '发布人', width: 150,
					templet:function(d){
						return  d.userCreater.userAccount;
					}	
				}
				, { field: 'articleCreateTime', title: '发布时间', width: 200, sort: true, 
					templet: function(d){
						return getLocalTime(d.articleCreateTime);
					}
				}
				, { field: 'articleDeleteFlag', title: '状态', width: 100, sort: true, 
					templet: function(d){
						return  d.articleDeleteFlag == 'Y' ? "<span style='color:red; font-weight:800;'>已删除</span>":"<span style='color:green; font-weight:800;' class='layui-red'>正常</span>";
					}
				}
				, { field: 'articleLabel', title: '标签', width: 400,
					templet:function(d){
							var arrLabel = d.articleLabel.split(",");
						var html = "";
						for (var u = 0; u < arrLabel.length; u++) {
							html+="<span style='background:rgb(22,194,194); margin-left:10px; padding:5px 15px; color:white;'>"+ arrLabel[u] +"</span>";
						}
						return html;
					}
				}
				,{fixed: 'right',title: '操作', width:200, align:'center', toolbar: '#barDemo'}
				]],
				//渲染完成执行(隐藏articleId列)
				done: function () {
//		            $("[data-field='articleId']").css('display','none');
		        },
				url: path + '/back/queryArticleList',//请求地址
				where: { KeyWords:$("#keyword").val() , StartTime: startTime, EndTime: endTime },//请求参数
				method: 'post',//请求方式
				limits: [10, 20, 30, 50, 100]//页面设置每页条目
				, limit: 10, //默认采用10
				loading: true,
				page: true

		});
		//监听工具条
		table.on('tool(demo)', function (obj) {
			var data = obj.data;
			//上下架文章
			if (obj.event === 'detail') {
				if(data.articleDeleteFlag == "Y"){
					layer.confirm("当前文章状态为<span style='color:red;'><删除,'Y'></span><br/>文章编号为<span style='color:red;'><"+ data.articleId +"></span><br/>请手动恢复为<span style='color:red;'><正常,'N'></span><br/>再进行文章上架操作!",{title:"警告",skin:"red-skin",btn:['确定']});
					return;
				}
				var putaway;//是否发布
				var confirmInfo;//提示信息
				var skin_style;//按钮样式
				if(data.isPutaway == 1){
					putaway = 0;
					confirmInfo="确认下架该文章吗?";
					skin_style = "yellow-skin";
				}else{
					putaway = 1;
					confirmInfo="确认发布该文章吗?";
					skin_style = "blue-skin";
				}
				layer.confirm(confirmInfo,{title:"温馨提示",skin:skin_style}, function (index) {
//					obj.del();
					$.ajax({
						url:path + '/back/putawayArticle',
						data:{
							articleId:data.articleId,
							isPutaway:putaway
						},
						success:function(data){
							if(data.ARTICLE_CODE == 1){
								layer.msg(data.ARTICLE_INFO,{icon:1});
							}else if(data.ARTICLE_CODE == -1){
								layer.msg(data.ARTICLE_INFO,{icon:2});
							}else{
								layer.msg("系统错误",{icon:2});
							}
							//刷新表格(此处是分页组件laypage的按钮 模拟刷新)
							reloadLayuiTable();
						}
					});
					layer.close(index);
				});
			//删除文章
			} else if (obj.event === 'del') {
				if(data.articleDeleteFlag == "Y"){
					return;
				}
				layer.confirm("删除会下架该文章,确认删除吗?<span style='color:red;'>(不可逆操作)</span>",
								{title:"警告", skin:"red-skin"},
				
								//点击确定按钮
								function (index,layero) {
				//					obj.del();
									$.ajax({
										url:path + '/back/deleteArticle',
										data:{
											articleId:data.articleId
										},
										success:function(data){
											if(data.ARTICLE_CODE == 1){
												layer.msg(data.ARTICLE_INFO,{icon:1});
											}else if(data.ARTICLE_CODE == -1){
												layer.msg(data.ARTICLE_INFO,{icon:2});
											}else{
												layer.msg("系统错误",{icon:2});
											}
											//刷新表格(此处是分页组件laypage的按钮 模拟刷新)
											reloadLayuiTable();
										}
									});
									layer.close(index);
								});
			//编辑文章
			} else if (obj.event === 'edit') {
				layer.alert('编辑行：<br>' + JSON.stringify(data))
			}
		});

	});





	//格式化时间戳
	function getLocalTime(timestamp) {
		    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		    var Y = date.getFullYear() + '-';
		    var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		    var D = date.getDate() < 10 ?  '0'+date.getDate()+ ' ' : date.getDate()+ ' ';
		    var h = date.getHours() < 10 ? '0'+date.getHours()+ ':' : date.getHours()+ ':';
		    var m = date.getMinutes() < 10 ? '0'+date.getMinutes()+ ':' : date.getMinutes()+ ':';
		    var s = date.getSeconds()< 10 ? '0'+date.getSeconds() : date.getSeconds();
		    return Y+M+D+h+m+s;
	}
	
	function reloadLayuiTable(){
		$(".layui-laypage-btn")[0].click();
	}
}
