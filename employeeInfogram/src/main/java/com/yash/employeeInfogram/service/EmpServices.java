package com.yash.employeeInfogram.service;

import java.text.ParseException;
import java.util.List;

import com.yash.employeeInfogram.model.Employee;

public interface EmpServices {
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByName() throws ParseException;
	public List<Employee> getEmployeeBySalary() throws ParseException;
	public List<Employee> getNewJoiners() throws ParseException;
	

}
