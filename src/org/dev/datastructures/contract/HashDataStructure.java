package org.dev.datastructures.contract;

public interface HashDataStructure<K, V> {
	
	public void put(K key, V value);

	public V get(K key);

	public void remove(K key);

	public void createBucket(int capacity);
	
}
