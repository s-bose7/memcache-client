package com.memcache.client.core;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;


public interface NativeCache extends Library {
	
	public NativeCache INSTANCE = (NativeCache) Native.load("MemCache", NativeCache.class);
	
	
	public Pointer init(int capacity);
	public void deleteCache(Pointer cache);
	
	public int get(Pointer cache, int key);
	public void put(Pointer cache, int key, int value, int ttl);
	public boolean removeFromCache(Pointer cache, int key);
	public boolean clear(Pointer cache);
	public boolean exists(Pointer cache, int key);	
}
