/*
* Copyright (c) 2019, Isak Hauge.
* */

package com.isakhauge.util;

/**
 * Pair
 * A fast, light weight Pair class for Java with no dependencies.
 * @author Isak Hauge
 * @param <K> Key.
 * @param <V> Value.
 * @version 0.1
 */
public class Pair<K,V> implements Comparable<Pair> {

	/**
	 * Object data.
	 */
	private K key;
	private V value;

	/**
	 * Default constructor.
	 * @author Isak Hauge
	 */
	public Pair() {
		this.key = null;
		this.value = null;
	}

	/**
	 * Constructor.
	 * @param key Key cannot be of primitive type.
	 * @param value Value cannot be of primitive type.
	 * @author Isak Hauge
	 */
	public Pair(K key, V value) {
		this.setKey(key);
		this.setValue(value);
	}

	/**
	 * Get object key.
	 * @return The key.
	 * @author Isak Hauge
	 */
	public K getKey() {
		return this.key;
	}

	/**
	 * Set the object key.
	 * @param key Key cannot be of primitive type.
	 * @return {@code Pair}
	 * @author Isak Hauge
	 */
	public Pair<K,V> setKey(K key) {
		this.key = key;
		return this;
	}

	/**
	 * Get value.
	 * @return {@code V}
	 * @author Isak Hauge
	 */
	public V getValue() {
		return this.value;
	}

	/**
	 * Set object value.
	 * @param value Value cannot be of primitive type.
	 * @return {@code Pair}
	 * @author Isak Hauge
	 */
	public Pair<K,V> setValue(V value) {
		this.value = value;
		return this;
	}

	/**
	 * Set both key and value in one method.
	 * @param key Key cannot be of primitive type.
	 * @param value Value cannot be of primitive type.
	 * @return {@code Pair}
	 * @author Isak Hauge
	 */
	public Pair<K,V> put(K key, V value) {
		this.setKey(key);
		this.setValue(value);
		return this;
	}

	/**
	 * Checks if the object value is numeric.
	 * @param value
	 * @return {@code true} if the value is numeric.
	 * @author Isak Hauge
	 */
	private boolean valueIsNumeric(V value) {
		try {
			double d = Double.parseDouble(String.valueOf(value));
		} catch (NumberFormatException | NullPointerException | ClassCastException e) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if the object key is numeric.
	 * @param key
	 * @return {@code true} if the key is numeric.
	 * @author Isak Hauge
	 */
	private boolean keyIsNumeric(K key) {
		try {
			double d = Double.parseDouble(String.valueOf(key));
		} catch (NumberFormatException | NullPointerException | ClassCastException e) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if the object value is numeric.
	 * @return {@code true} if the value is numeric.
	 * @author Isak Hauge
	 */
	public boolean valueIsNumeric() {
		return this.valueIsNumeric(this.getValue());
	}

	/**
	 * Checks if the object key is numeric.
	 * @return {@code true} if the key is numeric.
	 */
	public boolean keyIsNumeric() {
		return this.keyIsNumeric(this.getKey());
	}

	/**
	 * Returns a string representation of the object in a JSON-style format.
	 * @return A {@code String} representation of the object.
	 * @author Isak Hauge
	 */
	@Override
	public String toString(){
		boolean keyIsString = this.getKey() instanceof String;
		boolean keyIsCharacter = this.getKey() instanceof Character;
		boolean valueIsString = this.getValue() instanceof String;
		boolean valueIsCharacter = this.getValue() instanceof Character;
		String keyLiteral = "";
		String valueLiteral = "";
		if (keyIsString)
			keyLiteral = "\"";
		if (keyIsCharacter)
			keyLiteral = "'";
		if (valueIsString)
			valueLiteral = "\"";
		if (valueIsCharacter)
			valueLiteral = "'";
		return "{"
			+ keyLiteral + this.getKey() + keyLiteral
			+ ", "
			+ valueLiteral + this.getValue() + valueLiteral
			+ "}";
	}

	/**
	 * Compares this object with the specified object for order.  Returns a
	 * negative integer, zero, or a positive integer as this object is less
	 * than, equal to, or greater than the specified object.
	 * @param o Another {@code Pair} object.
	 * @return {@code int}
	 * @author Isak Hauge
	 */
	@Override
	public int compareTo(Pair o) {
		try {
			if (this.valueIsNumeric() && o.valueIsNumeric()) {
				double self = ((double) this.getValue());
				double other = ((double) o.getValue());
				return Double.compare(self, other);
			} else if (this.keyIsNumeric() && o.keyIsNumeric()){
				double self = ((double) this.getKey());
				double other = ((double) o.getKey());
				return Double.compare(self, other);
			}
		} catch (NullPointerException npe) {
			throw new NullPointerException("Cannot compare with an non-existing object.");
		} catch (ClassCastException cce) {
			return 0;
		}
		return 0;
	}
}
