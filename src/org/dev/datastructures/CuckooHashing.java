package org.dev.datastructures;

import java.util.ArrayList;

import org.dev.datastructures.contract.HashDataStructure;

public class CuckooHashing<K, V> implements HashDataStructure {

	public ArrayList<LinkedListNode<K, V>> arrayOne = null;
	public ArrayList<LinkedListNode<K, V>> arrayTwo = null;


	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return _get(key);
	}

	private Object _get(Object key) {
		// TODO Auto-generated method stub
		Object object  = null;
		object = _getFromTableOne(key);
		if (object == null) {
			object = _getFromTableTwo(key);
		}
		return object;
	}

	private Object _getFromTableOne(Object key) {
		int index = hashFunctionOne(key);
		return arrayOne.get(index);
	}
	
	private Object _getFromTableTwo(Object key) {
		int index = hashFunctionTwo(key);
		return arrayTwo.get(index);
	}

	private int hashFunctionOne(Object key) {
		return key.hashCode() % arrayOne.size();
	}

	private int hashFunctionTwo(Object key) {
		return ((key.hashCode()/arrayTwo.size()) % arrayTwo.size());
	}
	
	@Override
	public void remove(Object key) {
		// TODO Auto-generated method stub
		if (_get(key) != null) {
			Object object = _getFromTableOne(key);
			if (object != null) {
				arrayOne.set(hashFunctionOne(key),null);
			}
			else {
				arrayTwo.set(hashFunctionTwo(key),null);
			}
		}

	}
	
	public CuckooHashing(int capacity) {
		arrayOne = new ArrayList<>(capacity);
		arrayTwo = new ArrayList<>(capacity);
	}

}
