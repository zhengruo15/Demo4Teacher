package com.zry.demo.dao.student;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zry.demo.dao.BaseDao;
import com.zry.demo.model.Student;

@Repository
public class StudentDaoImpl extends BaseDao {

	public Student selectStudent(int id) {
		return studentMap.selectStudent(id);
	}

	public List<Student> selectAllStudent() {
		return studentMap.selectAllStudent();
	}

	public List<Student> selectStudents(Student student) {
		return studentMap.selectStudents(student);
	}

	public void deleteStudent(int id) {
		studentMap.deleteStudent(id);
	}

	public void addStudent(Student student) {
		studentMap.addStudent(student);
	}

	public void updateStudent(Student student) {
		studentMap.updateStudent(student);
	}

	@Resource
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMap = studentMapper;
	}
	
	public void addCourse(HashMap<String,Integer> hash) {
		studentMap.addCourse(hash);
	}

	public void removeCourse(HashMap<String, Integer> hash) {
		studentMap.removeCourse(hash);
	}
}
