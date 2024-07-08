# memcache-client



# Example:
```java
public class Main {
	public static void main(String[] args) {
		CacheConfiguration config = new ConfigurationBuilder()
				.setInitialSize(100)									
				.setCacheName("db-cache-id-5432")									
				.setExpirationTime(60)
				.setLoggingEnabled(false)
				.setCompressionEnabled(false)
				.build();
		
		Cache memCache = CacheManager.createCache(config);
		memCache.put(13, 26);
		System.out.println(memCache.get(13));          // 26
		System.out.println(memCache.remove(13));       // true
		System.out.println(memCache.containsKey(13));  // false
	}
}
```

# todo:
- Add logging
- Add statistics
- Improving the native interface to suppport more types
- Can the cache be iterable?
- Add native binaries of cross-platforms (Win, Mac) 