package org.dev.datastructures;

import org.dev.datastructures.contract.HashDataStructureAbstract;

public class ChainHashing<K, V> extends HashDataStructureAbstract<K, V> {

	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub

		LinkedListNode<K, V> node = getNodeForKey(key);
		// checkCapacity();
		numberofElements++;
		if (node != null) {
			node.value = (V) value;
			return;
		} else {
			node = new LinkedListNode<K, V>(key, value);
			int index = getIndexForKey(key);
			if (hashtable[index] != null) {
				node.next = (LinkedListNode<K, V>) hashtable[index];
				node.next.prev = node;
			}
			hashtable[index] = node;
			return;
		}
	}

	@Override
	public void remove(Object key) {
		// TODO Auto-generated method stub
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			hashtable[getIndexForKey(key)] = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}

	}

	public ChainHashing() {
		// TODO Auto-generated method stub
		hashtable = new LinkedListNode[currentCapcity];
	}

	protected LinkedListNode<K, V> getNodeForKey(Object key) {
		// TODO Auto-generated method stub
		int index = getIndexForKey(key);
		LinkedListNode<K, V> node = hashtable[index];
		while (node != null) {

			if (node.key.equals(key)) {

				return node;
			} else {
				node = node.next;
			}
		}
		return null;
	}
}
