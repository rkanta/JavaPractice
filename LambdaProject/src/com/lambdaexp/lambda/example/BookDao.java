package com.lambdaexp.lambda.example;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
	
	public List<Books> getBooks(){
		List<Books> books = new ArrayList<>();
		books.add(new Books(101,"Core Java",100));
		books.add(new Books(234,"Hibernate",200));
		books.add(new Books(343,"Spring",400));
		return books;
		
		
	}

}
