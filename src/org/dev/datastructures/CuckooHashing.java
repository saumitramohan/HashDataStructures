package org.dev.datastructures;

import java.util.ArrayList;

import org.dev.datastructures.contract.HashDataStructure;

public class CuckooHashing<K, V> implements HashDataStructure<K,V> {

	public ArrayList<LinkedListNode<K, V>> arrayOne = null;
	public ArrayList<LinkedListNode<K, V>> arrayTwo = null;

	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		if (_getFromTableOne(key) == null) {
			int index = retrieveIndexFromTableOne(key);
			arrayOne.set(index, new LinkedListNode<>(key, value));
		} else if (_getFromTableOne(key) != null && _getFromTableTwo(key) == null) {
			LinkedListNode tempNode = (LinkedListNode) _getFromTableOne(key);
			arrayTwo.set(retrieveIndexFromTableTwo(key), tempNode);
			arrayOne.set(retrieveIndexFromTableOne(key), new LinkedListNode<>(key, value));
		} else if (_getFromTableOne(key) != null && _getFromTableTwo(key) != null) {
			LinkedListNode tempNode = (LinkedListNode<K, V>) _getFromTableOne(key);
			arrayOne.set(retrieveIndexFromTableOne(key), new LinkedListNode<>(key, value));
			LinkedListNode tempNode2 = (LinkedListNode) _getFromTableTwo(key);
			arrayTwo.set(retrieveIndexFromTableTwo(key), new LinkedListNode<>(tempNode.key, tempNode.value));
			put(tempNode2.key, tempNode2.value);
		}
		System.out.println("Successful");
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return _get(key);
	}

	private V _get(Object key) {
		// TODO Auto-generated method stub
		LinkedListNode node = null;
		node = _getFromTableOne(key);
		if (node == null) {
			node = _getFromTableTwo(key);
		}
		return (V) node.value;
	}

	private LinkedListNode<K, V> _getFromTableOne(Object key) {
		int index = retrieveIndexFromTableOne(key);
		return arrayOne.get(index);
	}

	private LinkedListNode<K, V> _getFromTableTwo(Object key) {
		return arrayOne.get(retrieveIndexFromTableTwo(key));
	}

	private int retrieveIndexFromTableOne(Object key) {
		return key.hashCode() % arrayOne.size();
	}

	private int retrieveIndexFromTableTwo(Object key) {
		return ((key.hashCode() / arrayTwo.size()) % arrayTwo.size());
	}

	@Override
	public void remove(Object key) {
		// TODO Auto-generated method stub
		if (_get(key) != null) {
			Object object = _getFromTableOne(key);
			if (object != null) {
				arrayOne.set(retrieveIndexFromTableOne(key), null);
			} else {
				arrayTwo.set(retrieveIndexFromTableTwo(key), null);
			}
		}

	}

	public CuckooHashing(int capacity) {
		arrayOne = new ArrayList<>(capacity);
		arrayTwo = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			arrayOne.add(null);
			arrayTwo.add(null);

		}
	}

	@Override
	public void checkCapacity() {
		// TODO Auto-generated method stub
		
	}

}
