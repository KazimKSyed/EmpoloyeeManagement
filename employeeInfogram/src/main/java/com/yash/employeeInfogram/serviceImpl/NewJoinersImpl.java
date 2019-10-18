package com.yash.employeeInfogram.serviceImpl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NewJoinersImpl {

	public static boolean getEmp(LocalDate joiningdate){
		
		
		long noOfDays=ChronoUnit.DAYS.between(LocalDate.of(joiningdate.getYear(),joiningdate.getMonth(),joiningdate.getDayOfMonth()), LocalDate.now());
		if(noOfDays<30) {
			System.out.println("Number of Days in Yash::"+noOfDays);
			return true;
		}
		return false;
	}
}
