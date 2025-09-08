package com.abcdcompany.entity;

public class PerformanceEvaluationCriteria {

	private int id;
    private String criteriaName;

    public PerformanceEvaluationCriteria(int criteriaId, String criteriaName) {
		this.id = criteriaId;
		this.criteriaName = criteriaName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCriteriaName() {
		return criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}
    
    
}
