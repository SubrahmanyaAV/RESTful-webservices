package com.cruds.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.cruds.restfulwebservices.bean.Book;

@Component
public class BookDAO {
	
	private static List<Book> books = new ArrayList<>();

	private static int isbnCount = 0;
	
	static {
		books.add(new Book(++isbnCount, "Java", "TextBook", "Anil"));
		books.add(new Book(++isbnCount, "Kantara", "Drama/Action", "Rishab Shetty"));
		books.add(new Book(++isbnCount, "Dr House", "Medical Drama", "Gregory"));
	}
	
	public List<Book> getAllBooks()
	{
		return books;
	}
	
	public Book create(Book b)
	{
		b.setISBN(isbnCount++);
		books.add(b);
		return b;
	}
	
	public Book findByISBN(int ISBN)
	{
		Predicate<? super Book> predicate = book -> book.getISBN().equals(ISBN);
		return books.stream().filter(predicate).findFirst().get();
	}
}
