function addCourse(studentId) {
	var courseId = $(".selectCourse").val();
	if (courseId == null || courseId.length == 0) {
		alert("课程为空，不能添加");
	} else {
		window.location = "addCourse?studentId=" + studentId + "&courseId="
				+ courseId;
	}
}