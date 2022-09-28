package com.Book.server.dao;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Book.server.pojo.BookDB;
import com.Book.server.repository.BookRespository;

@Service
public class BookDao implements IBookDao {

	@Autowired
	BookRespository bookRep;
	
	@Override
	public List<BookDB> getAllBooks() {
		return bookRep.findAll();
	}

	@Override
	public BookDB getByBookId(Integer bookId) {
		BookDB b;
		try {
			b = getAllBooks().stream().filter(i->i.getBookId()==bookId).collect(Collectors.toList()).get(0);
			if(b!=null) {
				return b;
			}
			else {
				throw new Exception();
			}
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public String postBook(BookDB newBook) {
		try {
			if( !(newBook.getAuthor().isBlank() || newBook.getAuthor().isEmpty()
					|| newBook.getBookId()==null || newBook.getBookName().isBlank()
					|| newBook.getBookName().isEmpty() || newBook.getPrice()==null) ) {
				bookRep.save(newBook);
				return "Book added.";
			}
			else {
				throw new Exception();
			}
		}
		catch(Exception e) {
			return "All fields are mandatory. Try again please.";
		}
	}

	@Override
	public String putBook(BookDB newBook, Integer bookId) {
		BookDB old;
		try {
			old = getByBookId(bookId);
			if(old!=null) {
				if( !(newBook.getAuthor().isBlank() || newBook.getAuthor().isEmpty()
						|| newBook.getBookId()==null || newBook.getBookName().isBlank()
						|| newBook.getBookName().isEmpty() || newBook.getPrice()==null) ) {
					old.setAuthor(newBook.getAuthor());
					old.setBookName(newBook.getBookName());
					old.setPrice(newBook.getPrice());
					bookRep.save(old);
					return "Book updated.";
				}
				else {
					throw new Exception();
				}
			}
			else {
				throw new Exception();
			}
		}
		catch(Exception e) {
			return "All fields are mandatory. Try again please.";
		}
	}

	@Override
	public String deleteBook(BookDB newBook) {
		BookDB old;
		try {
			old = getByBookId(newBook.getBookId());
			if(old!=null) {
				bookRep.delete(old);
				return "Book deleted.";
			}
			else {
				throw new Exception();
			}
		}
		catch(Exception e) {
			return "Book not found";
		}
	}

}
