package com.zry.demo.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.zry.demo.model.Teacher;
import com.zry.demo.service.TeacherService;

public class TeacherControllerTest {

	@Mock
	private TeacherService teacherService;
	@InjectMocks
	private TeacherController teacherController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		this.mockMvc = MockMvcBuilders.standaloneSetup(teacherController)
				.build();
	}

	@Test
	public void testList() throws Exception {
		Teacher teacher1 = new Teacher(1002, "张三", "男", 24);
		Teacher teacher2 = new Teacher(1003, "李四", "男", 123);
		List<Teacher> value = new ArrayList<Teacher>();
		value.add(teacher1);
		value.add(teacher2);
		when(teacherService.selectAllTeacher()).thenReturn(value);

		this.mockMvc.perform(get("/teacher/listTeacher"))
				.andExpect(status().is(200))
				.andExpect(view().name("teacher/teacherMain"));

		verify(teacherService).selectAllTeacher();
	}

	@Test
	public void testDelete() throws Exception {
		int id = 1002;
		Mockito.doAnswer(new Answer() {

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();  
            return null; 
			}
		}).when(teacherService).deleteTeacher(id);
		
		this.mockMvc.perform(get("/teacher/removeTeacher?teacherId="+id))
			.andExpect(status().isOk());
			
		verify(teacherService).deleteTeacher(id);
	}
	
	@Test
	public void testDetail() throws Exception {
		
	}
}
