package com.cruds.restfulwebservices.bean;

public class Book {

	private Integer ISBN;
	private String title;
	private String category;
	private String author;

	public Book(Integer iSBN, String title, String category, String author) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.category = category;
		this.author = author;
	}

	public Integer getISBN() {
		return ISBN;
	}

	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", category=" + category + ", author=" + author + "]";
	}

}
