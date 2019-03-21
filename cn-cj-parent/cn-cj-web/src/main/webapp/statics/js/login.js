var path = $("#path").val();
var layer;
var isOK=true;
var login_error = $(".login_error");
var register_error = $(".register_error");
$(function() {
	$(".loginAll").css("height",$(window).height());
	$(".userAccount").val("");
	$(".userPassword").val("");
	$(".toutiao_ul li").css('color','black');
	//测试弹框
	layui.use(['layer'],function(){
		layer = layui.layer;
	}); 
});
//判断当前账号是否符合要求
function isUserAccount(){
	var register_userAccount = $(".register-userAccount").val();
	var reg_userAccount = new RegExp(/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/);
	if(!reg_userAccount.test($.trim(register_userAccount))){
		register_error.html("<span><i class='layui-icon layui-icon-close-fill'></i> 用户名必须大于6位,且包含数字和字母</span>");
		isOK = false;
	}else{
		register_error.html("")
		isOK = true;;
	}
}
//判断当前密码是否符合要求
function isUserPassword(){
	var register_userPassword = $(".register-userPassword").val();
	var reg_userPassword = new RegExp(/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/);
	if(!reg_userPassword.test($.trim(register_userPassword))){
		register_error.html("<span><i class='layui-icon layui-icon-close-fill'></i> 密码必须大于6位,且包含数字和字母</span>");
		isOK = false;
	}else{
		register_error.html("")
		isOK = true;;
	}
}
//判断当前邮箱是否符合要求
function isUserEamil(){
	var register_userEmail = $(".register-userEmail").val();
	var reg_userEmail = new RegExp(/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/);
	if(!reg_userEmail.test($.trim(register_userEmail))){
		register_error.html("<span><i class='layui-icon layui-icon-close-fill'></i> 邮箱不符合规范</span>");
		isOK = false;
	}else{
		register_error.html("")
		isOK = true;;
	}
}
//登录或注册
function loginOrRegister(ow) {
	var owr = $(ow);
	var userAccount = $(".userAccount").val();
	var userPassword = $(".userPassword").val();
	var rememberMe = $(".rememberMe").val()
	
	var register_userAccount = $(".register-userAccount").val();
	var register_userPassword = $(".register-userPassword").val();
	var register_userEmail = $(".register-userEmail").val();
	var verifyCode = $(".verifyCode").val();
	var flag = true;
	//注册
	if(typeof(owr.parents(".layui-form-item").prev().find(".verifyCode").val()) != "undefined"){
		if ($.trim(register_userAccount) == "") {
			register_error.html("<span><i class='layui-icon layui-icon-close-fill'>&nbsp;</i> 请填写用户名</span>");
			flag = false;
		}else if ($.trim(register_userPassword) == "") {
			register_error.html("<span><i class='layui-icon layui-icon-close-fill'>&nbsp;</i> 请填写密码</span>");
			flag = false;
		}else if($.trim(register_userEmail) == ""){
			register_error.html("<span><i class='layui-icon layui-icon-close-fill'>&nbsp;</i> 请填写邮箱</span>");
			flag = false;
		}else if($.trim(verifyCode) == ""){
			register_error.html("<span><i class='layui-icon layui-icon-close-fill'>&nbsp;</i> 请填写验证码</span>");
			flag = false;
		} 
		if(flag && isOK){
			$.ajax({
				url:path + '/user/doRegister',
				data:{
					register_userAccount:register_userAccount,
					register_userPassword:register_userPassword,
					register_userEmail:register_userEmail,
					verifyCode:verifyCode
				},
				type:'post',
				dataType:'json',
				success:function(data){
					if(data.REGISTER_CODE == 1){
						layer.msg(data.REGISTER_INFO,{icon:1});
						setTimeout(function(){
							overback();	
						}, 1000);
						//调用旋转方法
					}else{
						layer.msg(data.REGISTER_INFO,{icon:2});
					}
				}
			});
		}
	}
	//登录
	else{
		if ($.trim(userAccount) == "") {
			login_error.html("<span><i class='layui-icon layui-icon-close-fill'>&nbsp;</i> 请填写用户名</span>");
			flag = false;
		}else if ($.trim(userPassword) == "") {
			login_error.html("<span><i class='layui-icon layui-icon-close-fill'>&nbsp;</i> 请填写密码</span>");
			flag = false;
		}
		if(flag){
			$.ajax({
				url:path + '/user/doLogin',
				data:{
					userAccount:userAccount,
					userPassword:userPassword,
					rememberMe:rememberMe
				},
				async:false,
				dataType:'',
				type:'POST',
				success:function(data){
					if(data.LOGIN_CODE == 1){
						layer.msg(data.LOGIN_INFO,{icon:1});
						setTimeout(location.href=path + "/user/index", 2000);
					}else
						layer.msg(data.LOGIN_INFO,{icon:2});
					},
			});
		}
	}
}
//显示密码
function showPwd(ow){
	var owr = $(ow);
	var flag = owr.prev().prev().parent().parent().prev().parent().parent().attr("id");
	var password = owr.prev().val();
	if(flag == "register-user"){
		$(".register-reload").html("<div class='icon_account'><i class='layui-icon layui-icon-password'></i></div><input type='text' value='"+ password +"' name='userPassword' required lay-verify='required' placeholder='请输入密码' autocomplete='off' class='layui-input register-userPassword border-red'><div onclick='hidePwd(this)' class='show_pwd eg'><i class='glyphicon glyphicon-eye-open' style='font-size: 18px;'></i></div>");
	}else{
		$(".login-reload").html("<div class='icon_account'><i class='layui-icon layui-icon-password'></i></div><input type='text' value='"+ password +"' name='userPassword' required lay-verify='required' placeholder='请输入密码' autocomplete='off' class='layui-input userPassword border-green'><div onclick='hidePwd(this)' class='show_pwd'><i class='glyphicon glyphicon-eye-open' style='font-size: 18px;'></i></div>");
	}
}
//隐藏密码
function hidePwd(ow){
	var owr = $(ow);
	var flag = owr.prev().prev().parent().parent().prev().parent().parent().attr("id");
	var password = owr.prev().val();
	if(flag == "register-user"){
		$(".register-reload").html("<div class='icon_account'><i class='layui-icon layui-icon-password'></i></div><input type='password' value='"+ password +"' name='userPassword' required lay-verify='required' placeholder='请输入密码' autocomplete='off' class='layui-input register-userPassword border-red'><div onclick='showPwd(this)' class='show_pwd eg'><i class='glyphicon glyphicon-eye-open' style='font-size: 18px;'></i></div>");
	}else{
		$(".login-reload").html("<div class='icon_account'><i class='layui-icon layui-icon-password'></i></div><input type='password' value='"+ password +"' name='userPassword' required lay-verify='required' placeholder='请输入密码' autocomplete='off' class='layui-input userPassword border-green'><div onclick='showPwd(this)' class='show_pwd'><i class='glyphicon glyphicon-eye-open' style='font-size: 18px;'></i></div>");
	}
}
//翻转注册页面(表单翻转)
function overturn(){
	alert(1);
	document.getElementById("tableIn_register").focus();
	document.getElementById("verification").src= path + "/user/createverifyCode?hehe="+Math.random()
	register_error.html("");
	$(".border-green").val("");
	$(".border-red").val("");
	$(".loginAll").css("background-image","url('"+path+"/statics/img/bgi.jpg')");
	$(".front").css("cssText","z-index:1 !important");
	$(".front").css("transform","rotateY(180deg) !important");
	$(".front").css("-webkit-transform","rotateY(180deg)");
	$(".front").css("-moz-transform","rotateY(180deg)");
	$(".front").css("-ms-transform","rotateY(180deg)");
	$(".front").css("-o-transform","rotateY(180deg)");

	$(".back").css("cssText","z-index:2 !important");
	$(".back").css("transform","rotateY(-0deg)");
	$(".back").css("-webkit-transform","rotateY(0deg)");
	$(".back").css("-moz-transform","rotateY(0deg)");
	$(".back").css("-ms-transform","rotateY(0deg)");
	$(".back").css("-o-transform","rotateY(-0deg)");

}
//返回登录页面(表单翻转)
function overback(){
	document.getElementById("tableIn_login").focus();
	login_error.html("");
	$(".border-green").val("");
	$(".border-red").val("");
	$(".loginAll").css("background-image","url('"+path+"/statics/img/bgi.png')");
	$(".front").css("cssText","z-index:2 !important");
	$(".front").css("transform","rotateY(0deg)");
	$(".front").css("-webkit-transform","rotateY(0deg)");
	$(".front").css("-moz-transform","rotateY(0deg)");
	$(".front").css("-ms-transform","rotateY(0deg)");
	$(".front").css("-o-transform","rotateY(0deg)");

	$(".back").css("cssText","z-index:1 !important");
	$(".back").css("transform","rotateY(180deg)");
	$(".back").css("-webkit-transform","rotateY(180deg)");
	$(".back").css("-moz-transform","rotateY(180deg)");
	$(".back").css("-ms-transform","rotateY(180deg)");
	$(".back").css("-o-transform","rotateY(180deg)");

}
//重新加载验证码
function aginCreateverifyCode(){
	document.getElementById("verification").src= path + "/user/createverifyCode?hehe="+Math.random()
}