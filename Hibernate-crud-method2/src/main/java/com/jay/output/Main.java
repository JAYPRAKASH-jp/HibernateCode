package com.jay.output;

import java.util.List;

import com.jay.dao.BookDao;
import com.jay.dao.EmployeeDoa;
import com.jay.entity.Book;
import com.jay.entity.Employee;


public class Main {

	public static void main(String[] args) 
	 {
	
		BookDao b=new BookDao();
		EmployeeDoa e=new EmployeeDoa();
		Book book=new Book();
      

		b.saveBook("terminator", "Jame", 550);
		

		List<Book> bt=b.getBooks();
		System.out.println(bt.get(0));
		e.saveEmp("Biahr", "Jay Prakash","926420954");
		
		List<Employee> et=e.getemp();
		System.out.println(et.get(0).getEmp_name());
		
		

	
		book.setAuthor("Anicet");
		book.setTitle("mecanique");
		book.setPrice(600);
		book.setId(1);		
		System.out.println(b.updateBook(book));
		
		

		System.out.println(b.deleteBook(2));
		
		
	 }
	
	  
}
