package com.lambdaexp.lambda.sortlistdemo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.lambdaexp.lambda.stream.example.Employee;

import java.util.TreeMap;

public class SortMapDemo {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		//Map<String, Integer> map = new TreeMap<String, Integer>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);

		// converting map to list
		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		//Sorting map using traditional way
		for (Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() +"   "+ entry.getValue());
		}
		System.out.println("*******************************");
		entries.stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("*******************************");
		entries.stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		System.out.println("*******************************");

		//map having key value with objects and sorting tradition way
		Map<Employee,Integer> empMap = new TreeMap<>(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return (int) (o1.getSalary()-o2.getSalary());
			}
		});
		empMap.put(new Employee(176, "Roshan", "IT", 120000),1);
		empMap.put(new Employee(178, "Rakesh", "HR", 125000),2);
		empMap.put(new Employee(125, "Kevin", "Admin", 65000),3);
		empMap.put(new Employee(189, "Pat", "Dir", 135000),4);
		empMap.put(new Employee(177, "Sam", "IT", 110000),5);

		System.out.println(empMap);

		System.out.println("***************sorting maps with objects using streams****************");

		//sorting maps with objects using streams

		empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).forEach(System.out::println);
 
		//sorting maps in reverse order with objects using streams
		
		System.out.println("*******************************sorting maps in reverse order with objects using streams*******************************");
		empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed())).forEach(System.out::println);


	}

}
