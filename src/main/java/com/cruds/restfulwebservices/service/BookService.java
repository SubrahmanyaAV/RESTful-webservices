package com.cruds.restfulwebservices.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.restfulwebservices.bean.Book;
import com.cruds.restfulwebservices.dao.BookDAO;

@Service
public class BookService {

	@Autowired
	private BookDAO dao;
	
	public List<Book> getAllBooks()
	{
		return dao.getAllBooks();
	}
	
	public Book create(Book b)
	{
		return dao.create(b);
	}
	
	public Book findByISBN(int ISBN)
	{
		return dao.findByISBN(ISBN);
	}
}
