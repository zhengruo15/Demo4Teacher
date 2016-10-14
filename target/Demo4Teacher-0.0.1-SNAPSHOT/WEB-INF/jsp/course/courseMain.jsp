<%@page import="com.zry.demo.model.Teacher"%>
<%@page import="com.zry.demo.model.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/popup.js"></script>
<script type="text/javascript" src="../js/course.js"></script>
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/popup.css">
<title>Insert title here</title>
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
		<%@include file="../head.jsp"%>
	</div>
	<div class="dataShow">
		<table align="center" border="1">
			<tr>
				<td colspan="7">COURSE</td>
			</tr>
			<tr>
				<td>课程编号</td>
				<td>课程名字</td>
				<td>周</td>
				<td>开始时间</td>
				<td>结束时间</td>
				<td>上课老师</td>
				<td>操作</td>
			</tr>
			<tr>
				<%
					List<Course> courseList = (List<Course>) request
							.getAttribute("courseList");
					if (courseList == null || courseList.size() == 0) {
				%>
				<td colspan="7">No Data</td>
				<%
					} else {
						for (Course course : courseList) {
				%>
				<td><%=course.getCourseId()%></td>
				<td><%=course.getName()%></td>
				<td><%=course.getWeek()%></td>
				<td><%=course.getStartTime()%></td>
				<td><%=course.getEndTime()%></td>
				<td><%=course.getTeacherId()%></td>
				<td><a href="courseDetail?courseId=<%=course.getCourseId()%>">详情</a>
					<a href="#" class="update"
					onclick="update(<%=course.getCourseId()%>,'<%=course.getName()%>',
					'<%=course.getWeek()%>','<%=course.getStartTime()%>',
					'<%=course.getEndTime()%>',<%=course.getTeacherId()%> )">修改</a>
					<a href="removeCourse?courseId=<%=course.getCourseId()%>">删除</a></td>
			</tr>
			<%
				}
				}
			%>

		</table>
	</div>
	<div class="pop_box" style="display: none">
		<div class="in">
			<form id="addCourse" method="post"
				onsubmit="return validation_form(this)">
				请输入新增课程信息：<br /> 编号：<input class="id" name="courseId" type="text" /><br />
				名字：<input class="name" name="name" type="text" /><br /> 星期：<select
					class="week" name="week">
					<option value="一">一</option>
					<option value="二">二</option>
					<option value="三">三</option>
					<option value="四">四</option>
					<option value="五">五</option>
					<option value="六">六</option>
					<option value="日">日</option>
				</select><br /> 开始时间：<input class="startTime" name="startTime" type="time" /><br />
				结束时间：<input class="endTime" name="endTime" type="time" /><br />
				上课老师：<select class="teacherId" name="teacherId">
					<%
						List<Teacher> teachers = (List<Teacher>) request
								.getAttribute("teacherList");
						if (teachers == null || teachers.size() == 0) {
					%>
					<option value="">无老师信息</option>
					<%
						} else {
							for (Teacher teacher : teachers) {
					%>
					<option value="<%=teacher.getTeacherId()%>"><%=teacher.getTeacherId() + " " + teacher.getName()%></option>
					<%
						}
						}
					%>
				</select><br /> <input class="submit" type="submit" /><br />
			</form>
		</div>
		<div class="bg"></div>
	</div>
	<div align="center">
		<button class="add">新增</button>
		<button class="back">返回</button>
	</div>
	<div align="center" class="select">
		<form action="selectCourse" method="post">
			<table align="center">
				<tr>
					<td>请输入编号：<input class="id" name="courseId" type="text" /></td>
					<td>请输入名字：<input class="name" name="name" type="text" /></td>
				</tr>
				<tr>
					<td>请选择开始时间：<input class="startTime" name="startTime"
						type="time" />
					</td>
					<td>请选择结束时间：<input class="endTime" name="endTime" type="time" /></td>
				</tr>
				<tr>
					<td>请选择星期： <select class="week" name="week">
							<option></option>
							<option value="一">一</option>
							<option value="二">二</option>
							<option value="三">三</option>
							<option value="四">四</option>
							<option value="五">五</option>
							<option value="六">六</option>
							<option value="日">日</option>
					</select>
					</td>
					<td>请选择上课老师：<select class="teacherId" name="teacherId">
							<option></option>
							<%
								if (teachers != null && teachers.size() != 0) {
									for (Teacher teacher : teachers) {
							%>
							<option value="<%=teacher.getTeacherId()%>"><%=teacher.getTeacherId() + " " + teacher.getName()%></option>
							<%
								}
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input class="submit" type="submit" value="查询" /></td>
				</tr>
			</table>

		</form>

	</div>
</body>
</html>