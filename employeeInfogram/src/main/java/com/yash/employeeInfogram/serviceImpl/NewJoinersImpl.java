package com.yash.employeeInfogram.serviceImpl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NewJoinersImpl {

	public static boolean getEmp(LocalDate joiningdate){
		
		
		long noOfDays=ChronoUnit.DAYS.between(LocalDate.of(joiningdate.getYear(),joiningdate.getMonth(),joiningdate.getDayOfMonth()), LocalDate.now());
		if(noOfDays<30) {
			return true;
		}
		return false;
	}
}
