package com.yash.employeeInfogram.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.yash.employeeInfogram.model.Employee;

public interface EmployeeService {
	public static List<Employee> getEmployees() throws ParseException {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Employee e1=new Employee(01, "Kazim","syedkazim@gmail.com","8308771980", 55000,simpleDateFormat.parse("2018-05-29"), "Admin", "123");
		Employee e2=new Employee(02, "Vinit","Vinit@gmail.com","111111111", 60000,simpleDateFormat.parse("2019-08-10"), "consumer", "12345");
		Employee e3=new Employee(03, "Ram","Ram@gmail.com","8888888888", 45000,simpleDateFormat.parse("2019-08-5"), "consumer", "12348");
		Employee e4=new Employee(04, "Aniket","Aniket@gmail.com","7894561236", 35000,simpleDateFormat.parse("2019-06-29"), "consumer", "12386");
		Employee e5=new Employee(05, "Rahul","Rahul@gmail.com","66666666666", 85000,simpleDateFormat.parse("2019-05-29"), "consumer", "12883");
		List<Employee> list=Arrays.asList(e1,e2,e3,e4,e5);
		return list;
	}
	
	public List<Employee> getAllEmployees();

}
