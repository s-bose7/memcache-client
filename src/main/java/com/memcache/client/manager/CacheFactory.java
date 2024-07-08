package com.memcache.client.manager;


import com.memcache.client.Cache;
import com.memcache.client.MemCache;

import com.memcache.client.config.CacheConfiguration;
import com.memcache.client.config.DefaultConfigurationBuilder;
import com.memcache.client.exception.CacheInitializationException;

public class CacheFactory {
	
	public static Cache createCache(CacheConfiguration config) throws CacheInitializationException {
		if(config == null) {
			config = DefaultConfigurationBuilder.getDefaultConfiguration();
		}
        return new MemCache(config);
    }
	
	public static void removeCache() {
		
	}	

}
