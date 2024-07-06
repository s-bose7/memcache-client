package com.memcache.client.config;




public class DefaultConfigurationBuilder {
	
	public static CacheConfiguration getDefaultConfiguration() {
		return new ConfigurationBuilder()
						 .setCacheName("mem-cache-default-instance-x86-cpu")
						 .setInitialSize(1000)
						 .setExpirationTime(60)
						 .setLoggingEnabled(false)
						 .setCompressionEnabled(false)
						 .build();
	}
}
