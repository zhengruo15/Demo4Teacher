package com.zry.demo.dao.course;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zry.demo.dao.BaseDao;
import com.zry.demo.model.Course;
import com.zry.demo.model.CourseAndTeacher;

@Repository
public class CourseDaoImpl extends BaseDao {
	@Resource
	public void setCourseMapper(CourseMapper courseMapper) {
		this.courseMap = courseMapper;
	}

	public List<Course> selectAllCourse() {
		return courseMap.selectAllCourse();
	}

	public void addCourse(Course course) {
		courseMap.addCourse(course);
	}

	public void updateCourse(Course course) {
		courseMap.updateCourse(course);

	}

	public void removeCourse(int courseId) {
		courseMap.removeCourse(courseId);

	}

	public List<Course> selectCourses(Course course) {
		return courseMap.selectCourses(course);
	}

	public Course selectCourse(int id) {
		return courseMap.selectCourse(id);
	}

	public List<CourseAndTeacher> selectCourseTeacher(int studentId) {
		return courseMap.selectCourseTeacher(studentId);
	}

	public List<CourseAndTeacher> selectCourseUnselect(int id) {
		return courseMap.selectCourseUnselect(id);
	}


}
