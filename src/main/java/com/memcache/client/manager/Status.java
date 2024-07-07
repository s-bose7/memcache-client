package com.memcache.client.manager;

public enum Status {
  /*
   * Uninitialized, indicates it is not ready for use.
   */
  UNINITIALIZED,

  /*
   * Maintenance, indicates exclusive access to allow for restricted operations.
   */
  MAINTENANCE,

  /*
   * Available, indicates it is ready for use.
   */
  AVAILABLE;

}
