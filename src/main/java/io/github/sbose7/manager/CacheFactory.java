package io.github.sbose7.manager;

import io.github.sbose7.Cache;
import io.github.sbose7.core.MemCache;
import io.github.sbose7.config.CacheConfiguration;
import io.github.sbose7.config.DefaultConfigurationBuilder;

import io.github.sbose7.exception.CacheInitializationException;

/**
 * A factory class for creating and managing instances of {@link Cache}.
 */
public class CacheFactory {

    /**
     * Creates a new {@link Cache} instance based on the provided configuration.
     *
     * @param config the configuration object used to initialize the cache
     * @return a new instance of {@link Cache} initialized with the given configuration
     * @throws CacheInitializationException if an error occurs during cache initialization
     */
    public static Cache createCache(CacheConfiguration config) throws CacheInitializationException {
        if (config == null) {
            config = DefaultConfigurationBuilder.getDefaultConfiguration();
        }
        return new MemCache(config);
    }

    /**
     * Placeholder method for removing an existing cache instance.
     * Implement as needed for specific cache management requirements.
     */
    public static void removeCache() {
        // Implementation can be added based on specific requirements
    }
}

