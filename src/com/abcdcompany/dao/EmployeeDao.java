package com.abcdcompany.dao;

import java.sql.Connection;

import com.abcdcompany.entity.Employee;

public interface EmployeeDao {
	Employee getEmployeeByName(String fname,String lname, Connection connection);
}
