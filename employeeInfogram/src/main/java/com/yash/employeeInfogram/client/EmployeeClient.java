package com.yash.employeeInfogram.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.yash.employeeInfogram.service.EmployeeService;

public class EmployeeClient {
	static Scanner sc = new Scanner(System.in);
	static EmployeeService service = () -> {
		try {
			return EmployeeService.getEmployees();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};

	public static void main(String[] args) {
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		try {
			Date date = simpleDateFormat.parse("2018-09-09");
			System.out.println(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
				System.out.println("Please Enter Employee name ");
				String s = sc.next();
				service.getAllEmployees().stream().filter((e) -> e.getName().equalsIgnoreCase(s))
						.forEach(System.out::println);

				break;
			case 3:
				System.out.println("Please Choose Options");
				System.out.println(" 1.Salary Greater Than 50000\n 2.Salary Less Than 50000");
				int j = sc.nextInt();
				switch (j) {
				case 1:
					service.getAllEmployees().stream().filter((e) -> e.getSalary() > 50000)
							.forEach(System.out::println);
					break;
				case 2:
					service.getAllEmployees().stream().filter((e) -> e.getSalary() < 50000)
							.forEach(System.out::println);
					break;
				default:
					break;
				}

				break;
			default:
				break;
			}
		}

	}

}
