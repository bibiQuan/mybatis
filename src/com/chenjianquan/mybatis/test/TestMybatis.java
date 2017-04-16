package com.chenjianquan.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.chenjianquan.mybatis.bean.Employee;
import com.chenjianquan.mybatis.dao.EmployeeMapper;

public class TestMybatis {

	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    return sqlSessionFactory;
	}
	
	@Test
	public void test() throws Exception{
				
		SqlSession session = getSqlSessionFactory().openSession();
		
		Employee emp = session.selectOne("com.chenjianquan.mybatis.bean.selectEmployee", 1);
		System.out.println(emp);
		
		session.close();
	}
	
	/**
	 * 接口式编程
	 * @throws IOException 
	 */
	@Test
	public void test2() throws IOException{
		
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Employee employee = employeeMapper.getEmployeeById(1);
			System.out.println(employee);
		}finally{
			session.close();
		}
	}
}
