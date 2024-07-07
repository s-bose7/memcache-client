package com.memcache.client;

import com.memcache.client.manager.CacheManager;
import com.memcache.client.config.CacheConfiguration;
import com.memcache.client.config.ConfigurationBuilder;


public class Main {
		
	public static void main(String[] args) {
		CacheConfiguration config = new ConfigurationBuilder()
													.setCacheName("db-cache-id-5432")
													.setInitialSize(100)
													.setExpirationTime(60)
													.setLoggingEnabled(false)
													.setCompressionEnabled(false)
													.build();		
		CacheManager cacheManager = CacheManager.getInstance(config);
		Cache memCache = cacheManager.getCache();
		
		memCache.put(500, 2);
		System.out.println(memCache.get(500));         // 2
		System.out.println(memCache.remove(500));      // true
		System.out.println(memCache.containsKey(500)); // false
	}
}
