package com.ebuy.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-11-11
 * mybatis工具类
 *
 */
public class MybatisUtil {
	
	
	private static SqlSessionFactory factory;
	
	static{
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSession createSqlSession(){
		return factory.openSession();
	}
	
	public static void Close(SqlSession sqlSession){
		if(sqlSession != null){
			sqlSession.close();
		}
	}
}
