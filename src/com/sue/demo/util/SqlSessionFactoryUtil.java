package com.sue.demo.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
	
	public static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory == null){
			InputStream is = null;
			try {
				is = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession(){
		return getSqlSessionFactory().openSession();
	}

}
