package com.memcache.client.exception;

public class CacheWritingException extends RuntimeException {

	private static final long serialVersionUID = -3994192923344658907L;
	
	public CacheWritingException(String message) {
		super(message);
	}
	
	public CacheWritingException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CacheWritingException(Throwable cause) {
		super(cause);
	}

}
