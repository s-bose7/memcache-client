package io.github.sbose7;


import java.util.Map;
import java.util.Set;

import io.github.sbose7.exception.CacheBulkReadingException;
import io.github.sbose7.exception.CacheBulkWritingException;
import io.github.sbose7.exception.CacheReadingException;
import io.github.sbose7.exception.CacheWritingException;

/**
 *  Defines all operational methods to create, access, update and delete mappings of key to value.
 *   A {@code Cache} is not a map, mostly because it has the following two concepts linked to mappings:
 * <ul>
 *   <li>Eviction: A {@code Cache} has a capacity constraint and in order to honor it, a {@code Cache} can
 *   evict (remove) a mapping at any point in time.</li>
 *   <li>Expiry: Data in a {@code Cache} can be configured to expire after some time. There is no way for a
 *   {@code Cache} user to differentiate from the API between a mapping being absent or expired.</li>
 * </ul>
 */
public interface Cache {

    /**
     * Clears the cache, removing all entries.
     * 
     * @return true if the cache was successfully cleared, false otherwise
     */
    public boolean clear();

    /**
     * Checks if the cache contains an entry for the specified key.
     * 
     * @param key the key to check for
     * @return true if the cache contains an entry for the key, false otherwise
     */
    public boolean containsKey(int key);

    /**
     * Maps the specified key to the specified value in this cache.
     * 
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @throws CacheWritingException if an error occurs while writing the value for the given key 
     *                               to the underlying native library.
     */
    public void put(int key, int value) throws CacheWritingException;

    /**
     * Maps all the specified entries in this cache.
     * 
     * @param entries the entries to be associated with their respective keys
     * @throws CacheBulkWritingException if an error occurs while writing multiple values 
     *                                   to the underlying native library.
     */
    public void putAll(Map<Integer, Integer> entries) throws CacheBulkWritingException;

    /**
     * Maps the specified key to the specified value in this cache,
     * unless a non-expired mapping already exists.
     * 
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the existing value associated with the key, or null if there was no mapping for the key
     * @throws CacheReadingException if an error occurs while reading the existing value for the given key 
     *                               from the underlying native library.
     * @throws CacheWritingException if an error occurs while writing the value for the given key 
     *                               to the underlying native library.
     */
    public int putIfAbsent(int key, int value) throws CacheReadingException, CacheWritingException;

    /**
     * Returns the value to which the specified key is mapped,
     * or default value type if this cache contains no mapping for the key.
     * 
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or default value type, 
     *                               if there is no mapping for the key.
     * @throws CacheReadingException if an error occurs while reading the value for the given key 
     *                               from the underlying native library.
     */
    public int get(int key) throws CacheReadingException;

    /**
     * Returns a map of the values to which the specified keys are mapped.
     * 
     * @param keys the keys whose associated values are to be returned
     * @return a map of the values to which the specified keys are mapped
     * @throws CacheBulkReadingException if an error occurs while reading multiple values 
     *                                   from the underlying native library.
     */
    public Map<Integer, Integer> getAll(Set<Integer> keys) throws CacheBulkReadingException;

    /**
     * Removes the mapping for the specified key from this cache if present.
     * 
     * @param key the key whose mapping is to be removed from the cache
     * @return true if the mapping was removed, false otherwise
     * @throws CacheWritingException if an error occurs while removing the value for the given key 
     *                               from the underlying native library.
     */
    public boolean remove(int key) throws CacheWritingException;

    /**
     * Removes the entry for the specified key only if it is currently mapped to the specified value and is not expired.
     * 
     * @param key the key whose mapping is to be removed
     * @param value the value expected to be associated with the key
     * @return true if the value was removed, false otherwise
     * @throws CacheWritingException if an error occurs while removing the value for the given key 
     *                               from the underlying native library.
     */
    public boolean remove(int key, int value) throws CacheWritingException;

    /**
     * Removes the mappings for the specified keys from this cache.
     * 
     * @param keys the keys whose mappings are to be removed from the cache
     * @throws CacheBulkWritingException if an error occurs while removing multiple values 
     *                                   from the underlying native library.
     */
    public void removeAll(Set<Integer> keys) throws CacheBulkWritingException;

    /**
     * Replaces the entry for the specified key only if it is currently mapped to some value and the entry is not expired.
     * 
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the previous value associated with the key, or null if there was no mapping for the key
     * @throws CacheReadingException if an error occurs while reading the existing value for the given key 
     *                               from the underlying native library.
     * @throws CacheWritingException if an error occurs while writing the value for the given key 
     *                               to the underlying native library.
     */
    public int replace(int key, int value) throws CacheReadingException, CacheWritingException;

    /**
     * Replaces the entry for the specified key only if it is currently mapped to the old value and the entry is not expired.
     * 
     * @param key the key with which the specified value is to be associated
     * @param oldValue the value expected to be associated with the key
     * @param newValue the value to be associated with the specified key
     * @return true if the value was replaced, false otherwise
     * @throws CacheReadingException if an error occurs while reading the existing value for the given key 
     *                               from the underlying native library.
     * @throws CacheWritingException if an error occurs while writing the value for the given key 
     *                               to the underlying native library.
     */
    public boolean replace(int key, int oldValue, int newValue) throws CacheReadingException, CacheWritingException;
}
