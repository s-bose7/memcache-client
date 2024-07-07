package com.memcache.client;

import com.sun.jna.Pointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.memcache.client.config.CacheConfiguration;


public class MemCache implements Cache {
	
	private int TTL;
	private int capacity;

	private Pointer nativeCachePtr;
	private CacheConfiguration cacheConfig;
	
	
	public MemCache(CacheConfiguration config) {
		cacheConfig = config;
		TTL = cacheConfig.getExpirationTimeInSeconds();
		
		capacity = cacheConfig.getInitialSize();
		if(capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be non negative");
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
	public void put(int key, int value) {
		NativeCache.INSTANCE.put(nativeCachePtr, key, value, TTL);
	}

	@Override
	public void putAll(Map<Integer, Integer> entries) {
		for(Map.Entry<Integer, Integer> entry : entries.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public int putIfAbsent(int key, int value) {
		if(!containsKey(key)) {
			put(key, value);
			return value;
		}
		return get(key);
	}

	@Override
	public int get(int key) {
		int value = NativeCache.INSTANCE.get(nativeCachePtr, key);
		return value;
	}

	@Override
	public Map<Integer, Integer> getAll(Set<Integer> keys) {
		HashMap<Integer, Integer> mappings = new HashMap<>();
		for(int key : keys) {
			mappings.put(key, get(key));
		}
		return mappings;
	}

	@Override
	public boolean remove(int key) {
		return NativeCache.INSTANCE.removeFromCache(nativeCachePtr, key);
	}

	@Override
	public boolean remove(int key, int value) {
		if(containsKey(key) && get(key) == value) {
			return remove(key);
		}
		return false;
	}

	@Override
	public void removeAll(Set<Integer> keys) {
		for(int key : keys) {
			remove(key);
		}
	}

	@Override
	public int replace(int key, int value) {
		int oldValue = get(key);
		put(key, value);
		return oldValue;
	}

	@Override
	public boolean replace(int key, int oldValue, int newValue) {
		int mappedValue = get(key);
		if (mappedValue != (oldValue)) {
			return false;
		}
		put(key, newValue);
		return true;
	}
}
