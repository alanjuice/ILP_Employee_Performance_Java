package com.abcdcompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.abcdcompany.entity.Employee;

public class EmployeeDaoImp implements EmployeeDao {

	@Override
	public Employee getEmployeeByName(String fname, String lname, Connection connection) {
	    Employee employee = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    String query = "SELECT * FROM employee WHERE first_name = ? AND last_name = ?";

	    try {
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, fname);
	        preparedStatement.setString(2, lname);

	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            String email = resultSet.getString("email");
	            String department = resultSet.getString("department");
	            String address = resultSet.getString("address");

	            employee = new Employee(fname, lname, email, department, address);
	        }
	    } catch (Exception e) {
	       
	    }

	    return employee;
	}


}
