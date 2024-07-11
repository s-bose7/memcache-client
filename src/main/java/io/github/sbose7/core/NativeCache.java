package io.github.sbose7.core;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

/**
 * Interface defining native methods for interacting with a caching library.
 */
public interface NativeCache extends Library {
	
	/**
	 * Instance of the NativeCache interface, loaded from the native library.
	 */
	public NativeCache INSTANCE = (NativeCache) Native.load("MemCache", NativeCache.class);
	
	/**
	 * Initializes a native cache with a specified capacity.
	 *
	 * @param capacity the initial capacity of the cache
	 * @return a pointer to the initialized cache
	 */
	public Pointer init(int capacity);
	
	/**
	 * Deletes a native cache.
	 *
	 * @param cache a pointer to the cache to delete
	 */
	public void deleteCache(Pointer cache);
	
	/**
	 * Retrieves the value associated with a key from the cache.
	 *
	 * @param cache a pointer to the cache
	 * @param key the key whose associated value is to be retrieved
	 * @return the value associated with the key
	 */
	public int get(Pointer cache, int key);
	
	/**
	 * Stores a key-value pair in the cache.
	 *
	 * @param cache a pointer to the cache
	 * @param key the key to store
	 * @param value the value to associate with the key
	 * @param ttl the time-to-live for the cached value
	 */
	public void put(Pointer cache, int key, int value, int ttl);
	
	/**
	 * Removes a key-value pair from the cache.
	 *
	 * @param cache a pointer to the cache
	 * @param key the key to remove
	 * @return true if the key was found and removed, false otherwise
	 */
	public boolean removeFromCache(Pointer cache, int key);
	
	/**
	 * Clears all entries from the cache.
	 *
	 * @param cache a pointer to the cache
	 * @return true if the cache was successfully cleared, false otherwise
	 */
	public boolean clear(Pointer cache);
	
	/**
	 * Checks if a key exists in the cache.
	 *
	 * @param cache a pointer to the cache
	 * @param key the key to check for existence
	 * @return true if the key exists in the cache, false otherwise
	 */
	public boolean exists(Pointer cache, int key);	
}
