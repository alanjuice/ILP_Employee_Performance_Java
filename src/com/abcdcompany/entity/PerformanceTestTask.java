package com.abcdcompany.entity;

public class PerformanceTestTask {

	private int id;
    private String taskName;
    private String description;
    private java.sql.Date startDate;
    private java.sql.Date endDate;

    public PerformanceTestTask(int taskId, String taskName, String taskDescription) {
		this.id = taskId;
		this.taskName = taskName;
		this.description = taskDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.sql.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}

	public java.sql.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}
}
