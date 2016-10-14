package com.zry.demo.dao.student;

import java.util.HashMap;
import java.util.List;

import com.zry.demo.model.Student;

public interface StudentMapper {
	public Student selectStudent(int id);
	public List<Student> selectAllStudent();
	public void deleteStudent(int id);
	public void addStudent(Student teacher);
	public List<Student> selectStudents(Student teacher);
	public void updateStudent(Student teacher);
	public void addCourse(HashMap<String,Integer> hash);
	public void removeCourse(HashMap<String, Integer> hash);
}
