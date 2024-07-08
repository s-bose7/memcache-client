package com.memcache.client.manager;


import com.memcache.client.Cache;
import com.memcache.client.config.CacheConfiguration;


public class CacheManager {
	
	public static Status cacheStatus;


	public static Cache createCache(CacheConfiguration config) {
		return CacheFactory.createCache(config);
	}
	
}
