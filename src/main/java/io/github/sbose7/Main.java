package io.github.sbose7;


import io.github.sbose7.config.CacheConfiguration;
import io.github.sbose7.config.ConfigurationBuilder;
import io.github.sbose7.manager.CacheManager;

/**
 * A demo program to show cache initialization process
 */
public class Main {
	/**
	 * Demo main 
	*/
	public static void main(String[] args) {
		CacheConfiguration config = new ConfigurationBuilder()
				.setInitialSize(100)									
				.setCacheName("db-cache-id-5432")									
				.setExpirationTime(60)
				.setLoggingEnabled(false)
				.setCompressionEnabled(false)
				.build();
		
		Cache memCache = CacheManager.createCache(config);
		
		memCache.put(500, 2);
		System.out.println(memCache.get(500));         // 2
		System.out.println(memCache.remove(500));      // true
		System.out.println(memCache.containsKey(500)); // false
	}
}
