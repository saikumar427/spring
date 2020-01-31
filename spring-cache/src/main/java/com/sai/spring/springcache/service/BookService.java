package com.sai.spring.springcache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sai.spring.springcache.bean.Book;
import com.sai.spring.springcache.repository.BookReposiroty;

@Service
public class BookService {
	
	@Autowired
	private BookReposiroty bookReposiroty;
	
	public List<Book> getBooks(){
		return bookReposiroty.findAll();
	}
	
	@Cacheable(value = "book", key = "#id", unless = "#result == null")
	public Book getBook(Long id) {
		return bookReposiroty.getOne(id);
	}
	
	@CachePut(value = "book", key = "#book.id")
	public Book save(Book book) {
		return bookReposiroty.save(book);
	}
	
	@CacheEvict(value = "book", allEntries = true)
	public void delete(Long id) {
		Book book = bookReposiroty.getOne(id);
		if(book != null)
			bookReposiroty.delete(book);
	}
}
