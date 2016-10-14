package com.zry.demo.service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zry.demo.dao.course.CourseMapper;
import com.zry.demo.model.Course;
import com.zry.demo.model.Teacher;

@Service
public class CourseService extends BaseService {

	public List<Course> selectAllCourse() {
		return courseDao.selectAllCourse();
	}

	public List<Teacher> selectTeachers() {

		return teacherDao.selectAllTeacher();
	}

	public String addCourse(Course course) {
		String errorMessage = "";
		if (repeatJudge(course) == false) {
			courseDao.addCourse(course);
		} else {
			errorMessage = "编号重复了 ";
		}
		return errorMessage;
	}

	private boolean repeatJudge(Course course) {
		if (courseDao.selectCourse(course.getCourseId()) == null) {
			return false;
		}
		return true;
	}

	public Course toCourse(String courseId, String name, String week,
			String startTime, String endTime, String teacherId) {
		Course course = new Course();
		if (courseId != null && courseId.length() != 0) {
			course.setCourseId(Integer.parseInt(courseId));
		}
		course.setName(name);
		if (week != null && week.length() != 0) {
			course.setWeek(week);
		}
		if (startTime != null && startTime.length() != 0) {
			Time st = string2Time(startTime);
			course.setStartTime(st);
		}
		if (endTime != null && endTime.length() != 0) {
			Time et = string2Time(endTime);
			course.setEndTime(et);
		}
		if (teacherId != null && teacherId.length() != 0) {
			course.setTeacherId(Integer.parseInt(teacherId));
		}
		return course;
	}

	private Time string2Time(String time) {
		String[] timeLen = time.split(":");
		if (timeLen.length < 3) {
			time = time + ":00";
		}
		Time t = Time.valueOf(time);
		/*
		 * try{ t=(Time) format.parse(time); }catch(Exception e){
		 * e.printStackTrace(); }
		 */
		return t;
	}

	public void updateCourse(Course course) {
		courseDao.updateCourse(course);

	}

	public void removeCourse(int courseId) {
		courseDao.removeCourse(courseId);

	}

	public List<Course> selectCourses(Course course) {
		return courseDao.selectCourses(course);
	}

	public Course selectCourse(int id) {
		return courseDao.selectCourse(id);
	}

}
