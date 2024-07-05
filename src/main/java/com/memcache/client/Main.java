package com.memcache.client;


public class Main {
	public static void main(String[] args) {
		
    	MemCache memCache = new MemCache(10);
    	memCache.put(120, 345);
    	memCache.put(121, 346);
    	memCache.put(122, 347);
    	memCache.put(123, 348);

    	System.out.println("Key: 120, Value: " + memCache.get(120)); // 345
    	System.out.println("Key: 121, Value: " + memCache.get(121)); // 346
    	System.out.println("Key: 122, Value: " + memCache.get(122)); // 347
    	System.out.println("Key: 123, Value: " + memCache.get(123)); // 348

    	boolean preRemovalStatus = memCache.exists(123);
    	boolean postRemovalStatus= memCache.remove(123);  	
    	
    	if(preRemovalStatus == true && postRemovalStatus == true) {
    		System.out.println("Success!");
    	}
	}
}
