package com.zry.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zry.demo.model.CourseAndTeacher;
import com.zry.demo.model.Student;
import com.zry.demo.service.StudentService;

@Controller
@RequestMapping("/studentDetail")
public class StudentDetailController {
	@Autowired
	private StudentService studentService;
	private String errorMessage = "";

	@RequestMapping("/studentDetail")
	public String studentDetail(Model model, String studentId) {
		int id = Integer.parseInt(studentId);
		Student student = studentService.selectStudent(id);
		List<CourseAndTeacher> courseTeacher = studentService
				.selectCourseTeacher(id);
		List<CourseAndTeacher> coursesUnselect = studentService
				.selectCourseUnselect(id);
		model.addAttribute("errorMessage", errorMessage);
		errorMessage = "";
		model.addAttribute("student", student);
		model.addAttribute("courseTeacher", courseTeacher);
		model.addAttribute("courseUnselect", coursesUnselect);
		return "student/studentDetail";
	}

	@RequestMapping("/addCourse")
	public String addStudentCourse(Model model, String studentId,
			String courseId) {
		int sId = Integer.parseInt(studentId);
		int cId = Integer.parseInt(courseId);
		studentService.addCourse(sId, cId);

		return studentDetail(model, studentId);

	}

	@RequestMapping("/removeCourse")
	public String removeCourse(Model model, String studentId, String courseId) {
		int sId = Integer.parseInt(studentId);
		int cId = Integer.parseInt(courseId);
		studentService.removeCourse(sId, cId);
		return studentDetail(model, studentId);
	}
}
