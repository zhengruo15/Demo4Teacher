package com.zry.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zry.demo.model.Student;
import com.zry.demo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	private String errorMessage = "";

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/listStudent")
	public String studentList(Model model) {
		model.addAttribute("studentList", studentService.selectAllStudent());
		model.addAttribute("errorMessage", errorMessage);
		errorMessage = "";
		return "student/studentMain";

	}

	@RequestMapping("/removeStudent")
	public String studentRemove(String studentId) {
		int id = Integer.parseInt(studentId);
		studentService.deleteStudent(id);
		return "student/studentShow";
	}

	@RequestMapping("/addStudent")
	public String studentAdd(@Valid Student student, Errors errors) {
		if (errors.hasErrors()) {
			List<ObjectError> errorList = errors.getAllErrors();
			for (ObjectError error : errorList) {
				errorMessage = errorMessage + error.getDefaultMessage() + " ";
				System.out.println(error.getDefaultMessage());
			}
			return "student/studentShow";
		}
		errorMessage += studentService.addStudent(student);
		return "student/studentShow";
	}

	@RequestMapping("/selectStudent")
	public String studentSelect(Model model, Student student) {
		List<Student> students = studentService.selectStudent(student);
		model.addAttribute("studentList", students);
		return "student/studentMain";
	}

	@RequestMapping("/updateStudent")
	public String studentUpdate(Model model, Student student) {
		studentService.update(student);
		return "student/studentShow";
	}
}
