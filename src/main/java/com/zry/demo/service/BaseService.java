package com.zry.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zry.demo.dao.course.CourseDaoImpl;
import com.zry.demo.dao.student.StudentDaoImpl;
import com.zry.demo.dao.teacher.TeacherDaoImpl;

@Service
public class BaseService {
	@Autowired
	protected TeacherDaoImpl teacherDao;
	@Autowired
	protected StudentDaoImpl studentDao;
	@Autowired
	protected CourseDaoImpl courseDao;
}
