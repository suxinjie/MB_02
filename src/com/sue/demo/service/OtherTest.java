package com.sue.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sue.demo.mappers.OtherMapper;
import com.sue.demo.model.Other;
import com.sue.demo.util.SqlSessionFactoryUtil;

public class OtherTest {

	private SqlSession sqlSession = null;
	private OtherMapper om = null;

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		om = sqlSession.getMapper(OtherMapper.class);
	}

	@Test
	public void testInsertOther(){
		Other other = new Other();
		other.setRemark("这是一篇文章，很长很长。");
		
		byte[] pic = null;
		try{
			InputStream is = Resources.getResourceAsStream("longze.jpg");
			pic = new byte[is.available()];
			is.read(pic);
			is.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		other.setPic(pic);
		int i = om.insertOther(other);
		sqlSession.commit();
		if(i > 0) System.out.println("插入成功");
		
	}
	
	@Test
	public void testGetOtherById(){
		Other other = om.getOtherById(2);
		
		byte[] pic = other.getPic();
		try{
			
			File file = new File("temp.jpg");
			OutputStream os = new FileOutputStream(file);
			os.write(pic);
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

}
