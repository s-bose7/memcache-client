package io.github.sbose7.exception;

import io.github.sbose7.Cache;

/**
 * Exception thrown by a {@link Cache} when it encounters an error during iteration
 * or traversal of cache elements.
 */
public class CacheIterationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new CacheIterationException with no detail message.
     */
    public CacheIterationException() {
        super();
    }

    /**
     * Constructs a new CacheIterationException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public CacheIterationException(String message) {
        super(message);
    }

    /**
     * Constructs a new CacheIterationException with the specified detail message
     * and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     * @param cause   the cause (which is saved for later retrieval by the {@link #getCause()} method)
     */
    public CacheIterationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new CacheIterationException with the specified cause and a
     * detail message of (cause==null ? null : cause.toString()) (which typically
     * contains the class and detail message of cause). This constructor is useful
     * for exceptions that are little more than wrappers for other throwables (for
     * example, {@link java.security.PrivilegedActionException}).
     *
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method).
     *              (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public CacheIterationException(Throwable cause) {
        super(cause);
    }

}
