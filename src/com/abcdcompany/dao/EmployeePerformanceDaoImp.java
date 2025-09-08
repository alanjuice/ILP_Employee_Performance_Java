package com.abcdcompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.abcdcompany.entity.Employee;
import com.abcdcompany.entity.PerformanceEvaluation;
import com.abcdcompany.entity.PerformanceEvaluationCriteria;
import com.abcdcompany.entity.PerformanceReview;
import com.abcdcompany.entity.PerformanceTestTask;

public class EmployeePerformanceDaoImp implements EmployeePerformanceDao {
	
	@Override
	public List<PerformanceEvaluation> getEmployeePerformanceEvalution(String fname,String lname, Connection connection) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		List<PerformanceEvaluation> evaluationList = new ArrayList<PerformanceEvaluation>();
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT " +
			                "pe.id AS evaluation_id, " +
			                "pe.review_date, " +
			                "e1.id AS employee_id, " +
			                "e1.first_name AS employee_first_name, " +
			                "e2.id AS evaluator_id, " +
			                "e2.first_name AS evaluator_first_name, " +
			                "pec.id AS criteria_id, " +
			                "pec.criteria_name, " +
			                "pe.performance_criteria_score " +
			                "FROM performance_evaluation pe " +
			                "JOIN employee e1 ON pe.employee_id = e1.id " +
			                "JOIN employee e2 ON pe.evaluated_by = e2.id " +
			                "JOIN performance_evaluation_criteria pec ON pe.performance_criteria_id = pec.id " 
							+ "WHERE e1.first_name = '" + fname + "' AND e1.last_name = '" + lname + "';");
				
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				int id = resultSet.getInt(1);
				String reviewDate = resultSet.getString(2);
				int employeeId = resultSet.getInt(3);
				String employeeFirstName = resultSet.getString(4);
				
				Employee emp1 = new Employee(employeeId,employeeFirstName);
				
				int evaluatorId = resultSet.getInt(5);
				String evaluatorFirstName = resultSet.getString(6);
				
				Employee emp2 = new Employee(evaluatorId, evaluatorFirstName);
				
				int criteriaId = resultSet.getInt(7);
				String criteriaName = resultSet.getString(8);
				
				PerformanceEvaluationCriteria criteria = new PerformanceEvaluationCriteria(criteriaId,criteriaName);
				
				int criteriaScore = resultSet.getInt(9);
				
				PerformanceEvaluation performanceEvaluation = new PerformanceEvaluation(id,LocalDate.parse(reviewDate),emp1,emp2,criteria,criteriaScore);
				evaluationList.add(performanceEvaluation);
			}
		
			return evaluationList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<PerformanceReview> getEmployeePerformanceReview(String fname,String lname, Connection connection) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		List<PerformanceReview> reviews = new ArrayList<PerformanceReview>();
		
		try {
			preparedStatement = connection.prepareStatement(

					"SELECT " +
                "pr.id AS review_id, " +
                "pr.review_date, " +
                "e.id AS employee_id, " +
                "e.first_name AS employee_first_name, " +
                "r.id AS reviewer_id, " +
                "r.first_name AS reviewer_first_name, " +
                "t.id AS task_id, " +
                "t.task_name, " +
                "t.description, " +
                "pr.rating, " +
                "pr.comments " +
                "FROM performance_review pr " +
                "JOIN employee e ON pr.employee_id = e.id " +
                "JOIN employee r ON pr.reviewer_id = r.id " +
                "JOIN performance_test_task t ON pr.task_id = t.id " 
					+ "WHERE e.first_name = '" + fname + "' AND e.last_name = '" + lname + "';");
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				int id = resultSet.getInt(1);
				String reviewDate = resultSet.getString(2);
				
				int employeeId = resultSet.getInt(3);
				String employeeFirstName = resultSet.getString(4);
				
				Employee emp1 = new Employee(employeeId,employeeFirstName);
				
				int reviewerId = resultSet.getInt(5);
				String reviewerName = resultSet.getString(6);
				
				Employee emp2 = new Employee(reviewerId,reviewerName);
				
				int taskId = resultSet.getInt(7);
				String taskName = resultSet.getString(8);
				String taskDescription = resultSet.getString(9);
				PerformanceTestTask task = new PerformanceTestTask(taskId,taskName,taskDescription);
				
				int rating = resultSet.getInt(10);
				String comment = resultSet.getString(11);
				
				
				PerformanceReview performanceReview = new PerformanceReview(id,LocalDate.parse(reviewDate),emp1,emp2,task,comment,rating);
				reviews.add(performanceReview);
			}
		} catch (Exception e) {

		}		
		return reviews;
	}

}
