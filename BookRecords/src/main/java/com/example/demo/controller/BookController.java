package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;
import com.example.demo.repositery.BookRepositery;
import com.example.demo.repositery.UserRepo;
import com.honeybridge.model.User;
import com.mongodb.client.result.UpdateResult;

@RestController
public class BookController {
	@Autowired
	BookRepositery bookRepositery;
@Autowired
MongoOperations mongoopration;
	@Autowired
	UserRepo userRepositery;
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
	@RequestMapping("/books/title1/IsStartingWith/{pat}")
	public List<Book> titaleIsStarting(@PathVariable("pat")String pat){
		return bookRepositery.findByTitleIsStartingWith(pat);
	}
	@RequestMapping("/books/title2/StartingWith/{pat}")
	public List<Book> titaleStarting(@PathVariable("pat")String pat){
		return bookRepositery.findByTitleStartingWith(pat);
	}
	@RequestMapping("/books/ByEmail1/containing/{pat}")
	public List<User> byEmail(@PathVariable("pat")String pat){
		return userRepositery.findByEmailContaining(pat);
		
	}
	@RequestMapping("/hi")
	public List<Book> byEmail2(){
		Sort sort=new Sort(Direction.DESC,"_id" );
		return bookRepositery.findAll(sort);
		//return userRepositery.findByEmailContains(pat);
		
	}
	@RequestMapping("/satus/unpublish-all")
	public void unpublishAll(){
		UpdateResult a=mongoopration.updateMulti(new Query(Criteria.where("status").is("UNPUBLISH")),Update.update("status", "PUBLISH"), "books");
	System.out.println(a);
	}

}
