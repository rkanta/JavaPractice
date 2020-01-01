package com.lambdaexp.lambda.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookService {
	
	public List<Books> getBookList(){
		
		List<Books> books = new BookDao().getBooks();
		Collections.sort(books, (o1,o2)-> o2.getName().compareTo(o1.getName()));
		return books;
	}



public static void main(String[] args) {
	
	System.out.println(new BookService().getBookList());
}
/*
class MyComparator implements Comparator<Books>{

	@Override
	public int compare(Books o1, Books o2) {
		
		return o1.getName().compareTo(o2.getName());
	}
	
}
*/
}
