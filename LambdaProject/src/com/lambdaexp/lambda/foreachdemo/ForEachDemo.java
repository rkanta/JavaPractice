package com.lambdaexp.lambda.foreachdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachDemo {

	public static void main(String[] args) {
		
		List<String> list1 = new ArrayList<>();
		list1.add("Rajesh");
		list1.add("Aadhya");
		list1.add("Kantha");
		list1.add("Neelima");
		list1.add("Sitara");
		
		list1.stream().filter(t->t.startsWith("R")).forEach(t->System.out.println(t));
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "r");
		map.put(2, "ra");
		map.put(3, "raj");
		map.put(4, "rajesh");
		
		map.entrySet().stream().filter(k->k.getValue().endsWith("j")).forEach(l->System.out.println(l)); 

	}

}
