package com.lambdaexp.lambda.functional.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo implements Supplier<String>{

	public static void main(String[] args) {
		//traditional implementation of interface
		Supplier<String> supDemo = new SupplierDemo();
		System.out.println(supDemo.get());
		
		//Lambda implementation
		Supplier<String> suplambdaDemo = () ->  "Found Nothing in List!!";
		//System.out.println(suplambdaDemo.get());
		
		List<String> supList = Arrays.asList();
		System.out.println(supList.stream().findAny().orElseGet(suplambdaDemo));

	}

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return "Hello Lambda Supplier!!";
	}

}
