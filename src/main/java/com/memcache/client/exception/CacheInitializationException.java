package com.memcache.client.exception;


public class CacheInitializationException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CacheInitializationException(String message) {
		super(message);
	}
	
	public CacheInitializationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CacheInitializationException(Throwable cause) {
		super(cause);
	}
}
