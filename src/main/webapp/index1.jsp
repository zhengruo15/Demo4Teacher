<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="css/type.css">
<link rel="stylesheet" type="text/css" href="css/popup.css">
<title>Insert title here</title>
<script type="text/javascript">
	var xmlhttp;
	function xmlOnLoad() {
		xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = change;
		xmlhttp.open("GET", "test/resource/test.txt", true);
		xmlhttp.send();
	}
	function change() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("ajaxTest").innerHTML = xmlhttp.responseText;
		}
	}
</script>
</head>
<body>
	<script>
		$(function() {
			$("#open").click(function() {
				$('#pop_box').show();
			})
		})
	</script>
	<button id="open">弹出</button>
	<div class="pop_box" id="pop_box" style="display: none;">
		<div class="in">弹出</div>
		<div class="bg"></div>
	</div>
<!-- 	<h1>这是一个标题 This is a title</h1>
	<button onclick="alert('welcome')">点我</button>
	<button onclick="xmlOnLoad()">ajax</button>
	<div id="ajaxTest">this is a ajax test</div> -->
</body>
</html>