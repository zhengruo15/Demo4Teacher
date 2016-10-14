package com.zry.demo.dao.course;

import java.util.HashMap;
import java.util.List;

import com.zry.demo.model.Course;
import com.zry.demo.model.CourseAndTeacher;
import com.zry.demo.model.Teacher;

public interface CourseMapper {
	public List<Course> selectAllCourse();

	public void addCourse(Course course);

	public void updateCourse(Course course);

	public void removeCourse(int courseId);

	public List<Course> selectCourses(Course course);

	public Course selectCourse(int id);

	public List<CourseAndTeacher> selectCourseTeacher(int studentId);

	public List<CourseAndTeacher> selectCourseUnselect(int id);



}
