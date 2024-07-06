package com.memcache.client.config;


// Configuration class for cache settings
public class CacheConfiguration {
    
	protected int initialSize; 
	protected String cacheName;
	protected int expirationTimeInSeconds; 
    
	protected boolean loggingEnabled;
	protected boolean compressionEnabled;

    // Package Private constructor to enforce the use of the builder
    protected CacheConfiguration() {}

    public int getInitialSize() {
        return initialSize;
    }

    public String getCacheName() {
        return cacheName;
    }

    public int getExpirationTimeInSeconds() {
        return expirationTimeInSeconds;
    }

    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    public boolean isCompressionEnabled() {
        return compressionEnabled;
    }
}
