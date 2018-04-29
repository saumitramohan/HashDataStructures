package org.dev.datastructures;

import java.util.ArrayList;
import org.dev.datastructures.contract.HashDataStructureAbstract;

public class LinearHashing<K, V> extends HashDataStructureAbstract<K, V> {

	@Override
	public void remove(Object key) {
		// TODO Auto-generated method stub
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node != null && node.key == key) {
			node = null;
		} else {
			int index = findIndex(getIndexForKey(key), key);
			if (index != -1) {
				node = getNodeForKey(key);
				node = null;
			} else {
				throw new ArrayIndexOutOfBoundsException();
			}
		}
	}

	public LinearHashing(int capacity) {
		array = new ArrayList<>(capacity);
		array.ensureCapacity(capacity);
		for (int i = 0; i < capacity; i++) {
			array.add(null);
		}
	}

	public void put(K key, V value) {
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node == null) {
			node = new LinkedListNode<K, V>(key, value);
			array.set(getIndexForKey(key), node);
		} else {
			int index = findIndexToInsert(getIndexForKey(key));
			if (index != -1) {
				node = new LinkedListNode<K, V>(key, value);
				array.set(index, node);
			} else {
				throw new ArrayIndexOutOfBoundsException();
			}

		}
	}

	private int findIndexToInsert(int index) {
		for (int i = index + 1; i < array.size(); i++) {
			LinkedListNode<K, V> tempNode = getNodeForKey(i);
			if (tempNode == null) {
				return i;
			}
		}
		return -1;
	}

	private int findIndex(int index, Object key) {
		for (int i = index + 1; i < array.size(); i++) {
			LinkedListNode<K, V> tempNode = getNodeForKey(i);
			if (tempNode != null && tempNode.key == key) {
				return i;
			}
		}
		return -1;
	}

	public V get(Object key) {
		if (key == null)
			return null;
		else {
			LinkedListNode<K, V> node = getNodeForKey(key);
			if (node != null && node.key == key) {
				return node.value;
			} else {
				int index = findIndex(getIndexForKey(key), key);
				LinkedListNode<K, V> tempNode = getNodeForKey(index);
				return tempNode.value;
			}
		}
	}
}
