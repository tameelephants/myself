/*layui.use('layedit', function(){
  var layedit = layui.layedit
  ,$ = layui.jquery;
  
  //构建一个默认的编辑器
  var index = layedit.build('LAY_demo1');
  
  $('.site-demo-layedit').on('click', function(){
	  alert(layedit.getContent(index).trim()); //获取编辑器内容
  });
  
});*/
var path;
$(function(){
	path = $("#path").val();
	//通过文章Id获取当前文章信息(点赞数),文章评论集合,文章回复集合
	loadCommentAbout();
	$(".tishi").html("当前没有上传图片");
	$(document).on('click',function(){
		$(".faceList").hide();
		$(".toolTab li").eq(0).css("color","black");
		$(".toolTab li").eq(0).removeClass("shows");
	});
	$(".toolTab li").eq(0).click(function(e){
		e.stopPropagation();
		if($(this).hasClass("shows")){
			$(this).removeClass("shows");
			$(".faceList").hide();
			$(this).css("color","black");
		}else{
			$(".faceList").show();
			$(this).addClass("shows");
			$(this).css("color","orange");
		}
	});
	
	//点击表情赋值到文本框
	$(".faceList li").click(function(e){
		e.stopPropagation();
		$(".textarea").append($(this).html());
		$(".faceList").hide();
		$(".toolTab li").eq(0).css("color","black");
		$(".toolTab li").eq(0).removeClass("shows");
	});
	var i = 1;
	var objUrl = null;
	$(".upload-file").change(function(){
		/*alert("文本改变事件: "+i);*/
		objUrl = getObjectURL(this.files[0]);
		if(objUrl){
			if(i >= 4){
				i==4;
				$(".tishi").html("<span style='color:red;'>对不起,最多上传3张图片</span>");
			}
			else {
				$(".tishi").html("当前上传第"+ i +"张图片(最多上传3张)");
				$(".img" + i +"").attr("src",objUrl);
				$(".img" + i +"").attr("style","opacity:1");
				i++;
			}
		}
	});
	var layer = null;
	layui.use(['layer'],function(){
		layer = layui.layer;
	});
	//单机图片删除事件
	$(".showImg").on('click','img',function(){
		var indexss = $(this).attr("ojbk");
		if($(".showImg").children().eq(indexss-1).css("opacity") == 0 || $(".showImg").children().eq(indexss-1).css("opacity") == 0.01){
			return;
		}else{
			layer.open({
				title:'温馨提示',
				content:'是否确认删除当前选中图片',
				btn:['确定','取消'],
				yes:function(index,layero){
					if(($(".showImg").children().length)-indexss < 0){
						$(".showImg").children().eq(0).css("opacity",0);
					}else{
						for(j = indexss-1; j < ($(".showImg").children().length)-1; j++){
							//下一张图片赋值到前一张图片中,并且隐藏下一张图片
							$(".showImg").children().eq(j).attr("src",$(".showImg").children().eq(j+1).attr("src"));
						}
						if($(".showImg").children().eq(1).css("opacity") == 1 && $(".showImg").children().eq(2).css("opacity") == 1){
							$(".showImg").children().eq(2).css("opacity",0);
						}else if($(".showImg").children().eq(1).css("opacity") == 1 && $(".showImg").children().eq(2).css("opacity") == 0){
							$(".showImg").children().eq(1).css("opacity",0);
						}else{
							$(".showImg").children().eq(0).css("opacity",0);
						}
						i--;
						if(i == 1){
							$(".tishi").html("当前没有上传图片");
							i = 1;
						}else{
							$(".tishi").html("当前上传第"+ (i-1) +"张图片(最多上传3张)");
						}
					}
					layer.msg("删除成功!");
				}
			});
		}
	});
	//删除当前选中图片的提示框
	$("li.layui-icon-picture-fine").hover(
		function(){
			layer.tips('点击图片可删除当前选择上传的图片', 'li.layui-icon-picture-fine', {
				  tips: [1, '#3595CC'],
				  time: 4000
			});
		},
		function(){
			layer.closeAll();
		}
	);
	
	$(".fixbar li:nth-child(1)>a").hover(
		function(){
			layer.tips('联系站长','.fixbar li',{
				tips: [1, '#3595CC'],
				time: 4000
			});
		},
		function(){
			layer.closeAll();
		}
	);
	$(".fixbar li:nth-child(2)>a").hover(
		function(){
			layer.tips('分享','.fixbar li',{
				tips: [1, '#3595CC'],
				time: 4000
			});
		},
		function(){
			layer.closeAll();
		}
	);
	
	$(".fixbar li:nth-child(3)>a").hover(
		function(){
			layer.tips('返回顶部','.fixbar li',{
				tips: [1, '#3595CC'],
				time: 4000
			});
		},
		function(){
			layer.closeAll();
		}
	);
	$(".praise_controller img").on('click',function(){
		if($(this).attr("src") == path+"/statics/img/praiseBefore.png"){
			//未点赞
			$(this).attr("src",path+"/statics/img/praiseAfter.png");
			$(this).next("span").attr("style","font-weight:700;color:rgb(18,150,219)");
			var praiseNum = parseInt($(this).next("span").text());
			$(this).next("span").html(praiseNum+1);
		}else{
			//已点赞
			return;
		}
	});
	$(".reply").on('click',function(){
		$(this).next("div").css("display","block");
	});
	$(".replyCommit").on('click',function(){
		/*$(this).parents(".replyInfo").css("display","none");
		var replyValue = $(this).prev("input").val();*/
		/*$(this).parents(".replyInfo").next(".replyContent").append("<span><span style='color:red; font-weight:700;'>作者回复:</span> "+ replyValue +"</span>");*/
	});
	/*layui.use('util',function(){
		var util = layui.util;
		//固定框
		util.fixbar({
			bar1:"&#xe611;",				//对象1
			bar2:"&#xe641;",						//对象2
			bgcolor:"rgba(234,234,234,1);width:45px;height:45px;line-height:45px;border-radius:5px;",//设置颜色
		    css:{right:40,bottom:40},     //设置固定菜单的位置
			click:function(type){	   	    //点击事件
				if(type == "bar1"){
					alert("点击了bar1");
				}else if(type == "bar2"){
					alert("点击了bar2");
				}
			}
		});
	});*/
});

