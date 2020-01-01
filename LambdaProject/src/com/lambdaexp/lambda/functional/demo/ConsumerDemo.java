package com.lambdaexp.lambda.functional.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo{

	public static void main(String[] args) {
		//ConsumerDemo consumer = new ConsumerDemo();
		//consumer.accept(10);

		Consumer<Integer> consumer = t ->System.out.println("Printing : " + t);
		consumer.accept(10);

		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		list1.stream().forEach(consumer);
	}

}
