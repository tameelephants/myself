<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mmp</title>

</head>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/vue.js"></script> --%>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

<body>

	<h1 id="app">{{ message }}</h1>
	<script type="text/javascript">
		var vue = new Vue({
			el:"#app",
			data:{
				message:"hello vue!"
			}
		})
	</script>
</body>
	
</html>