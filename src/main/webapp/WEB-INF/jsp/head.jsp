<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/head.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>横向导航栏</title>
</head>
<body>
	<div class="nav">
		<ul>
			<li><a href="<%=request.getContextPath()%>/teacher/listTeacher">教师信息</a></li>
			<li><a href="<%=request.getContextPath()%>/student/listStudent">学生信息</a></li>
			<li><a href="<%=request.getContextPath()%>/course/listCourse">课程信息</a></li>
			<li><a href="#">导航3</a></li>
			<li><a href="#">导航4</a></li>
			<li><a href="#">导航5</a></li>
			<li><a href="#">导航6</a></li>
		</ul>
	</div>
</body>
</html>