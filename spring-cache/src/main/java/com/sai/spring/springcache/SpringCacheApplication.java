package com.sai.spring.springcache;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;


@SpringBootApplication
@EnableCaching
public class SpringCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheApplication.class, args);
	}
	
	

	
	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
	    GuavaCache cache = guavaCache();
	    cacheManager.setCaches(Arrays.asList(cache));
		return cacheManager;
	}
	
	@Bean
	public Cache<Long, Object> cache(){
		return CacheBuilder
				.newBuilder()
				.maximumSize(1000)
				.recordStats()
				.build();
	}
	
	
	@Bean
	@Scope("singleton")
	public GuavaCache guavaCache() {
		return new GuavaCache("book", CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .recordStats()
                .build());
	}

}
