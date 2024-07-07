package com.memcache.client;

import java.util.Map;
import java.util.Set;


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
     */
    public void put(int key, int value);

    /**
     * Maps all the specified entries in this cache.
     * 
     * @param entries the entries to be associated with their respective keys
     */
    public void putAll(Map<Integer, Integer> entries);

    /**
     * Maps the specified key to the specified value in this cache,
     * unless a non-expired mapping already exists.
     * 
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the existing value associated with the key, or null if there was no mapping for the key
     */
    public int putIfAbsent(int key, int value);

    /**
     * Returns the value to which the specified key is mapped,
     * or null if this cache contains no mapping for the key.
     * 
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if there is no mapping for the key
     */
    public int get(int key);

    /**
     * Returns a map of the values to which the specified keys are mapped.
     * 
     * @param keys the keys whose associated values are to be returned
     * @return a map of the values to which the specified keys are mapped
     */
    public Map<Integer, Integer> getAll(Set<Integer> keys);

    /**
     * Removes the mapping for the specified key from this cache if present.
     * 
     * @param key the key whose mapping is to be removed from the cache
     * @return true if the mapping was removed, false otherwise
     */
    public boolean remove(int key);

    /**
     * Removes the entry for the specified key only if it is currently mapped to the specified value and is not expired.
     * 
     * @param key the key whose mapping is to be removed
     * @param value the value expected to be associated with the key
     * @return true if the value was removed, false otherwise
     */
    public boolean remove(int key, int value);

    /**
     * Removes the mappings for the specified keys from this cache.
     * 
     * @param keys the keys whose mappings are to be removed from the cache
     */
    public void removeAll(Set<Integer> keys);

    /**
     * Replaces the entry for the specified key only if it is currently mapped to some value and the entry is not expired.
     * 
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the previous value associated with the key, or null if there was no mapping for the key
     */
    public int replace(int key, int value);

    /**
     * Replaces the entry for the specified key only if it is currently mapped to the old value and the entry is not expired.
     * 
     * @param key the key with which the specified value is to be associated
     * @param oldValue the value expected to be associated with the key
     * @param newValue the value to be associated with the specified key
     * @return true if the value was replaced, false otherwise
     */
    public boolean replace(int key, int oldValue, int newValue);
}
