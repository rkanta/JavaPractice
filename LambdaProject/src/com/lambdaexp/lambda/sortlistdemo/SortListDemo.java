package com.lambdaexp.lambda.sortlistdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(2);
		list.add(3);
		list.add(7);
		list.add(18);
		
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println("*********************************************");
		
		list.stream().sorted().forEach(t->System.out.println(t));//ascending order with streams
		
		System.out.println("*********************************************");
		 
		list.stream().sorted(Comparator.reverseOrder()).forEach(r->System.out.println(r));//Descending order with streams
		


	}

}
