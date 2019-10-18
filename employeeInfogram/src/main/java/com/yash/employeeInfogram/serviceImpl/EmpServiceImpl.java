package com.yash.employeeInfogram.serviceImpl;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.yash.employeeInfogram.model.Employee;
import com.yash.employeeInfogram.service.EmpServices;
import com.yash.employeeInfogram.service.EmployeeService;
import com.yash.employeeInfogram.service.NewJoinersInterface;

public class EmpServiceImpl implements EmpServices {
	Scanner sc = new Scanner(System.in);

	@Override
	public List<Employee> getAllEmployees() {

		try {
			return EmployeeService.getEmployees();
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {

		return null;
	}

	@Override
	public Employee getEmployeeByName() throws ParseException {

		System.out.println("Please Enter Employee name ");
		String s = sc.next();
		EmployeeService.getEmployees().stream().filter((e) -> e.getName().equalsIgnoreCase(s))
				.forEach(System.out::println);

		return null;
	}

	@Override
	public List<Employee> getEmployeeBySalary() throws ParseException {
		System.out.println("Please Choose Options");
		System.out.println(" 1.Salary Greater Than 50000\n 2.Salary Less Than 50000");
		int j = sc.nextInt();
		switch (j) {
		case 1:
			EmployeeService.getEmployees().stream().filter((e) -> e.getSalary() > 50000).forEach(System.out::println);
			break;
		case 2:
			EmployeeService.getEmployees().stream().filter((e) -> e.getSalary() < 50000).forEach(System.out::println);
			break;
		default:
			break;
		}
		return null;
	}

	@Override
	public List<Employee> getNewJoiners() throws ParseException {
		List<Employee> list = EmployeeService.getEmployees();
		for (Employee employee : list) {
			NewJoinersInterface predicate = NewJoinersImpl::getEmp;
			boolean result = predicate.test(employee.getJoiningDate());

			if (result == true)
				System.out.println(employee);
		}
		// service.getAllEmployees().stream().filter(NewJoinersImpl::getEmp)
		return null;
	}

}
