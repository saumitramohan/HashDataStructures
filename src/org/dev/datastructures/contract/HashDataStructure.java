package org.dev.datastructures.contract;

public interface HashDataStructure<K, V> {

	public void put(K key, V value);

	public V get(K key) throws IndexOutOfBoundsException;

	public void remove(K key) throws NullPointerException;

	public void checkCapacity();
	
	public final int  initialCapacity = 16;
	
	public final double loadFactor = 0.75;
	
	public void rehash();

}
