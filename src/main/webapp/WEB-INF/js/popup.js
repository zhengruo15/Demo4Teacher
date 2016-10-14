//点背景隐藏
$(function() {
	$(".pop_box .bg").click(function() {
		$(".pop_box").hide();
	})
})
// 新增、修改弹出框
$(function() {
	$(".add,.update").click(function() {
		$(".pop_box").show();
	})
})

$(function() {
	$(".add").click(function() {
		$(".pop_box .submit").val("添加");
	})
})

$(function() {
	$(".update").click(function() {
		$(".pop_box .submit").val("更新");
	})
})

//返回
$(function(){
	$(".back").click(function(){
		history.go(-1);
	})
})
//验证空
function validation_required(field, alerttext) {
	with (field) {
		if (value == null || value == "") {
			alert(alerttext);
			return false;
		} else {
			return true;
		}
	}
}
function validation_time(startTime,endTime){
	var stArray=startTime.toString().split(":");
	var etArray=endTime.toString().split(":");
	var st = new Date(stArray[0],stArray[1],"00");
	var et = new Date(etArray[0],etArray[1],"00");
	if(st>et){
		return false;
	}
	return true;
}

//控制文本框输入数字
$(function() {
	$(".id,.age").keydown(function() {
		var k = event.keyCode;
		if ((k <= 57 && k >= 48) || (k <= 105 && k >= 96) || (k == 8) || (k==9)) {
			return true;
		} else {
			alert("只能输入数字！");
			return false;
		}
	})
})