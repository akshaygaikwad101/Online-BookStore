package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Author;
import com.bookstore.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
    private AuthorRepository authorRepository;

	public List<Author> getAllAuthors() {
		
		List<Author> authors = authorRepository.findAll();
		
		for(int i=0;i<authors.size();i++) {
			authors.get(i).setBooks(null);
		}
		 return authors;
	}

	public Author getAuthorById(Long id) {
		
		Author author = authorRepository.findById(id).orElse(null);
		author.setBooks(null);
		return author;
	}

	public Author saveAuthor(Author author) {
		 return authorRepository.save(author);
	}

}