//获取图片地址
function getObjectURL(file){
	var url = null;
	if(window.createObjectURL != undefined){
		url = window.createObjectURL(file);
	}else if(window.URL != undefined){
		url = window.URL.createObjectURL(file);
	}else if(window.webkitURL != undefined){
		url = window.webketURL.createObjectURL(file);
	}
	return url;
}


//通过文章Id获取当前文章信息(点赞数),文章评论集合,文章回复集合
function loadCommentAbout(){
	var comment_controller = $(".comment_controller");
	alert(path)
	$.ajax({
		url:path + "/article/loadCommentAndOthers",
		data:{articleId:22},
		//通过文章编号查询出当前文章的所有评论集合(回复集合),点赞数,评论点赞数
		success:function(data){
			if(data.ARTICLE_CODE == 1){
				comment_controller.html("");
				var article = data.article;
				for (var i = 0; i < article.commentList.length; i++) {
					if(article.commentList[i].reply != null){
						comment_controller.append("<div class='nicknameAndImg'>"+
								"<div class='nicknameAndImg_controller'>"+
								"<img alt='头像' title='头像' src='"+ path + article.commentList[i].commentor.userImg +"'>"+
								"<p>"+ article.commentList[i].commentor.userName +"</p>"+
								"<p>"+ article.commentList[i].commentCreateTime +"</p>"+
							"</div>"+
							"<div class='contextAndPraise'>"+
								"<div class='commendConetnt'>"+ article.commentList[i].commentContent +"</div>"+
								
								"<div class='replyContent'>" +
									"<span><span style='color:red; font-weight:700;'>作者回复:</span>"+ article.commentList[i].reply.replyContent +"</span>"+
								"</div>"+
								
								"<div class='praise_controller'>"+
									"<img alt='' width='30px' height='30px' src='"+ path +"/statics/img/praiseBefore.png'><span style='font-weight: 700; color:rgb(138,138,138)'>20</span>"+
								"</div>"+
							"</div>"+
						"</div>");
					}else{
						comment_controller.append("<div class='nicknameAndImg'>"+
								"<div class='nicknameAndImg_controller'>"+
								"<img alt='头像' title='头像' src='"+ path + article.commentList[i].commentor.userImg +"'>"+
								"<p>"+ article.commentList[i].commentor.userName +"</p>"+
								"<p>"+ article.commentList[i].commentCreateTime +"</p>"+
							"</div>"+
							"<div class='contextAndPraise'>"+
								"<div class='commendConetnt'>"+ article.commentList[i].commentContent +"</div>"+
								
								"<shiro:hasRole name='admin'>"+
									"<span class='reply'>回复</span>"+
								"</shiro:hasRole>"+
							
								"<div class='replyInfo' style='display: none;'>"+
									"<input class='replyInput' placeholder='在此进行回复' name='' value='' style='display: inline-block;' />"+
									"<button type='button' class='layui-btn layui-btn-sm replyCommit' style='display: inline-block;'>提交</button>"+
								"</div>"+
								
								"<div class='praise_controller'>"+
									"<img alt='' width='30px' height='30px' src='"+ path +"/statics/img/praiseBefore.png'><span style='font-weight: 700; color:rgb(138,138,138)'>20</span>"+
								"</div>"+
							"</div>"+
						"</div>");
					}
					
				}
			}else if(data.ARTICLE_CODE == -1){
				layer.msg(data.ARTICLE_INFO,{icon:2});
			}else{
				layer.msg("系统错误",{icon:2});
			}
		},
		error:alert("失败")
	});
}