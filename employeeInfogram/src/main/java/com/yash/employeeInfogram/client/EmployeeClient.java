package com.yash.employeeInfogram.client;

import java.text.ParseException;
import java.util.Scanner;

import com.yash.employeeInfogram.service.EmpServices;
import com.yash.employeeInfogram.serviceImpl.EmpServiceImpl;

public class EmployeeClient {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {
		
		EmpServices service=new EmpServiceImpl();
		
		System.out.println("============================= Choose Options =================================");

		while (true) {
			System.out.println(
					"\n 1. Get All Employees\n 2. Get Employee by Name\n 3. Get Employee By Salary\n 4. Get new joiners");
			int i = sc.nextInt();
			switch (i) {
			case 1:

				service.getAllEmployees().forEach(System.out::println);

				break;
			case 2:
				service.getEmployeeByName();

				break;
			case 3:
			service.getEmployeeBySalary();

				break;
			case 4:
				service.getNewJoiners();
				break;
			default:
				break;
			}
		}

	}

}
