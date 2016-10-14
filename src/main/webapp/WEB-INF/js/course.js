//更新
function update(courseId,name,week,startTime,endTime,teacherId) {
	$(".pop_box .id").attr("readonly", "readonly");
	$(".pop_box .id").val(courseId);
	$(".pop_box .name").val(name);
	$(".pop_box .week").val(week);
	$(".pop_box .startTime").val(startTime);
	$(".pop_box .endTime").val(endTime);
	$(".pop_box .teacherId").val(teacherId);
	$(".pop_box .submit").attr("formaction", "updateCourse");
}

// 新增
$(function() {
	$(".add").click(function() {
		$(".pop_box .submit").attr("formaction", "addCourse");
	})
})

function validation_form(thisform) {
	with (thisform) {
		var a = startTime.value;
		var b = endTime.value;
		
		if (validation_required(courseId, "课程ID不能为空") == false) {
			courseId.focus();
			return false;
		}
		if (validation_required(name, "课程名字不能为空") == false) {
			name.focus();
			return false;
		}
		if (validation_required(week, "周几不能为空") == false) {
			week.focus();
			return false;
		}
		if (validation_required(startTime, "开始时间不能为空") == false) {
			startTime.focus();
			return false;
		}
		if (validation_required(endTime, "结束时间不能为空") == false){
			endTime.focus();
			return false;
		}
		if(validation_time(startTime.value,endTime.value)==false){
			startTime.focus()
			alert("开始时间不能大于结束时间");
			return false;
		}
		if(validation_required(teacherId,"教师编号不能为空") == false){
			teacherId.focus();
			return false;
		}
	}
}