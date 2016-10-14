package com.zry.demo.dao.teacher;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zry.demo.dao.BaseDao;
import com.zry.demo.model.Teacher;

@Repository
public class TeacherDaoImpl extends BaseDao{
	//测试事务是否起作用
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Teacher selectTeacher(int id) {
		return teacherMap.selectTeacher(id);
	}

	public List<Teacher> selectAllTeacher() {
		return teacherMap.selectAllTeacher();
	}

	public List<Teacher> selectTeachers(Teacher teacher) {
		return teacherMap.selectTeachers(teacher);
	}

	public void deleteTeacher(int id) {
		teacherMap.deleteTeacher(id);
	}

	public void addTeacher(Teacher teacher) {
		teacherMap.addTeacher(teacher);
//		jdbcTemplate.execute("insert into teacher values(1234,'name','nan','23')");
	}

	public void updateTeacher(Teacher teacher) {
		teacherMap.updateTeacher(teacher);
	}

	@Resource
	public void setTeacherMapper(TeacherMapper teacherMapper) {
		this.teacherMap = teacherMapper;
	}
}
