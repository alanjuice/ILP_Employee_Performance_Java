package com.abcdcompany.entity;

import java.time.LocalDate;

public class PerformanceEvaluation {

	private int id;
    private LocalDate reviewDate;
    private Employee employee;
    private Employee evaluatedBy;
    private PerformanceEvaluationCriteria performanceCriteria;
    private int performanceCriteriaScore;

    // Getters and Setters
    
    public PerformanceEvaluation(int id, LocalDate localDate, Employee emp1, Employee emp2, PerformanceEvaluationCriteria criteria, int criteriaScore) {
		this.id = id;
		this.reviewDate = localDate;
		this.employee = emp1;
		this.evaluatedBy = emp2;
		this.performanceCriteria = criteria;
		this.performanceCriteriaScore = criteriaScore;
	}

    @Override
    public String toString() {
        return 
               "  Evaluation Date            : " + reviewDate + "\n" +
               "  Evaluated By               : " + evaluatedBy.getFirstName() + "\n" +
               "  Performance Criteria       : " + performanceCriteria.getCriteriaName() + "\n" +
               "  Performance Criteria Score : " + performanceCriteriaScore + "\n" ;

    }

    
}
