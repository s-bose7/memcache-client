package com.memcache.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sun.jna.Pointer;


public class MemCache implements Cache {
	
	private Pointer nativeCachePtr;
	private final static int DEFAULT_CAPACITY = 10000;
	
	@SuppressWarnings("unused")
	private final static int TTL = Integer.MAX_VALUE;
	
	public MemCache() {
		this(DEFAULT_CAPACITY);
	}
	
	public MemCache(int capacity) {
		if(capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be non negative");
		}
		nativeCachePtr = NativeCache.INSTANCE.createCache(capacity);
	}

	@Override
	public boolean clear() {
		return NativeCache.INSTANCE.clear(nativeCachePtr);
	}

	@Override
	public boolean containsKey(String key) {
		return NativeCache.INSTANCE.exists(nativeCachePtr, key);
	}

	@Override
	public void put(String key, Object value) {
		
	}

	@Override
	public void put(String key, Object value, int ttl) {

	}

	@Override
	public void putAll(Map<String, Object> entries) {
		for(Map.Entry<String, Object> entry : entries.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public Object putIfAbsent(String key, Object value) {
		if(!containsKey(key)) {
			put(key, value);
			return value;
		}
		return get(key);
	}

	@Override
	public Object get(String key) {
		return null;
	}

	@Override
	public Map<String, Object> getAll(Set<String> keys) {
		HashMap<String, Object> mappings = new HashMap<>();
		for(String key : keys) {
			mappings.put(key, get(key));
		}
		return mappings;
	}

	@Override
	public boolean remove(String key) {
		return NativeCache.INSTANCE.removeFromCache(nativeCachePtr, key);
	}

	@Override
	public boolean remove(String key, Object value) {
		if(containsKey(key) && get(key).equals(value)) {
			return remove(key);
		}
		return false;
	}

	@Override
	public void removeAll(Set<String> keys) {
		for(String key : keys) {
			remove(key);
		}
	}

	@Override
	public Object replace(String key, Object value) {
		Object oldValue = get(key);
		put(key, value);
		return oldValue;
	}

	@Override
	public boolean replace(String key, Object oldValue, Object newValue) {
		Object mappedValue = get(key);
		if (!mappedValue.equals(oldValue)) {
			return false;
		}
		put(key, newValue);
		return true;
	}
}
