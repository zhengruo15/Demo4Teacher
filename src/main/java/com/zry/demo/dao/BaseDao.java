package com.zry.demo.dao;

import org.springframework.stereotype.Repository;

import com.zry.demo.dao.course.CourseMapper;
import com.zry.demo.dao.student.StudentMapper;
import com.zry.demo.dao.teacher.TeacherMapper;

@Repository
public class BaseDao {
	protected StudentMapper studentMap;
	protected TeacherMapper teacherMap;
	protected CourseMapper courseMap;
}
