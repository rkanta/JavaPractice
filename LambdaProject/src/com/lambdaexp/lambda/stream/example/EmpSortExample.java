package com.lambdaexp.lambda.stream.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmpSortExample {

	public static void main(String[] args) {
		
		List<Employee> empList = Database.getEmployees();
		Collections.sort(empList, new MySortComparator());
		System.out.println(empList);
		System.out.println("/////////////////////////////////////////////");
		Collections.sort(empList, (a,b)->(int) (a.getSalary()-b.getSalary()));
		System.out.println(empList);
		System.out.println("/////////////////////////////////////////////");
		empList.stream().sorted((l,k)-> (int)(l.getSalary()-k.getSalary())).forEach(t->System.out.println(t));
		System.out.println("******Next sorting by Method reference**************");
		empList.stream().sorted(Comparator.comparing(emp->emp.getSalary())).forEach(t->System.out.println(t));
		
		System.out.println("******Next sorting by Alternate Method reference**************");
		
		empList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(t->System.out.println(t));
	}

}

class MySortComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
	
		return (int) (o2.getSalary()-o1.getSalary());
	}
	
}
