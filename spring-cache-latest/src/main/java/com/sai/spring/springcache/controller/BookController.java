package com.sai.spring.springcache.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sai.spring.springcache.bean.Book;
import com.sai.spring.springcache.bean.BookTemp;
import com.sai.spring.springcache.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getBooks() {
		return bookService.getBooks();
	}

	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") Long id) {
		return bookService.getBook(id);
	}

	@PostMapping(path = "/books", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> insert(@Valid @RequestBody BookTemp book) throws URISyntaxException {
		Book bk = new Book();
		bk.setAuthor(book.getAuthor());
		bk.setName(book.getName());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(bookService.save(bk).getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(path = "/books/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
		bookService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
