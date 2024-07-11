package io.github.sbose7.serialization;

import io.github.sbose7.exception.SerializerException;

/**
 * Defines the contract used to transform type instances to and from a serial form.
 */
public interface SerializerProvider {

	/**
	 * Transforms the given instance into its serial form.
	 *
	 * @param object the instance to serialize
	 *
	 * @return the json representation string of the serial form
	 *
	 * @throws SerializerException if serialization fails
	 */
	public String serialize(Object object) throws SerializerException;

	/**
	 * Reconstructs an instance from the given json form.
	 *
	 * @param str the json representation of the serial form
	 *
	 * @return the de-serialized instance
	 *
	 * @throws SerializerException if reading fails
	 */
	public Object read(String str) throws SerializerException;

}
