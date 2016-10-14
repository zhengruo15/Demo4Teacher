package com.zry.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zry.demo.dao.teacher.TeacherDaoImpl;
import com.zry.demo.dao.teacher.TeacherMapper;
import com.zry.demo.model.Teacher;

@Service
public class TeacherService extends BaseService {

	public Teacher selectTeacher(int id) {
		return teacherDao.selectTeacher(id);
	}

	public List<Teacher> selectAllTeacher() {
		return teacherDao.selectAllTeacher();
	}

	public List<Teacher> selectTeacher(Teacher teacher) {
		return teacherDao.selectTeachers(teacher);
	}

	public void deleteTeacher(int id) {
		teacherDao.deleteTeacher(id);
	}

	public String addTeacher(Teacher teacher) {
		String errorMessage = "";
		if (repeatJudge(teacher) == false) {
			teacherDao.addTeacher(teacher);
			int x = 1;
			if(x == 1)
				throw new RuntimeException("xxx");
		} else {
			errorMessage = "编号重复了 ";
		}
		return errorMessage;
	}

	private void testTraction() {

		}

	private boolean repeatJudge(Teacher teacher) {
		if (teacherDao.selectTeacher(teacher.getTeacherId()) == null) {
			return false;
		} else {
			return true;
		}
	}

	public void update(Teacher teacher) {
		teacherDao.updateTeacher(teacher);
	}

}
