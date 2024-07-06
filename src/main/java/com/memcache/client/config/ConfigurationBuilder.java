package com.memcache.client.config;


//Builder pattern for constructing CacheConfig
public class ConfigurationBuilder {
	
    private CacheConfiguration config;

    public ConfigurationBuilder() {
        this.config = new CacheConfiguration();
    }

    public ConfigurationBuilder setInitialSize(int initialSize) {
        config.initialSize = initialSize;
        return this;
    }

    public ConfigurationBuilder setCacheName(String cacheName) {
        config.cacheName = cacheName;
        return this;
    }

    public ConfigurationBuilder setExpirationTime(int expirationTimeInSeconds) {
        config.expirationTimeInSeconds = expirationTimeInSeconds;
        return this;
    }

    public ConfigurationBuilder setLoggingEnabled(boolean loggingEnabled) {
        config.loggingEnabled = loggingEnabled;
        return this;
    }

    public ConfigurationBuilder setCompressionEnabled(boolean compressionEnabled) {
        config.compressionEnabled = compressionEnabled;
        return this;
    }

    public CacheConfiguration build() {
        return config;
    }
}
