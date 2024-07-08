package com.memcache.client;

import com.memcache.client.core.NativeCache;
import com.memcache.client.config.CacheConfiguration;

import com.memcache.client.exception.CacheBulkReadingException;
import com.memcache.client.exception.CacheBulkWritingException;
import com.memcache.client.exception.CacheInitializationException;
import com.memcache.client.exception.CacheReadingException;
import com.memcache.client.exception.CacheWritingException;

import com.sun.jna.Pointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MemCache implements Cache {

	private int TTL;
	private int capacity;

	private Pointer nativeCachePtr;
	private CacheConfiguration cacheConfig;

	public MemCache(CacheConfiguration config) throws CacheInitializationException {
		cacheConfig = config;
		TTL = cacheConfig.getExpirationTimeInSeconds();

		capacity = cacheConfig.getInitialSize();
		if (capacity <= 0) {
			throw new CacheInitializationException("Capacity must be non negative");
		}
		nativeCachePtr = NativeCache.INSTANCE.init(capacity);
	}

	@Override
	public boolean clear() {
		return NativeCache.INSTANCE.clear(nativeCachePtr);
	}

	@Override
	public boolean containsKey(int key) {
		return NativeCache.INSTANCE.exists(nativeCachePtr, key);
	}

	@Override
	public void put(int key, int value) throws CacheWritingException {
		try {
			NativeCache.INSTANCE.put(nativeCachePtr, key, value, TTL);
		} catch (Exception e) {
			throw new CacheWritingException("Error writing to cache for key: " + key, e);
		}
	}

	@Override
	public void putAll(Map<Integer, Integer> entries) throws CacheBulkWritingException {

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
			return NativeCache.INSTANCE.get(nativeCachePtr, key);
		} catch (Exception e) {
			throw new CacheReadingException("Error reading from cache for key: " + key, e);
		}
	}

	@Override
	public Map<Integer, Integer> getAll(Set<Integer> keys) throws CacheBulkReadingException {
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
			return NativeCache.INSTANCE.removeFromCache(nativeCachePtr, key);
		} catch (Exception e) {
			throw new CacheWritingException("Error writing to cache for key: " + key, e);
		}
	}

	@Override
	public boolean remove(int key, int value) throws CacheWritingException {
		try {
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
