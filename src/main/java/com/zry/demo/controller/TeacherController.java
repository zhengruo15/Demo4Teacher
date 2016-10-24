package com.zry.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zry.demo.model.Teacher;
import com.zry.demo.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	private String errorMessage;
	private String test;

	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@RequestMapping("/listTeacher")
	public String teacherList(Model model) {
		model.addAttribute("teacherList", teacherService.selectAllTeacher());
		model.addAttribute("errorMessage",errorMessage);
		errorMessage="";
		return "teacher/teacherMain";
	}

	@RequestMapping("/teacherDetail")
	public String teacherDetail(Model model, String teacherId) {
		int id = Integer.parseInt(teacherId);
		List<Teacher> teachers = new ArrayList<Teacher>();
		teachers.add(teacherService.selectTeacher(id));
		model.addAttribute("teacherList", teachers);
		return "teacher/teacherMain";
	}

	@RequestMapping("/removeTeacher")
	public String teacherRemove(String teacherId) {
		int id = Integer.parseInt(teacherId);
		teacherService.deleteTeacher(id);
		return "teacher/teacherShow";
	}

	@RequestMapping("/addTeacher")
	public String teacherAdd(@Valid Teacher teacher, Errors errors) {
		if (errors.hasErrors()) {
			List<ObjectError> errorList = errors.getAllErrors();
			for (ObjectError error : errorList) {
				errorMessage = errorMessage + error.getDefaultMessage() + " ";
				System.out.println(error.getDefaultMessage());
			}
			return "teacher/teacherShow";
		}
		errorMessage += teacherService.addTeacher(teacher);
		return "teacher/teacherShow";
	}

	@RequestMapping("/selectTeacher")
	public String teacherSelect(Model model, Teacher teacher) {
		List<Teacher> teachers = teacherService.selectTeacher(teacher);
		model.addAttribute("teacherList", teachers);
		return "teacher/teacherMain";
	}

	@RequestMapping("/updateTeacher")
	public String teacherUpdate(Model model, Teacher teacher) {
		teacherService.update(teacher);
		return "teacher/teacherShow";
	}
}
