package io.github.sbose7.manager;

import io.github.sbose7.Cache;
import io.github.sbose7.config.CacheConfiguration;
import io.github.sbose7.exception.CacheInitializationException;

/**
 * Manages caching operations and cache instances.
 */
public class CacheManager {

    /** The current status of the cache. */
    public static Status cacheStatus;

    /**
     * Creates a new cache instance based on the provided configuration.
     *
     * @param config the configuration details for creating the cache
     * @return a new instance of {@link Cache} based on the provided configuration
     */
    public static Cache createCache(CacheConfiguration config) {
        Cache cache = null;
        
        try {
            cache = CacheFactory.createCache(config);
        } catch (CacheInitializationException e) {
            e.printStackTrace();
        }

        return cache;
    }
    
    /**
     * Removes the currently managed cache instance.
     */
    public static void removeCache() {
        // Implementation to remove the cache instance
    }
}
