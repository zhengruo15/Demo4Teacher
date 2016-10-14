package com.zry.demo.dao.teacher;

import java.util.List;

import com.zry.demo.model.Teacher;

public interface TeacherMapper {
	public Teacher selectTeacher(int id);
	public List<Teacher> selectAllTeacher();
	public void deleteTeacher(int id);
	public void addTeacher(Teacher teacher);
	public List<Teacher> selectTeachers(Teacher teacher);
	public void updateTeacher(Teacher teacher);
}
