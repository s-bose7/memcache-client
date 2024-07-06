package com.memcache.client.manager;

import com.memcache.client.Cache;
import com.memcache.client.config.CacheConfiguration;


public class CacheManager {
	
	private Cache cache;
	private Status cacheStatus;
	private CacheConfiguration config;
	
	// ======================= SINGLETON PATTERN ============================= 
	
	private CacheManager() {}
	private CacheManager(CacheConfiguration config) {
		this.config = config;
	}
	private static CacheManager cacheManagerInstance;
	private static boolean isNull() {
		return cacheManagerInstance == null;
	}
	
	public static CacheManager getInstance() {
		if(isNull()) {
			cacheManagerInstance = new CacheManager();
		}
		return cacheManagerInstance;
	}
	
	public static CacheManager getInstance(CacheConfiguration config) {
		if(cacheManagerInstance == null) {
			cacheManagerInstance = new CacheManager(config);
		}
		return cacheManagerInstance;
	}
	
	// =========================================================================
	
	public Status getStatus() {
		return cacheStatus;
	}

	public CacheManager setStatus(Status status) {
		this.cacheStatus = status;
		return this;
	}
	// ======================== FACTORY PATTERN =================================
	public Cache getCache() {
		try {
			this.cache = CacheFactory.createCache(config);
		} catch (Exception e) {
			throw new RuntimeException("Error during cache creation: " + e);
		}
		
		return this.cache;
	}
	// ===========================================================================
	public void close() {
		// Flush resources
	}
}
