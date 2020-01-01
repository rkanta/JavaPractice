package com.lambdaexp.lambda.stream.example;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {
	
	public List<Employee> getTaxableEmployee(String input){
		
		return input.equalsIgnoreCase("tax") ? Database.getEmployees().stream()
				.filter(t->t.getSalary() > 120000)
				.collect(Collectors.toList()) : 
					
					Database.getEmployees().stream()
					.filter(t->t.getSalary() <= 120000)
					.collect(Collectors.toList())	;
		
	}

	public static void main(String[] args) {
		TaxService ts = new TaxService();
	    System.out.println(ts.getTaxableEmployee("non-tax"));

	}

}
