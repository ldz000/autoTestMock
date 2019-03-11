package org.wsk.autoTestMock.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	static SqlSessionFactory sqlSessionFactory = null;
	static{
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession(){
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
}
