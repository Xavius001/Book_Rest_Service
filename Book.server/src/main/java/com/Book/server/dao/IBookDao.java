package com.Book.server.dao;

import java.util.List;

import com.Book.server.pojo.BookDB;

public interface IBookDao {
	
	List<BookDB> getAllBooks(); //get list of all books
	
	BookDB getByBookId(Integer bookId); //get specific book based on ID
	
	String postBook(BookDB newBook); //add a book
	
	String putBook(BookDB newBook, Integer bookId); //update a book
	
	String deleteBook(BookDB newBook); //delete a book
	
}
