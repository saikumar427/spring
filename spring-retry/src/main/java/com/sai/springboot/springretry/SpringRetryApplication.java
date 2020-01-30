package com.sai.springboot.springretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableRetry
@EnableCaching
@RestController
public class SpringRetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRetryApplication.class, args);
	}
	
	@GetMapping("/")
//	@Retryable(
//			value = {
//					NumberFormatException.class, 
//					NullPointerException.class
//			}, 
//			maxAttempts = 3, 
//			backoff = @Backoff(200)
//	)
	@Cacheable(value = "student", key = "id")
	public String get(@PathVariable String id) {
		System.out.println("Helloooo........");
		/*
		 * String a = null; a.length();
		 */
		return "Helloooo";
	}
	
	@Recover
	@Cacheable("student")
	public String rec(NullPointerException ex) {
		System.out.println("error....");
		return "recovered ...."+ex.getMessage();
	}
	
	/*
	 * @Bean public CacheManager cacheManager() { return new }
	 */

}
