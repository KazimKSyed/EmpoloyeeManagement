package com.yash.employeeInfogram.client;

import java.text.ParseException;
import java.util.Scanner;

import com.yash.employeeInfogram.service.EmployeeSupplier;
import com.yash.employeeInfogram.serviceImpl.EmpServiceImpl;

public class EmployeeClient {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {
	

		EmpServiceImpl service = new EmpServiceImpl();
	

		while (true) {
			System.out.println("================================ Choose Options ====================================");
			System.out.println("\n 1. Get Employee by Id\n " + "2. Get All Employees\n "
					+ "3. Get Employee by Name\n" + " 4. Get Employee By Salary\n " + "5. Get new joiners\n 6. Get Employee by Role");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("Enter Employee Id::");
				int id = sc.nextInt();
				service.getEmployeeById(id);

				break;
			case 2:
				EmployeeSupplier.supplier.get();
				service.getAllEmployees().forEach(System.out::println);

				break;
			case 3:
				System.out.println("Enter Employee Name::");
				String name = sc.next();
				service.getEmployeeByName(name);

				break;
			case 4:
				service.getEmployeeBySalary();

				break;
			case 5:

				
				service.getNewJoinersByUsingFunction();
				break;
			case 6:

				System.out.println("Enter Role");
				String role=sc.next();
				service.getEmployeeByRole(role);
				break;
			default:
				break;
			}
		}

	}
	
}
