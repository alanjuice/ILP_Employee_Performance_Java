package com.abcdcompany.utility;

import com.abcdcompany.service.EmployeePerformanceService;
import com.abcdcompany.service.EmployeePerformanceServiceImp;

public class EmployeePerformanceUtility {
	public static void main(String[] args) {
		EmployeePerformanceService service = new EmployeePerformanceServiceImp();
		service.getEmployeePerformance();
	}
}
