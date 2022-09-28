package com.Book.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Book.server.dao.BookDao;
import com.Book.server.pojo.BookDB;

@RestController
public class BookController {

	@Autowired
	BookDao bookDao;
	
	@GetMapping("/getAllBooks")
	public List<BookDB> getAllBooks() {
		return bookDao.getAllBooks();
	}
	
	@GetMapping("/getByBookId/{bookId}")
	public BookDB getByBookId(@PathVariable("bookId") Integer bookId) {
		return bookDao.getByBookId(bookId);
	}
	
	@PostMapping("/postBook")
	public String postBook(@RequestBody BookDB newBook) {
		return bookDao.postBook(newBook);
	}
	
	@PutMapping("/putBook/{bookId}")
	public String putBook(@RequestBody BookDB newBook, @PathVariable("bookId") Integer bookId) {
		return bookDao.putBook(newBook, bookId);
	}
	
	@DeleteMapping("/deleteBook")
	public String deleteBook(@RequestBody BookDB newBook) {
		return bookDao.deleteBook(newBook);
	}
	
}
