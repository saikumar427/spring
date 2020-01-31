package com.sai.spring.springcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class SpringCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheApplication.class, args);
	}
	
	/*
	 * @Bean public CacheManager cacheManager() { GuavaCacheManager cacheManager =
	 * new GuavaCacheManager(); cacheManager.setCacheNames(Arrays.asList("book"));
	 * return cacheManager; }
	 */

}
