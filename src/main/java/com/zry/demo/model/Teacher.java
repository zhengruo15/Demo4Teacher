package com.zry.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Teacher {
	@Min(value=1000,message="学生编号最小为1000")
	@Max(value=1999,message="学生编号最大为1999")
	@NotNull(message="编号只能为数字")
	private Integer teacherId;
	@NotNull(message="名字不能为空")
	private String name;
	@Pattern(regexp = "['男''女']",message="性别只为男或女")
	private String sex;
	@NotNull(message="年纪只能为数字")
	@Max(value=150,message="年纪最大值为150")
	@Min(value=0,message="年纪最小值为0")
	private Integer age;

	public Integer getTeacherId() {

		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
