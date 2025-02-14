package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Author;
import com.bookstore.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
	
	@Autowired
    private AuthorService authorService;
	
	@GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }
}
