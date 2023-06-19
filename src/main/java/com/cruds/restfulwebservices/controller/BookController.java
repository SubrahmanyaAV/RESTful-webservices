package com.cruds.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cruds.restfulwebservices.bean.Book;
import com.cruds.restfulwebservices.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/books")
	public List<Book> getAll()
	{
		return service.getAllBooks();
	}
	
	@PostMapping("/books")
	public Book CreateBook(@RequestBody Book b)
	{
		return service.create(b);
	}
	
	@GetMapping("/books/{ISBN}")
	public Book findByISBN(@PathVariable int ISBN)
	{
		return service.findByISBN(ISBN);
	}

}
