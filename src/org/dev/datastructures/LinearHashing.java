package org.dev.datastructures;
import org.dev.datastructures.contract.HashDataStructureAbstract;

public class LinearHashing<K, V> extends HashDataStructureAbstract<K, V> {

	@Override
	public void remove(Object key) {
		// TODO Auto-generated method stub
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node != null && node.key.equals(key)) {
			numberofElements--;
			node = null;
		} else {
			int index = findIndex(getIndexForKey(key), key);
			if (index != -1) {
				numberofElements--;
				node = getNodeForKey(key);
				node = null;
			} 
		}
	}

	public LinearHashing() {
		hashtable = new LinkedListNode[currentCapcity];
	}

	public void put(K key, V value) {
		LinkedListNode<K, V> node = getNodeForKey(key);
		//checkCapacity();
		if (node == null) {
			numberofElements++;
			node = new LinkedListNode<K, V>(key, value);
			hashtable[getIndexForKey(key)] = node;
		} else {
			int index = findIndexToInsert(getIndexForKey(key));
			if (index != -1) {
				numberofElements++;
				node = new LinkedListNode<K, V>(key, value);
				hashtable[index] = node;
			} 
		}
	}

	private int findIndexToInsert(int index) {
		for (int i = index + 1; i < hashtable.length; i++) {
			
			LinkedListNode<K, V> tempNode = getNodeForKey(i);
			
			if (tempNode == null) {
				collions = i-index;
				return i;
			}
		}
		return -1;
	}

	private int findIndex(int index, Object key) {
		for (int i = index + 1; i < hashtable.length; i++) {
			LinkedListNode<K, V> tempNode = getNodeForKey(i);
			if (tempNode != null && tempNode.key.equals(key)) {
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
			if (node != null && node.key.equals(key)) {
				return node.value;
			} else {
				 
				int index = findIndex(getIndexForKey(key), key);
				LinkedListNode<K, V> tempNode = getNodeForKey(index);
				return tempNode.value;
			}
		}
	}
	
	public int getCollions() {
		return collions;
	}
	public void setCollions() {
		 collions = 0;
	}
	
}
