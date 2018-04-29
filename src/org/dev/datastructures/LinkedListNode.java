package org.dev.datastructures;

public class LinkedListNode<K, V> {
	public LinkedListNode<K, V> next;
	public LinkedListNode<K, V> prev;
	public K key;
	public V value;

	public LinkedListNode(Object key, Object value) {
		this.key = (K) key;
		this.value = (V) value;
	}
}