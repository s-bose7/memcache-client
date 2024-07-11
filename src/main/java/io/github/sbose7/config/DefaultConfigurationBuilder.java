package io.github.sbose7.config;

/**
 * Provides a default configuration for a cache instance using a builder pattern.
 */
public class DefaultConfigurationBuilder {
    
    /**
     * Returns a default cache configuration.
     *
     * @return a {@link CacheConfiguration} object representing the default cache configuration.
     */
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
