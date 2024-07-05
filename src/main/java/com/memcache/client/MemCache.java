package com.memcache.client;

import com.sun.jna.Pointer;


public class MemCache {

	private Pointer cachePointer;
	@SuppressWarnings("unused")
	private final int TTL = Integer.MAX_VALUE;

	public MemCache(int capacity) {
		cachePointer = NativeCache.INSTANCE.createCache(capacity);
	}

	public void put(int key, int value) {
		NativeCache.INSTANCE.put(cachePointer, key, value);
	}

	public void put(int key, int value, int ttl) {
		if (ttl < 1) {
			put(key, value);
		}
	}

	public int get(int key) {
		return NativeCache.INSTANCE.get(cachePointer, key);
	}
	
	public boolean remove(int key) {
		return NativeCache.INSTANCE.removeFromCache(cachePointer, key);
	}
	
	public boolean exists(int key) {
		return NativeCache.INSTANCE.exists(cachePointer, key);
	}
	
	public boolean clear() {
		return NativeCache.INSTANCE.clear(cachePointer);
	}
	
//	@Override
//    public void close() {
//        if (cachePointer != null) {
//            NativeCache.INSTANCE.deleteCache(cachePointer);
//            cachePointer = null;
//        }
//    }

}
