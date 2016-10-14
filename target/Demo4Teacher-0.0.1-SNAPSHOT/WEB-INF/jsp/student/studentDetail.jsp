<%@page import="com.zry.demo.model.CourseAndTeacher"%>
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
<script type="text/javascript" src="../js/studentDetail.js"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<link rel="stylesheet" type="text/css" href="../css/head.css">
<title>显示student</title>
</head>
<body>
	<%
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (errorMessage != null && errorMessage.length() != 0) {
	%>
	<script>alert("<%=errorMessage%>")</script>
	<%
		}
	%>
	<div class="top" align="center">
		<%@ include file="../head.jsp"%>
	</div>
	<table align="center" border="1">
		<tr>
			<td align="center" colspan="4">STUDENT</td>
		</tr>
		<tr>
			<td><b>编号</b></td>
			<td><b>名字</b></td>
			<td><b>性别</b></td>
			<td><b>年纪</b></td>
		</tr>
		<%
			Student student = (Student) request.getAttribute("student");
			if (student == null) {
		%>
		<tr>
			<td align="center" colspan="5">No Data</td>
		</tr>
		<%
			} else {
		%>
		<tr>
			<td><%=student.getStudentId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getSex()%></td>
			<td><%=student.getAge()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<div class="studentCourse">
		<table align="center" border="1">
			<tr>
				<td colspan="7">选课信息</td>
			</tr>
			<tr>
				<td>课程编号</td>
				<td>课程名称</td>
				<td>周</td>
				<td>开始时间</td>
				<td>结束时间</td>
				<td>上课老师</td>
				<td>操作</td>
			</tr>

			<%
				List<CourseAndTeacher> courseTeachers = (List<CourseAndTeacher>) request
						.getAttribute("courseTeacher");
				if (courseTeachers == null || courseTeachers.size() == 0) {
			%>
			<tr>
				<td colspan="7">No Data</td>
			</tr>
			<%
				} else {
					for (CourseAndTeacher courseTeacher : courseTeachers) {
			%>
			<tr>
				<td><%=courseTeacher.getCourseId()%></td>
				<td><%=courseTeacher.getName()%></td>
				<td><%=courseTeacher.getWeek()%></td>
				<td><%=courseTeacher.getStartTime()%></td>
				<td><%=courseTeacher.getEndTime()%></td>
				<td><%=courseTeacher.getTeacher().getTeacherId() + " "
							+ courseTeacher.getTeacher().getName()%></td>
				<td><a
					href="removeCourse?studentId=<%=student.getStudentId()%>&courseId=<%=courseTeacher.getCourseId()%>">删除</a></td>
			</tr>
			<%
				}
				}
			%>

		</table>
	</div>
	<div align="center">
		<select class="selectCourse">
			<%
				List<CourseAndTeacher> courseUnselect = (List<CourseAndTeacher>) request
						.getAttribute("courseUnselect");
				for (CourseAndTeacher courseTeacher : courseUnselect) {
			%>
			<option value="<%=courseTeacher.getCourseId()%>"><%=courseTeacher.getCourseId() + " "
						+ courseTeacher.getName() + " 周"
						+ courseTeacher.getWeek() + " "
						+ courseTeacher.getStartTime() + " "
						+ courseTeacher.getEndTime()%>
				<%
					}
				%>
			
		</select>
	</div>
	<div align="center">
		<button type="button" class="addCourse" onclick=addCourse("<%=student.getStudentId()%>")>新增</button>
		<button type="button" class="back">返回</button>
	</div>
</body>
</html>