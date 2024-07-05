package com.memcache.client;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface NativeCache extends Library {
	
	NativeCache INSTANCE = (NativeCache) Native.load("MemCache", NativeCache.class);
	
	Pointer createCache(int capacity);
	void deleteCache(Pointer cache);
	
	String get(Pointer cache, String key);
	void put(Pointer cache, String key, String value);
    boolean removeFromCache(Pointer cache, String key);
    boolean clear(Pointer cache);
    boolean exists(Pointer cache, String key);	
}
