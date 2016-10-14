package com.zry.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zry.demo.model.CourseAndTeacher;
import com.zry.demo.model.Student;

@Service
public class StudentService extends BaseService {

	public Student selectStudent(int id) {
		return studentDao.selectStudent(id);
	}

	public List<Student> selectAllStudent() {
		return studentDao.selectAllStudent();
	}

	public List<Student> selectStudent(Student student) {
		return studentDao.selectStudents(student);
	}

	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
	}

	public String addStudent(Student student) {
		String errorMessage = "";
		if (repeatJudge(student) == false) {
			studentDao.addStudent(student);
		} else {
			errorMessage = "编号重复了 ";
		}
		return errorMessage;
	}

	// false代表没有重复
	private boolean repeatJudge(Student student) {
		if (studentDao.selectStudent(student.getStudentId()) == null) {
			return false;
		}
		return true;
	}

	public void update(Student student) {
		studentDao.updateStudent(student);
	}

	public List<CourseAndTeacher> selectCourseTeacher(int studentId) {
		return courseDao.selectCourseTeacher(studentId);

	}

	public List<CourseAndTeacher> selectCourseUnselect(int id) {
		return courseDao.selectCourseUnselect(id);
	}

	public void addCourse(int sId, int cId) {
		HashMap<String,Integer> hash = new HashMap<String,Integer>();
		hash.put("studentId", sId);
		hash.put("courseId", cId);
		studentDao.addCourse(hash);
		
	}

	public void removeCourse(int sId, int cId) {
		HashMap<String,Integer> hash = new HashMap<String,Integer>();
		hash.put("studentId", sId);
		hash.put("courseId", cId);
		studentDao.removeCourse(hash);
	}

}
