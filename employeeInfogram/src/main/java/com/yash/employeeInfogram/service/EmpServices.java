package com.yash.employeeInfogram.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.yash.employeeInfogram.model.Employee;

public interface EmpServices {
	public void getAllEmployees();

	public Employee getEmployeeById(int id) throws ParseException;

	public void getEmployeeByName(String name) throws ParseException;

	public List<Employee> getEmployeeBySalary() throws ParseException;

	public List<String> getNewJoinersByUsingFunction() throws ParseException;

	public List<Employee> getNewJoinersd() throws ParseException;

}
