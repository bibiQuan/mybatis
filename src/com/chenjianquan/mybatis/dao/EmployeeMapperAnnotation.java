package com.chenjianquan.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.chenjianquan.mybatis.bean.Employee;

public interface EmployeeMapperAnnotation {

	@Select("select * from employees where id = #{id}")
	public Employee getEmployeeById(Integer id);
}
