package com.yash.employeeInfogram.serviceImpl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.yash.employeeInfogram.model.Employee;
import com.yash.employeeInfogram.service.EmpServices;
import com.yash.employeeInfogram.service.EmployeeSupplier;

public class EmpServiceImpl implements EmpServices {
	Scanner sc = new Scanner(System.in);
	
	//Get List using Supplier Interface
	static List<Employee> list=EmployeeSupplier.supplier.get();

	
	// Using Consumer
	@Override
	public void getAllEmployees() {
		
		Consumer<List<Employee>> consumer=(list)->list.forEach(System.out::println);
		
	     consumer.accept(list);
	}

	// stream API 
	@Override
	public Employee getEmployeeById(int id) throws ParseException {
		list.stream().filter((e) -> e.getId() == id).forEach(System.out::println);

		return null;
	}

	@Override
	public void getEmployeeByName(String name) throws ParseException {

		list.stream().filter((e) -> e.getName().equalsIgnoreCase(name))
				.forEach(System.out::println);

		
	}

	// Using Predicate Interface
	@Override
	public List<Employee> getEmployeeBySalary() throws ParseException {
		System.out.println("Please Choose Options");
		System.out.println(" 1.Salary Greater Than 50000\n 2.Salary Less Than 50000");
		int j = sc.nextInt();
		switch (j) {
		case 1:
			Predicate<Employee> predicate=(p)->p.getSalary()>50000;
			
			list.stream().filter(predicate).forEach(System.out::println);
			break;
		case 2:
			Predicate<Employee> predicate2=(p)->p.getSalary()<50000;
			
			list.stream().filter(predicate2).forEach(System.out::println);
			break;
		default:
			break;
		}
		return null;
	}

	// Using Function Interface
	@Override
	public List<String> getNewJoinersByUsingFunction() {
		Function<List<Employee>, List<String>> f = (li) -> list.stream()
				.filter((employee) -> ChronoUnit.DAYS.between(LocalDate.of(employee.getJoiningDate().getYear(),
						employee.getJoiningDate().getMonth(), employee.getJoiningDate().getDayOfMonth()),
						LocalDate.now()) < 30)
				.map((e) -> " \n" + e.getName() + " Join on ::" + e.getJoiningDate()).collect(Collectors.toList());		

		return f.apply(list);
	}

	// Using Function Interface
	public void getEmployeeByRole(String role) {

		Function<List<Employee>, List<String>> f = (list) -> list.stream()
				.filter((e) -> e.getRole().equalsIgnoreCase(role)).map((e) -> e.getName()).collect(Collectors.toList());
		System.out.println(f.apply(list));
	}

	// JAVA 8 DATE API used
	@Override
	public List<Employee> getNewJoinersd() throws ParseException {

		List<Employee> list = new ArrayList<Employee>();

		for (Employee employee :list) {

			long noOfDays = ChronoUnit.DAYS.between(LocalDate.of(employee.getJoiningDate().getYear(),
					employee.getJoiningDate().getMonth(), employee.getJoiningDate().getDayOfMonth()), LocalDate.now());
			if (noOfDays < 30) {

				System.out.println("Number of Days of " + employee.getName() + " in Yash are " + noOfDays);

				list.add(employee);

			}

		}

		return list;
	}

}
