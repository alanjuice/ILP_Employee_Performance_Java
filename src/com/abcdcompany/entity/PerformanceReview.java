package com.abcdcompany.entity;

import java.time.LocalDate;

public class PerformanceReview {

	private int id;
    private Employee employee;
    private LocalDate reviewDate;
    private PerformanceTestTask task;
    private Employee reviewer;
    private int rating;
    private String comments;


	public PerformanceReview(int id, LocalDate reviewDate, Employee emp1, Employee emp2, PerformanceTestTask task,
			String comment, int rating) {
		this.id = id;
		this.reviewDate = reviewDate;
		this.employee = emp1;
		this.reviewer = emp2;
		this.task = task;
		this.rating = rating;
		this.comments = comment;
	}


	@Override
	public String toString() {
	    return "\n" +
	           "  Review Date : " + reviewDate + "\n" +
	           "  Task Name   : " + task.getTaskName() + "\n" +
	           "  Reviewer    : " + reviewer.getFirstName() + "\n" +
	           "  Rating      : " + rating + "\n" +
	           "  Comments    : " + comments + "\n" +
	           "";
	}

	
	
	
}
