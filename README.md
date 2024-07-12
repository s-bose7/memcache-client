# memcache-client

![maven-build](https://github.com/s-bose7/memcache-client/actions/workflows/build.yml/badge.svg)
![License](https://img.shields.io/github/license/s-bose7/memcache-client?color=blue)
![lifecycle](https://img.shields.io/badge/lifecycle-beta-blue)
![Maven Central Version](https://img.shields.io/maven-central/v/io.github.s-bose7/memcache-client)


The library provides Java binding for [memcache](https://github.com/s-bose7/memcache.git), allowing seamless integration of memcache's in-memory caching capabilities into Java applications. It simplifies the process of interacting with memcache's caching functionalities from Java code, leveraging the power and efficiency of memcache within a Java environment.

Additionally, the library inherently supports bulk read/write operations to the cache, iteration capabilities, cache configuration management etc.

# Setup

You can find this library in [Maven central repository](https://mvnrepository.com/artifact/io.github.s-bose7/memcache-client). 

Include the latest version of memcache-client into your project:

In Maven:

```xml
<dependency>
  <groupId>io.github.s-bose7</groupId>
  <artifactId>memcache-client</artifactId>
  <version>version</version>
</dependency>
```


# Example Usage:

Cache initialization follows the builder and simple factory patterns. Clients have the option to initialize the cache with no configuration, in which case the factory will provide a default cache configuration.

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

