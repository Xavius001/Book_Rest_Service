package com.Book.server.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookDB {
	
	@Id
	Integer bookId;

	String bookName;

	String author;

	Integer price;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public BookDB(Integer bookId, String bookName, String author, Integer price) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	public BookDB() {}
	

}
