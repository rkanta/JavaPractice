package com.lambdaexp.lambda.stream.example;

import java.util.ArrayList;
import java.util.List;

public class Database {
	
	public static List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(176, "Roshan", "IT", 120000));
		list.add(new Employee(178, "Rakesh", "HR", 125000));
		list.add(new Employee(125, "Kevin", "Admin", 65000));
		list.add(new Employee(189, "Pat", "Dir", 135000));
		list.add(new Employee(177, "Sam", "IT", 110000));
		return list;
		
	}

}
