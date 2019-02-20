var layer;
var form;
var path;
var randomAboutArticle;
$(function(){
	path = document.getElementById("path").value;
	ramdonAboutArticle = document.getElementById("ramdonAboutArticle").value;
	layui.use('form', function () {
		form = layui.form;
	}); 
	//右键菜单
	$.contextMenu({
		selector: "#textarea" ,
		callback: function (key, options) {
			//加粗 下划线  斜体  清除所有样式  插入li
			if(key == 'bold' || key == "underline" || key == "italic" || key == "removeFormat" || key == "insertunorderedlist"){
				document.execCommand(key);
			}
			//字体颜色
			if(key == "black" || key == "blue" || key == "red" || key == "green" || key == "white"){
				document.execCommand("forecolor",false,key);
			}
			//背景颜色
			if(key == "bwhite"){
				document.execCommand("backColor",false,"white");
			}else if(key == "bred"){
				document.execCommand("backColor",false,"red");
			}else if(key == "byellow"){
				document.execCommand("backColor",false,"yellow");
			}else if(key == "bblue"){
				document.execCommand("backColor",false,"blue");
			}
			//字体大小
			if(key == "4" || key == "2" || key == "1"){
				document.execCommand("fontsize",false,key);
			}
			//添加p标签
			if(key == "p"){
				document.execCommand("formatblock",false,key);
			}

		},
		items: {
			"bold": {
				name: "字体粗细",
				icon: "edit",
			},
			"italic": {
				name: "斜体",
				icon: "edit",
			},
			"font-color": {
				name: "字体颜色 (c)", icon: function () {
					return 'context-menu-icon context-menu-icon-quit';
				},accesskey:"c",
				items:{
					"black":{ name:"默认"},
					"white":{name:"白色"},
					"red":{ name:"红色"},
					"blue":{ name:"蓝色"},
					"green":{ name:" 绿色"}
				}
			},
			"background-color": {
				name: "背景颜色 (b)", icon: function () {
					return 'context-menu-icon context-menu-icon-loading';
				},accesskey:"b",
				items:{
					"bwhite":{ name:"默认"},
					"bred":{ name:"红色"},
					"bblue":{ name:"蓝色"},
					"byellow":{ name:"黄色"}
				}
			}
			,
			"font-size": {
				name: "字体大小 (f)", icon: function () {
					return 'context-menu-icon context-menu-icon-edit';
				},accesskey:"f",
				items:{
					"4":{name:"大"},
					"2":{name:"中"},
					"1":{name:"小"},
				}
			}
			,
			"p": {
				name: "p标签", icon: function () {
					return 'context-menu-icon context-menu-icon-delete';
				},accesskey:"p"
			}
			,
			"underline": {
				name: "下划线 (u)", icon: function () {
					return 'context-menu-icon context-menu-icon-cut';
				},accesskey:"u"
			}
			,
			"removeFormat": {
				name: "清除样式 (r)", icon: function () {
					return 'context-menu-icon context-menu-icon-add';
				},accesskey:"r"
			},
			"insertunorderedlist": {
				name: "li标签 (l)", icon: function () {
					return 'context-menu-icon context-menu-icon-add';
				},accesskey:"l"
			}
		}
	});
	
	//右键粘贴
	function paste_img(e) {
		if (e.clipboardData && e.clipboardData.items) {
			var imageContent = e.clipboardData.getData('image/png');
			ele = e.clipboardData.items
			for (var i = 0; i < ele.length; ++i) {
				//粘贴图片
				if (ele[i].kind == 'file' && ele[i].type.indexOf('image/') !== -1) {
					var blob = ele[i].getAsFile();
					window.URL = window.URL || window.webkitURL;
					var blobUrl = window.URL.createObjectURL(blob);
					// 显示到div中，此时是显示的本地图片数据，并没有上传到服务器
					var new_img = $("<img src="+ blobUrl +" />");
					// * 必须用jq.data(key,object)方法进行存值,直接在img标签里写出来的是属性,获取不到的
//					new_img.data("data-file",blob);
					var new_imgs = new_img[0];
					// 移动div光标到新元素后面
					insertHtmlAtCaret(new_imgs);
					//上传文章截图
					layer.confirm("确认该截图上传吗?",{title:"温馨提示"},function(){
						loadArticleContentImg(blob);
					});
				}
				else return;
			}
		}
		else {
			alert('请尝试升级浏览器');
		}
	}
	
	//绑定粘贴事件
	document.getElementById('textarea').onpaste = function () { paste_img(event); return false; };
	
	//光标定位
	function insertHtmlAtCaret(childElement) {
		var sel, range;
		if (window.getSelection) {
			// IE9 and non-IE
			sel = window.getSelection();
			if (sel.getRangeAt && sel.rangeCount) {
				range = sel.getRangeAt(0);
				range.deleteContents();

				var el = document.createElement("div");
				el.appendChild(childElement);
				var frag = document.createDocumentFragment(), node, lastNode;
				while ((node = el.firstChild)) {
					lastNode = frag.appendChild(node);
				}

				range.insertNode(frag);
				if (lastNode) {
					range = range.cloneRange();
					range.setStartAfter(lastNode);
					range.collapse(true);
					sel.removeAllRanges();
					sel.addRange(range);
				}
			}
		}
		else if (document.selection && document.selection.type != "Control") {
			// IE < 9
			//document.selection.createRange().pasteHTML(html);
		}
	}
});

