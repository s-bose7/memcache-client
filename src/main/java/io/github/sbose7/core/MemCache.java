package io.github.sbose7.core;

import com.sun.jna.Pointer;

import io.github.sbose7.Cache;
import io.github.sbose7.config.CacheConfiguration;
import io.github.sbose7.exception.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of Cache interface using native C++ library through JNA.
 */
public class MemCache implements Cache {

    private int TTL;
    private int capacity;

    private Pointer nativeCachePtr;
    private CacheConfiguration cacheConfig;

    /**
     * Constructor to initialize the MemCache instance.
     *
     * @param config The configuration object specifying cache parameters.
     * @throws CacheInitializationException If cache initialization fails.
     */
    public MemCache(CacheConfiguration config) throws CacheInitializationException {
        cacheConfig = config;
        TTL = cacheConfig.getExpirationTimeInSeconds();
        capacity = cacheConfig.getInitialSize();
        if (capacity <= 0) {
            throw new CacheInitializationException("Capacity must be non-negative");
        }
        nativeCachePtr = NativeCache.INSTANCE.init(capacity);
    }

    @Override
    public boolean clear() {
        // Clears the native cache.
        return NativeCache.INSTANCE.clear(nativeCachePtr);
    }

    @Override
    public boolean containsKey(int key) {
        // Checks if the key exists in the native cache.
        return NativeCache.INSTANCE.exists(nativeCachePtr, key);
    }

    @Override
    public void put(int key, int value) throws CacheWritingException {
        try {
            // Puts a key-value pair into the native cache.
            NativeCache.INSTANCE.put(nativeCachePtr, key, value, TTL);
        } catch (Exception e) {
            throw new CacheWritingException("Error writing to cache for key: " + key, e);
        }
    }

    @Override
    public void putAll(Map<Integer, Integer> entries) throws CacheBulkWritingException {
        // Puts multiple key-value pairs into the native cache.
        for (Map.Entry<Integer, Integer> entry : entries.entrySet()) {
            try {
                put(entry.getKey(), entry.getValue());
            } catch (CacheWritingException e) {
                throw new CacheBulkWritingException("Error writing multiple entries to cache", e);
            }
        }
    }

    @Override
    public int putIfAbsent(int key, int value) throws CacheReadingException, CacheWritingException {
        try {
            // Puts a key-value pair into the cache if the key does not already exist.
            if (!containsKey(key)) {
                put(key, value);
                return value;
            } else {
                return get(key);
            }
        } catch (CacheReadingException e) {
            throw new CacheReadingException("Error reading from cache for key: " + key, e);
        } catch (CacheWritingException e) {
            throw new CacheWritingException("Error writing to cache for key: " + key, e);
        }
    }

    @Override
    public int get(int key) throws CacheReadingException {
        try {
            // Retrieves the value associated with the key from the native cache.
            return NativeCache.INSTANCE.get(nativeCachePtr, key);
        } catch (Exception e) {
            throw new CacheReadingException("Error reading from cache for key: " + key, e);
        }
    }

    @Override
    public Map<Integer, Integer> getAll(Set<Integer> keys) throws CacheBulkReadingException {
        // Retrieves multiple key-value pairs from the native cache.
        HashMap<Integer, Integer> mappings = new HashMap<>();
        for (int key : keys) {
            try {
                int mappedValue = get(key);
                mappings.put(key, mappedValue);
            } catch (CacheReadingException e) {
                throw new CacheBulkReadingException("Error reading multiple entries from cache", e);
            }
        }
        return mappings;
    }

    @Override
    public boolean remove(int key) throws CacheWritingException {
        try {
            // Removes the key-value pair from the native cache.
            return NativeCache.INSTANCE.removeFromCache(nativeCachePtr, key);
        } catch (Exception e) {
            throw new CacheWritingException("Error writing to cache for key: " + key, e);
        }
    }

    @Override
    public boolean remove(int key, int value) throws CacheWritingException {
        try {
            // Removes the key-value pair from the native cache if the value matches.
            if (containsKey(key) && get(key) == value) {
                return remove(key);
            }
            return false;
        } catch (CacheReadingException e) {
            throw new CacheWritingException("Error reading from cache for key: " + key, e);
        }
    }

    @Override
    public void removeAll(Set<Integer> keys) throws CacheBulkWritingException {
        // Removes multiple key-value pairs from the native cache.
        for (int key : keys) {
            try {
                remove(key);
            } catch (CacheWritingException e) {
                throw new CacheBulkWritingException("Error removing multiple entries from cache", e);
            }
        }
    }

    @Override
    public int replace(int key, int value) throws CacheReadingException, CacheWritingException {
        try {
            // Replaces the value associated with the key in the native cache.
            int oldValue = get(key);
            put(key, value);
            return oldValue;
        } catch (CacheReadingException e) {
            throw new CacheReadingException("Error reading from cache for key: " + key, e);
        } catch (CacheWritingException e) {
            throw new CacheWritingException("Error writing to cache for key: " + key, e);
        }
    }

    @Override
    public boolean replace(int key, int oldValue, int newValue) throws CacheReadingException, CacheWritingException {
        try {
            // Replaces the value associated with the key in the native cache if the current value matches.
            int mappedValue = get(key);
            if (mappedValue != oldValue) {
                return false;
            }
            put(key, newValue);
            return true;
        } catch (CacheReadingException e) {
            throw new CacheReadingException("Error reading from cache for key: " + key, e);
        } catch (CacheWritingException e) {
            throw new CacheWritingException("Error writing to cache for key: " + key, e);
        }
    }
}
