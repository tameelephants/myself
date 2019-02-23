var layer;
var form;
$(function(){
	$(".toutiao_ul li").css('color','black');
	//测试弹框
	layui.use(['layer','form'],function(){
		layer = layui.layer;
		form = layui.form;
	}); 
	$(".li_controller").click(function(){
		layer.msg('hello layer');
	});
	 
	//轮播图
	layui.use('carousel',function(){
		var carousel = layui.carousel;
		carousel.render({
			elem:'#lunbo',	 //选择的容器 
			width:'99%',	 //容器宽度
			arrow:'hover',   //always总显示,none不显示(左右箭头)
			interval:2000,   //默认3000
			anim:'fade', 	 //updown上下切换 ,default左右切换(切换方式)
			index:0,         //第一张图片索引
			indicator:'none' //outside外部,inside内部(小圈圈)
		});
	});
	
	$(".toutiao_ul li").hover(function(){
		$(".article p strong").css('color','black');
	});
	
	$("div.fourImg div").hover(
		function(){
			$(this).css('background-color','rgba(0,0,0,0)');
		},
		function(){
			$(this).css('background-color','rgba(0,0,0,0.2)');
		}
	);
});

