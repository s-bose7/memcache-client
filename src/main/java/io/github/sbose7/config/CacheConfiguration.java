package io.github.sbose7.config;

/**
 * Configuration class for cache settings.
 */
public class CacheConfiguration {
    
    /**
     * Initial size of the cache.
     */
    protected int initialSize;
    
    /**
     * Name of the cache.
     */
    protected String cacheName;
    
    /**
     * Expiration time for cache entries in seconds.
     */
    protected int expirationTimeInSeconds;
    
    /**
     * Flag indicating if logging is enabled for the cache.
     */
    protected boolean loggingEnabled;
    
    /**
     * Flag indicating if compression is enabled for cache entries.
     */
    protected boolean compressionEnabled;

    // Package Private constructor to enforce the use of the builder
    protected CacheConfiguration() {
        // Empty constructor to enforce builder usage.
    }

    /**
     * Gets the initial size of the cache.
     *
     * @return the initial size of the cache
     */
    public int getInitialSize() {
        return initialSize;
    }

    /**
     * Gets the name of the cache.
     *
     * @return the name of the cache
     */
    public String getCacheName() {
        return cacheName;
    }

    /**
     * Gets the expiration time for cache entries in seconds.
     *
     * @return the expiration time for cache entries in seconds
     */
    public int getExpirationTimeInSeconds() {
        return expirationTimeInSeconds;
    }

    /**
     * Checks if logging is enabled for the cache.
     *
     * @return true if logging is enabled, false otherwise
     */
    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    /**
     * Checks if compression is enabled for cache entries.
     *
     * @return true if compression is enabled, false otherwise
     */
    public boolean isCompressionEnabled() {
        return compressionEnabled;
    }
}
