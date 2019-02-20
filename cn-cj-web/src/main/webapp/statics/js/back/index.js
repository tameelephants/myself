var layer;
$(function(){
	layui.use('element', function () {
		var element = layui.element;
		// element.
		element.on('tab(test)', function (data) {
			console.log(data);
		});
	}) 
	$(".left_controller").css("width","15%");
	$(".center_controller").css("width","85%");
	$(".center_controller").css("margin-left","15%");
	$(".center_controller").css("height",$(window).height()-60);
	$(".put-away").toggle(
			function(){
				$(".left_controller").css("width","5%");
				$(".center_controller").css("margin-left","5%");
				$(".center_controller").css("width","95%");
				$(".put-away a").html("展开");
			},function(){
				$(".left_controller").css("width","15%");
				$(".center_controller").css("margin-left","15%");
				$(".center_controller").css("width","85%");
				$(".put-away a").html("收起");
			}
	);
	
});