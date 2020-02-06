package com.sai.spring.springcache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.cache.Cache;
import com.sai.spring.springcache.bean.Book;
import com.sai.spring.springcache.repository.BookReposiroty;

@Service
public class BookService {
	
	@Autowired
	Cache<Long, Object> cache;
	
	@Autowired
	private BookReposiroty bookReposiroty;
	
	//@Cacheable("book")
	public List<Book> getBooks(){
		List<Book> books = bookReposiroty.findAll();
		cache.invalidateAll();
		books.forEach(book->cache.put(book.getId(), book));
		return books;
	}
	
	//@Cacheable(value = "book", key = "#id", unless = "#result == null")
	public Book getBook(Long id) {
		Book book;
		if((book = (Book) cache.getIfPresent(id)) == null) {
			book = bookReposiroty.getOne(id);
			cache.put(id, book);
		}
		return book;
	}
	
	//@CachePut(value = "book", key = "#book.id")
	public Book save(Book book) {
		book = bookReposiroty.save(book);
		cache.put(book.getId(), book);
		return book;
	}
	
	//@CacheEvict(value = "book", allEntries = true)
	public void delete(Long id) {
		Book book = bookReposiroty.getOne(id);
		bookReposiroty.delete(book);
		//cache.invalidate(book.getId());
	}
}
