package com.memcache.client.exception;

public class CacheReadingException extends RuntimeException {

	private static final long serialVersionUID = -8474075524692815336L;
	
	public CacheReadingException(String message) {
		super(message);
	}
	
	public CacheReadingException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CacheReadingException(Throwable cause) {
		super(cause);
	}
}
