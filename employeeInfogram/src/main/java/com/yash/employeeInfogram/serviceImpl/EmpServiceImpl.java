package com.yash.employeeInfogram.serviceImpl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.yash.employeeInfogram.model.Employee;
import com.yash.employeeInfogram.service.EmpServices;
import com.yash.employeeInfogram.service.EmployeeSupplier;

public class EmpServiceImpl implements EmpServices {
	Scanner sc = new Scanner(System.in);

	@Override
	public List<Employee> getAllEmployees() {
		return EmployeeSupplier.supplier.get();
	}

	@Override
	public Employee getEmployeeById(int id) throws ParseException {
		EmployeeSupplier.supplier.get().stream().filter((e) -> e.getId() == id).forEach(System.out::println);

		return null;
	}

	@Override
	public Employee getEmployeeByName(String name) throws ParseException {

		EmployeeSupplier.supplier.get().stream().filter((e) -> e.getName().equalsIgnoreCase(name))
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
			EmployeeSupplier.supplier.get().stream().filter((e) -> e.getSalary() > 50000).forEach(System.out::println);
			break;
		case 2:
			EmployeeSupplier.supplier.get().stream().filter((e) -> e.getSalary() < 50000).forEach(System.out::println);
			break;
		default:
			break;
		}
		return null;
	}

	@Override
	public List<String> getNewJoinersByUsingFunction() {
		Function<List<Employee>, List<String>> f = (li) -> EmployeeSupplier.supplier.get().stream()
				.filter((employee) -> ChronoUnit.DAYS.between(LocalDate.of(employee.getJoiningDate().getYear(),
						employee.getJoiningDate().getMonth(), employee.getJoiningDate().getDayOfMonth()),
						LocalDate.now()) < 30)
				.map((e) -> " \n" + e.getName() + " Join on ::" + e.getJoiningDate()).collect(Collectors.toList());
		System.out.println(f.apply(EmployeeSupplier.supplier.get()));

		return f.apply(EmployeeSupplier.supplier.get());
	}

	public void getEmployeeByRole(String role) {

		Function<List<Employee>, List<String>> f = (list) -> EmployeeSupplier.supplier.get().stream()
				.filter((e) -> e.getRole().equalsIgnoreCase(role)).map((e) -> e.getName()).collect(Collectors.toList());
		System.out.println(f.apply(EmployeeSupplier.supplier.get()));
	}

	@Override
	public List<Employee> getNewJoinersd() throws ParseException {

		List<Employee> list = new ArrayList<Employee>();

		for (Employee employee : EmployeeSupplier.supplier.get()) {

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
