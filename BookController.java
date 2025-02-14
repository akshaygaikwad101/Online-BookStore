package com.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/search")
	public ResponseEntity<List<Book>> searchBooks(@RequestParam(name="code",required = false) String code,
			@RequestParam(name="desc",required = false) String desc){
		final List<Book> res = new ArrayList<Book>();
		return ResponseEntity.ok(res);
	}
	
	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	 
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping("/add")
	public Book addBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
		book.setId(id);
		return bookService.saveBook(book);
	}
	
	@DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
