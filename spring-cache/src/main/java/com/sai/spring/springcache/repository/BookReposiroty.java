package com.sai.spring.springcache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.spring.springcache.bean.Book;

@Repository
public interface BookReposiroty extends JpaRepository<Book, Long>{

}
