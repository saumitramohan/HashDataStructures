package org.dev.datastructures;

import java.util.ArrayList;
import org.dev.datastructures.contract.HashDataStructureAbstract;

public class ChainHashMap<K, V>  extends HashDataStructureAbstract<K, V> {


	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node != null) {
			node.value = (V) value;
		} else {
			node = new LinkedListNode<K, V>(key, value);
			int index = getIndexForKey(key);
			if (array.get(index) != null) {
				node.next = (LinkedListNode<K, V>) array.get(index);
				node.next.prev = node;
			}
			array.set(index, node);
		}
	}

	@Override
	public void remove(Object key) {
		// TODO Auto-generated method stub
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			array.set(getIndexForKey(key), node.next);
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}

	}

	public ChainHashMap(int capacity) {
		// TODO Auto-generated method stub
		array = new ArrayList<LinkedListNode<K, V>>();
		System.out.print("Ensure capacity");
		array.ensureCapacity(capacity);
		for (int i = 0; i < capacity; i++) {
			array.add(null);
		}

	}
	
	protected LinkedListNode<K, V> getNodeForKey(Object key) {
		// TODO Auto-generated method stub
		int index = getIndexForKey(key);
		LinkedListNode<K, V> node = array.get(index);
		while (node != null) {
			if (node.key == key) {
				return node;
			} else {
				node = node.next;
			}
		}
		return node;
	}
}
