package com.zry.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zry.demo.model.Course;
import com.zry.demo.model.Teacher;
import com.zry.demo.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	private String errorMessage = "";

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@RequestMapping("/listCourse")
	public String courseList(Model model) {
		List<Course> courses = courseService.selectAllCourse();
		model.addAttribute("courseList", courses);
		List<Teacher> teachers = courseService.selectTeachers();
		model.addAttribute("teacherList", teachers);
		model.addAttribute("errorMessage",errorMessage);
		errorMessage = "";
		return "course/courseMain";
	}

	@RequestMapping("/courseDetail")
	public String courseDetail(Model model, String courseId) {
		int id = Integer.parseInt(courseId);
		List<Course> courses = new ArrayList<Course>();
		courses.add(courseService.selectCourse(id));
		model.addAttribute("courseList", courses);
		List<Teacher> teachers = courseService.selectTeachers();
		model.addAttribute("teacherList", teachers);
		return "course/courseMain";
	}

	@RequestMapping("/addCourse")
	public String courseAdd(String courseId, String name, String week,
			String startTime, String endTime, String teacherId) {
		Course course = courseService.toCourse(courseId, name, week, startTime,
				endTime, teacherId);
		errorMessage += courseService.addCourse(course);
		return "course/courseShow";
	}

	@RequestMapping("/updateCourse")
	public String courseUpdate(String courseId, String name, String week,
			String startTime, String endTime, String teacherId) {
		Course course = courseService.toCourse(courseId, name, week, startTime,
				endTime, teacherId);
		courseService.updateCourse(course);
		return "course/courseShow";
	}

	@RequestMapping("/removeCourse")
	public String courseRemove(String courseId) {
		courseService.removeCourse(Integer.parseInt(courseId));
		return "course/courseShow";
	}

	@RequestMapping("/selectCourse")
	public String courseSelect(Model model, String courseId, String name,
			String week, String startTime, String endTime, String teacherId) {
		Course course = courseService.toCourse(courseId, name, week, startTime,
				endTime, teacherId);
		List<Course> courses = courseService.selectCourses(course);
		model.addAttribute("courseList", courses);
		List<Teacher> teachers = courseService.selectTeachers();
		model.addAttribute("teacherList", teachers);
		return "course/courseMain";
	}
}
