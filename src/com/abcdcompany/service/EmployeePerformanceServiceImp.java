package com.abcdcompany.service;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.abcdcompany.dao.EmployeeDao;
import com.abcdcompany.dao.EmployeeDaoImp;
import com.abcdcompany.dao.EmployeePerformanceDao;
import com.abcdcompany.dao.EmployeePerformanceDaoImp;
import com.abcdcompany.dbconnection.DBConnectionPool;
import com.abcdcompany.entity.Employee;
import com.abcdcompany.entity.PerformanceEvaluation;
import com.abcdcompany.entity.PerformanceReview;

public class EmployeePerformanceServiceImp implements EmployeePerformanceService {

	@Override
	public void getEmployeePerformance() {
		Connection connection;
		
		Scanner scanner = new Scanner(System.in);
		EmployeePerformanceDao performanceDao = new EmployeePerformanceDaoImp();
		EmployeeDao employeeDao = new EmployeeDaoImp();
		DataSource dataSource = DBConnectionPool.getDataSource();
		
		try {
			connection = dataSource.getConnection();
			System.out.println("Enter the first name: ");
			String fname = scanner.nextLine();
			System.out.println("Enter the last name: ");
			String lname = scanner.nextLine();
			
			Employee emp = employeeDao.getEmployeeByName(fname, lname, connection);
			if (emp==null)
			{
				return;
			}
			
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("Employee Details\n\n");
			System.out.println(employeeDao.getEmployeeByName(fname, lname, connection));
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("\n\t\tPerformance Evaluation\n\n");
			System.out.println("----------------------------------------------------------------------------------------");
			
			List<PerformanceEvaluation> evaluations = performanceDao.getEmployeePerformanceEvalution(fname,lname, connection);
			
			for (PerformanceEvaluation evaluation: evaluations)
			{
				System.out.println(evaluation);
			}
			
			System.out.println("----------------------------------------------------------------------------------------");
			
			System.out.println("\n\t\tPerformance Review\n\n");
			System.out.println("----------------------------------------------------------------------------------------");
			
			List<PerformanceReview> reviews = performanceDao.getEmployeePerformanceReview(fname,lname, connection);
			for (PerformanceReview review: reviews)
			{
				System.out.println(review);
			}
			
			System.out.println("----------------------------------------------------------------------------------------");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
