package io.github.sbose7.config;

/**
 * Builder pattern for constructing {@link CacheConfiguration}.
 */
public class ConfigurationBuilder {
    
    private CacheConfiguration config;

    /**
     * Constructs a new ConfigurationBuilder with an initialized CacheConfiguration.
     */
    public ConfigurationBuilder() {
        this.config = new CacheConfiguration();
    }

    /**
     * Sets the initial size of the cache.
     *
     * @param initialSize the initial size of the cache
     * @return this ConfigurationBuilder instance
     */
    public ConfigurationBuilder setInitialSize(int initialSize) {
        config.initialSize = initialSize;
        return this;
    }

    /**
     * Sets the name of the cache.
     *
     * @param cacheName the name of the cache
     * @return this ConfigurationBuilder instance
     */
    public ConfigurationBuilder setCacheName(String cacheName) {
        config.cacheName = cacheName;
        return this;
    }

    /**
     * Sets the expiration time of cache entries in seconds.
     *
     * @param expirationTimeInSeconds the expiration time of cache entries in seconds
     * @return this ConfigurationBuilder instance
     */
    public ConfigurationBuilder setExpirationTime(int expirationTimeInSeconds) {
        config.expirationTimeInSeconds = expirationTimeInSeconds;
        return this;
    }

    /**
     * Enables or disables logging for cache operations.
     *
     * @param loggingEnabled true to enable logging, false to disable it
     * @return this ConfigurationBuilder instance
     */
    public ConfigurationBuilder setLoggingEnabled(boolean loggingEnabled) {
        config.loggingEnabled = loggingEnabled;
        return this;
    }

    /**
     * Enables or disables compression for cache entries.
     *
     * @param compressionEnabled true to enable compression, false to disable it
     * @return this ConfigurationBuilder instance
     */
    public ConfigurationBuilder setCompressionEnabled(boolean compressionEnabled) {
        config.compressionEnabled = compressionEnabled;
        return this;
    }

    /**
     * Builds and returns the configured CacheConfiguration object.
     *
     * @return a {@link CacheConfiguration} object based on the configuration settings
     */
    public CacheConfiguration build() {
        return config;
    }
}