//保存文章
$(".save").click(function(){
	var formatData = new FormData();
	//获取文章标题
	var article_title = $(".article_title").val();
	//获取文章标签
	var labels = $("input[class='article_label']:checked");
	var labelss = new Array();
	for (var i = 0; i < labels.length; i++) {
		var label = $(labels[i]);
		var article_label = label.val();
		labelss.push(article_label);
	}
	//获取文章内容
	var textarea = $("#textarea").html();
	//获取文章背景图
	var article_bgimg = document.getElementById('article_bgimg').files[0];
	formatData.append("article_title",article_title);
	formatData.append("article_label",labelss);
	formatData.append("article_content",textarea);
	formatData.append("article_bgimg",article_bgimg);
	formatData.append("ramdonAboutArticle",ramdonAboutArticle);
	if($.trim(article_title) == ""){
		layer.msg("请上传文章标题",{icon:2});
		return;		
	}else if(labelss.length <= 0){
		layer.msg("请选择文章标签",{icon:2});
		return;
	}else if($.trim(textarea) == ""){
		layer.msg("请上传文章内容",{icon:2});
		return;
	}else if(article_bgimg == null){
		layer.msg("请上传文章背景图",{icon:2});
		return;
	}else{
		$.ajax({
			url:path + "/back/addArticle",
			type:"post",
			data:formatData,
			processData:false,
			contentType:false,
			success:function(data){
				if(data.ARTICLE_CODE == 1){
					layer.msg(data.ARTICLE_INFO,{icon:1});
					setTimeout(location.href=path + "/back/articleList", 3500);
				}else if(data.ARTICLE_CODE == -1){
					layer.msg(data.ARTICLE_INFO,{icon:2});
				}else{
					layer.msg("系统错误",{icon:2});
				}
			}
		});
	}
	
});

//上传截图
function loadArticleContentImg(blob){
	var formatData = new FormData();
	formatData.append("clipboardData",blob);
	formatData.append("ramdonAboutArticle",ramdonAboutArticle);
	$.ajax({
		url:path + '/back/pasteArticleImg',
		type:"post",
		processData:false,
		contentType:false,
		data:formatData,
		success:function(data){
			if(data.ARTICLE_CODE == 1 || data.ARTICLE_CODE == 2){
				layer.msg(data.ARTICLE_INFO,{icon:1});
			}else if(data.ARTICLE_CODE == -1){
				layer.msg(data.ARTICLE_INFO,{icon:2});
			}else{
				layer.msg("系统错误",{icon:2});
			}
		}
	});
}
















//获取选中文本
//function getSelectText(id) {
//var t = document.getElementById(id);
//if (window.getSelection) {
////获取Selection对象
//var se = window.getSelection();
////获取起始位置，这个是字符的序号位置，而不是坐标
//var start = se.anchorOffset;
////获取结束位置
//var end = se.focusOffset;
////获取起始的dom元素
//var startEl = se.anchorNode.parentElement;
////获取结束的dom元素
//var endEl = se.focusNode.parentElement;
////获取起始dom元素的文本内容
//var startText = startEl.innerText;
//var txt = '';
//if (startEl == endEl) {
//txt = startText.substring(start, end);
//}
//return [start,end,txt]
//}
//}