package com.yash.employeeInfogram.serviceImpl;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.yash.employeeInfogram.model.Employee;
import com.yash.employeeInfogram.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	public List<Employee> getEmployees() {
		Employee e1=new Employee(01, "Kazim","syedkazim@gmail.com","8308771980", 55000,new Date(), "Admin", "123");
		Employee e2=new Employee(02, "Vinit","Vinit@gmail.com","111111111", 60000,new Date(), "consumer", "12345");
		Employee e3=new Employee(03, "Ram","Ram@gmail.com","8888888888", 45000,new Date(), "consumer", "12348");
		Employee e4=new Employee(04, "Aniket","Aniket@gmail.com","7894561236", 35000,new Date(), "consumer", "12386");
		Employee e5=new Employee(05, "Rahul","Rahul@gmail.com","66666666666", 85000,new Date(), "consumer", "12883");
		List<Employee> list=Arrays.asList(e1,e2,e3,e4,e5);
		return list;
	}

}
