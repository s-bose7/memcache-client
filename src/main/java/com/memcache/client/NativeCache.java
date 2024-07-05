package com.memcache.client;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface NativeCache extends Library {
	
	NativeCache INSTANCE = (NativeCache) Native.load("MemCache", NativeCache.class);
	
	Pointer createCache(int capacity);
	void deleteCache(Pointer cache);
	
	int get(Pointer cache, int key);
	void put(Pointer cache, int key, int value);
    boolean removeFromCache(Pointer cache, int key);
    boolean clear(Pointer cache);
    boolean exists(Pointer cache, int key);
	
}
