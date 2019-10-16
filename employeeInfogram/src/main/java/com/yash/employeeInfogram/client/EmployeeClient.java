package com.yash.employeeInfogram.client;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import com.yash.employeeInfogram.model.Employee;
import com.yash.employeeInfogram.service.EmployeeService;
import com.yash.employeeInfogram.service.NewJoinersInterface;
import com.yash.employeeInfogram.serviceImpl.EmployeeServiceImpl;
import com.yash.employeeInfogram.serviceImpl.NewJoinersImpl;

public class EmployeeClient {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		EmployeeService service = () -> {
			try {
				return EmployeeService.getEmployees();
			} catch (ParseException e2) {

				e2.printStackTrace();
			}
			return null;
		};
		/*
		 * LocalDate dateBefore = LocalDate.of(2017,Month.DECEMBER, 24); //29-July-2017,
		 * change this to your desired End Date LocalDate dateAfter =LocalDate.now();
		 * System.out.println(dateAfter.getDayOfMonth()); long noOfDaysBetween =
		 * ChronoUnit.DAYS.between(dateBefore, dateAfter);
		 * System.out.println(noOfDaysBetween);
		 */
		/*
		 * List<Employee> empl=service.getAllEmployees(); for (Employee employee : empl)
		 * { if(employee.getName().equalsIgnoreCase("kazim")) {
		 * ChronoUnit.DAYS.between(employee.getJoiningDate(),new Date());
		 * 
		 * } }
		 */
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
			case 4:

				List<Employee> list=service.getAllEmployees();
				for (Employee employee : list) {
					NewJoinersInterface predicate=NewJoinersImpl::getEmp;
					boolean result=predicate.test(employee.getJoiningDate());
					
					if(result==true) System.out.println(employee);
				}
				//service.getAllEmployees().stream().filter(NewJoinersImpl::getEmp)
				break;
			default:
				break;
			}
		}

	}

}
