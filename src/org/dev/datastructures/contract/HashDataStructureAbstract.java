package org.dev.datastructures.contract;

import java.util.ArrayList;

import org.dev.datastructures.LinkedListNode;

public abstract class HashDataStructureAbstract<K, V> implements HashDataStructure<K, V> {

	protected ArrayList<LinkedListNode<K, V>> array;

	public void put(K key, V value) {
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node != null) {
			node.value = (V) value;
		} else {
			node = new LinkedListNode<K, V>(key, value);
			array.set(getIndexForKey(key), node);
		}

	}

	protected int getIndexForKey(Object key) {
		return (int) Math.abs(key.hashCode() % array.size());
	}

	protected LinkedListNode<K, V> getNodeForKey(Object key) {
		// TODO Auto-generated method stub
		int index = getIndexForKey(key);
		LinkedListNode<K, V> node = array.get(index);
		if (node != null && node.key == key) {
			return node;
		}
		return node;
	}

	@Override
	public V get(Object key) {
		if (key == null)
			return null;
		else {
			LinkedListNode<K, V> node = getNodeForKey(key);
			return node.value;
		}
	}

	@Override
	public abstract void remove(Object key);
	// TODO Auto-generated method stub

}
