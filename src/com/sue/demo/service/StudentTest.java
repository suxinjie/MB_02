package com.sue.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sue.demo.mappers.StudentMapper;
import com.sue.demo.model.Student;
import com.sue.demo.util.SqlSessionFactoryUtil;

public class StudentTest {

	private SqlSession sqlSession = null;
	private StudentMapper sm = null;

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		sm = sqlSession.getMapper(StudentMapper.class);
	}

	@Test
	public void testSearchStudents(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "%zhang%");
		map.put("age", 10);
		List<Student> students = sm.searchStudents(map);
		for(Student s : students){
			System.out.println(s);
		}
	}
	
	@Test
	public void testSearchStudents1(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchBy", "name");
		map.put("name", "%zhang%");
		map.put("age", 11);
		List<Student> students = sm.searchStudents1(map);
		for(Student s : students){
			System.out.println(s);
		}
	}
	
	@Test
	public void testSearchStudents2(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "%zhang%");
		map.put("age", 10);
		List<Student> students = sm.searchStudents2(map);
		for(Student s : students){
			System.out.println(s);
		}
	}
	
	@Test
	public void testSearchStudents3(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "%zhang%");
		map.put("age", 10);
		List<Student> students = sm.searchStudents3(map);
		for(Student s : students){
			System.out.println(s);
		}
	}
	
	@Test
	public void testSearchStudents4(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> gradeIds = new ArrayList<Integer>();
		gradeIds.add(1);
		gradeIds.add(2);
		map.put("gradeIds", gradeIds);
		List<Student> students = sm.searchStudents4(map);
		for(Student s : students){
			System.out.println(s);
		}
	}
	
	@Test
	public void testUpdateStudents(){
		Student student = new Student();
		student.setId(1);
		student.setName("zhangsan-update");
		int i = sm.updateStudent(student);
		sqlSession.commit();
		if(i > 0) System.out.println("更新成功");
	}
	
	@Test
	public void testFindStudents(){
		int offset = 0;
		int limit = 2;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Student> students = sm.findStudents(rowBounds);
		for(Student s : students){
			System.out.println(s);
		}
	}
	
	@Test
	public void testFindStudents1(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 0);
		map.put("size", 2);
		List<Student> students = sm.findStudents1(map);
		for(Student s : students){
			System.out.println(s);
		}
	}
	
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

}
