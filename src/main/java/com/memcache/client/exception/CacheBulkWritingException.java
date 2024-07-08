package com.memcache.client.exception;

public class CacheBulkWritingException extends RuntimeException {

	private static final long serialVersionUID = -7865326727265409616L;
	
	public CacheBulkWritingException(String message) {
		super(message);
	}
	
	public CacheBulkWritingException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CacheBulkWritingException(Throwable cause) {
		super(cause);
	}
}
