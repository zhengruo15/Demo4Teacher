<%@page import="com.zry.demo.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="../css/popup.css" />
<link rel="stylesheet" type="text/css" href="../css/main.css" />
<script type="text/javascript" src="../js/student.js"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<link rel="stylesheet" type="text/css" href="../css/head.css">
<title>显示student</title>
</head>
<body>
	<%
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (errorMessage != null && errorMessage.length() != 0) {
	%>
	<script>alert("<%=errorMessage%> ")</script>
	<%
		}
	%>
	<div class="top" align="center">
		<%@ include file="../head.jsp"%>
	</div>
	<table align="center" border="1">
		<tr>
			<td align="center" colspan="5">STUDENT</td>
		</tr>
		<tr>
			<td><b>编号</b></td>
			<td><b>名字</b></td>
			<td><b>性别</b></td>
			<td><b>年纪</b></td>
			<td><b>操作</b></td>
		</tr>
		<%
			List<Student> studentList = (List<Student>) request
					.getAttribute("studentList");
			if (studentList == null || studentList.size() < 1) {
		%>
		<tr>
			<td align="center" colspan="5">No Data</td>
		</tr>
		<%
			} else {
				for (Student student : studentList) {
		%>
		<tr>
			<td><%=student.getStudentId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getSex()%></td>
			<td><%=student.getAge()%></td>
			<td><a
				href="<%=request.getContextPath() %>/studentDetail/studentDetail?studentId=<%=student.getStudentId()%>">详情</a> <a
				class="update"
				onclick="update(<%=student.getStudentId()%>,'<%=student.getName()%>','<%=student.getSex()%>',<%=student.getAge()%>)"
				href="#">修改</a> <a
				href="removeStudent?studentId=<%=student.getStudentId()%>">删除</a></td>
		</tr>
		<%
			}
			}
		%>
	</table>
	<div class="pop_box" style="display: none">
		<div class="in">
			<form id="addStudent" method="post"
				onsubmit="return validation_form(this)">
				请输入新增学生信息：<br /> 编号：<input class="id" name="studentId" type="text" /><br />
				名字：<input class="name" name="name" type="text" /><br /> 性别：<select
					name="sex" class="sex">
					<option value="男">男</option>
					<option value="女">女</option>
				</select><br /> 年纪：<input class="age" name="age" type="text" /><br />
				<input class="submit" type="submit" />
			</form>
		</div>
		<div class="bg"></div>
	</div>
	<div align="center">
		<button type="button" class="add">新增</button>
		<button type="button" class="back">返回</button>
	</div>
	<div class="select" align="center">
		<form action="selectStudent" method="post">
			<table align="center">
				<tr>
					<td>请输入编号:<input class="id" type="text" name="studentId"></td>
					<td>请输入名字:<input class="name" type="text" name="name"></td>
				</tr>
				<tr>
					<td>请输入性别:<select name="sex" class="sex">
							<option value=""></option>
							<option value="男">男</option>
							<option value="女">女</option>
					</select></td>
					<td>请输入年纪:<input class="age" type="text" name="age"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="查询" /></td>
				</tr>
			</table>
		</form>

	</div>

</body>
</html>