package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Author;
import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

@Service
@ComponentScan
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	public Book getBookById(Long id) {
		
		Book res = bookRepository.findById(id).orElse(null);
		res.getAuthor().setBooks(null);
		res.getCategory().setBooks(null);
		 return res;
	}

	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	public void deleteBook(Long id) {
		
		 bookRepository.deleteById(id);
		
	}

	public List<Book> getAllBooks() {
		
		List<Book> book = bookRepository.findAll();
		if(book!=null) {
			for(int i=0;i<book.size();i++) {
//				Book temp = book.get(i);
//				String name = temp.getAuthor().getFirstName();
//				Author author = new Author();
//				author.setFirstName(name);
//				book.get(i).setAuthor(author)
				book.get(i).getAuthor().setBooks(null);
				book.get(i).getCategory().setBooks(null);
			}
				
		}
		return book;
	}

}
