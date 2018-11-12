package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;
import com.example.demo.repositery.BookRepositery;

@RestController
public class BookController {
	@Autowired
	BookRepositery bookRepositery;

	@RequestMapping("/books")
	public ResponseEntity<?> getAll() {
		List<Book> books = bookRepositery.findAll();
		if (!books.isEmpty())
			return new ResponseEntity<List<Book>>(books, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping("/books/authors/{author}")
	public List<Book> getByAuthor(@PathVariable("author") String author) {
		return bookRepositery.findByAuthorsContains(author);
	}

	@RequestMapping("/books/categary/{categary}")
	public List<Book> getBycategary(@PathVariable("categary") String categary) {
		return bookRepositery.findByCategoriesContains(categary);
	}

	@RequestMapping("/books/pageCount/{pageCount}")
	public List<Book> findByCount(@PathVariable("pageCount") int pageCount) {
		return bookRepositery.findByPageCountIsIn(pageCount);
	}

	@RequestMapping("/books/scarch/{msg}")
	public List<Book> searchInShortDiscription(@PathVariable("msg") String msg) {
		return bookRepositery.findByShortDescriptionContaining(msg);
	}

	@RequestMapping("/books/status/{msg}")
	public List<Book> findByStatus(@PathVariable("msg") String msg) {
		return bookRepositery.findByStatus(msg);
	}

}
