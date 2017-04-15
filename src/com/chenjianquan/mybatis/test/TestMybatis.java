package com.chenjianquan.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.chenjianquan.mybatis.bean.Employee;

public class TestMybatis {

	@Test
	public void test() throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		
		Employee emp = session.selectOne("com.chenjianquan.mybatis.bean.selectEmployee", 1);
		System.out.println(emp);
		
		session.close();
	}
}
