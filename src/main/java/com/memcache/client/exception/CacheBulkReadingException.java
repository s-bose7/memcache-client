package com.memcache.client.exception;

public class CacheBulkReadingException extends RuntimeException {

	private static final long serialVersionUID = -7793637477895779531L;
	
	public CacheBulkReadingException(String message) {
		super(message);
	}
	
	public CacheBulkReadingException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CacheBulkReadingException(Throwable cause) {
		super(cause);
	}

}
