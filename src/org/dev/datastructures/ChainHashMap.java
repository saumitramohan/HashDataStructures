package org.dev.datastructures;

import java.util.ArrayList;

import org.dev.datastructures.contract.HashDataStructure;

public class ChainHashMap<K,V> implements HashDataStructure{

	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Object key) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void createBucket(int capacity) {
		// TODO Auto-generated method stub
		array = new ArrayList<>();
		array.ensureCapacity((int) (0.75 * capacity));
	}
	
	private static class LinkedListNode <K,V>{
		public LinkedListNode <K,V> next;
		public LinkedListNode <K,V> prev;
		public K key;
		public V value;
		public LinkedListNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	private ArrayList <LinkedListNode <K,V>> array;
	
	
	

}
