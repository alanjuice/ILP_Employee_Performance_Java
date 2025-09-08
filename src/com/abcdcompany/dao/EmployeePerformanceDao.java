package com.abcdcompany.dao;

import java.sql.Connection;
import java.util.List;

import com.abcdcompany.entity.PerformanceEvaluation;
import com.abcdcompany.entity.PerformanceReview;

public interface EmployeePerformanceDao {
	
	List<PerformanceEvaluation> getEmployeePerformanceEvalution(String fname, String lname, Connection connection);
	
	List<PerformanceReview> getEmployeePerformanceReview(String fname, String lname, Connection connection);
}
