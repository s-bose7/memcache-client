package com.memcache.client.manager;


import com.memcache.client.Cache;
import com.memcache.client.MemCache;

import com.memcache.client.config.CacheConfiguration;
import com.memcache.client.config.DefaultConfigurationBuilder;

public class CacheFactory {
	
	public static Cache createCache(CacheConfiguration config) {
		if(config == null) {
			config = DefaultConfigurationBuilder.getDefaultConfiguration();
		}
        return new MemCache(config);
    }
	
	public static void removeCache() {
		
	}	

}
