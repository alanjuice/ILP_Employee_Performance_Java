package com.abcdcompany.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Employee {

	private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private Date dob;
    private String address;
    private LocalDateTime createdAt;
    
    public Employee(int employeeId, String employeeFirstName) {
		this.id = employeeId;
		this.firstName = employeeFirstName;
	}

	public Employee(String fname, String lname, String email, String department, String address) {
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.department = department;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
public String toString() {
    return 
           "  First Name    : " + firstName + "\n" +
           "  Last Name     : " + lastName + "\n" +
           "  Email         : " + email + "\n" +
           "  Department    : " + department + "\n" +
           "  Address       : " + address + "\n";
}

	
    
}
