//更新
function update(teacherId, name, sex, age) {
	$(".pop_box .id").attr("readonly", "readonly");
	$(".pop_box .id").val(teacherId);
	$(".pop_box .name").val(name);
	$(".pop_box .sex").val(sex);
	$(".pop_box .age").val(age);
	$(".pop_box .submit").attr("formaction", "updateTeacher");
}

// 新增
$(function() {
	$(".add").click(function() {
		$(".pop_box .id").val("");
		$(".pop_box .name").val("");
		$(".pop_box .age").val("");
		$(".pop_box .submit").attr("formaction", "addTeacher");
	})
})

function validation_form(thisform) {
	with (thisform) {
		if (validation_required(teacherId, "ID不能为空") == false) {
			teacherId.focus();
			return false;
		}
		if (validation_required(name, "名字不能为空") == false) {
			name.focus();
			return false;
		}
		if (validation_required(sex, "性别不能为空") == false) {
			sex.focus();
			return false;
		}
		if (validation_required(age, "名字不能为空") == false) {
			age.focus();
			return false;
		}
	}
}