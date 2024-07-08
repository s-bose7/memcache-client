package com.memcache.client.manager;


import com.memcache.client.Cache;
import com.memcache.client.config.CacheConfiguration;
import com.memcache.client.exception.CacheInitializationException;


public class CacheManager {
	
	public static Status cacheStatus;


	public static Cache createCache(CacheConfiguration config) {
		Cache cache = null;
		
		try {
			 cache = CacheFactory.createCache(config);
		} catch (CacheInitializationException e) {
			e.printStackTrace();
		}

		return cache;
	}
	
	public static void removeCache() {
		
	}
	
}
