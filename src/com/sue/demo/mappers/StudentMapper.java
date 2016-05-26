package com.sue.demo.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.sue.demo.model.Student;


public interface StudentMapper {

	public List<Student> searchStudents(Map<String, Object> map);
	
	public List<Student> searchStudents1(Map<String, Object> map); 
	
	public List<Student> searchStudents2(Map<String, Object> map); 
	
	public List<Student> searchStudents3(Map<String, Object> map); 
	
	public List<Student> searchStudents4(Map<String, Object> map); 
	
	public int updateStudent(Student student);
	
	public List<Student> findStudents(RowBounds rowBounds);
	
	public List<Student> findStudents1(Map<String, Object> map);
	
}