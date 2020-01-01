package com.lambdaexp.lambda.functional.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		
		Predicate<Integer> lambdapredicate = t-> t%2 ==0 ;
		
		//System.out.println(lambdapredicate.test(5));
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		list1.stream().filter(lambdapredicate).forEach(t->System.out.println(t));
		

	}

}
