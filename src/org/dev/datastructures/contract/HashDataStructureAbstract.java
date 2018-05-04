package org.dev.datastructures.contract;

import org.dev.datastructures.LinkedListNode;

public abstract class HashDataStructureAbstract<K, V> implements HashDataStructure<K, V> {

	protected LinkedListNode<K, V> hashtable[];

	protected static int numberofElements = 0;
	protected static int currentCapcity = initialCapacity;
	protected  static int collions = 0;

	public static int counter = 0;

	public void put(K key, V value) {
		LinkedListNode<K, V> node = getNodeForKey(key);
		checkCapacity();
		if (node != null) {
			node.value = (V) value;
		} else {
			node = new LinkedListNode<K, V>(key, value);
			hashtable[getIndexForKey(key)] = node;
		}

	}

	protected int getIndexForKey(Object key) {
		return (int) Math.abs(key.hashCode() % hashtable.length);
	}

	protected LinkedListNode<K, V> getNodeForKey(Object key) {
		// TODO Auto-generated method stub
		int index = getIndexForKey(key);
		LinkedListNode<K, V> node = hashtable[index];
		return node == null ? null : node;
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

	// TODO Auto-generated method stub

	public void checkCapacity() {
		if (numberofElements >= loadFactor * currentCapcity || counter > 10) {
			rehash();
			counter = 0;
		}
	}

	public void rehash() {
		LinkedListNode<K, V> tempArray[] = new LinkedListNode[currentCapcity];
		for (int i = 0; i < currentCapcity; i++) {
			tempArray[i] = hashtable[i];
		}
		
		int previousCapacity = currentCapcity;


		currentCapcity = 2 * currentCapcity;
		hashtable = new LinkedListNode[currentCapcity];
		for (int key = 0; key < previousCapacity; key++) {
			LinkedListNode<K, V> node = tempArray[key];
			if (node != null) {
				numberofElements--;
				put(node.key, node.value);

			}
		}

	}

	protected int getPrime() {
		for (int i = currentCapcity - 1; i >= 1; i--) {
			int fact = 0;
			for (int j = 2; j <= (int) Math.sqrt(i); j++)
				if (i % j == 0)
					fact++;
			if (fact == 0)
				return i;
		}
		/* Return a prime number */
		return 3;
	}
	

	@Override
	public  void remove(Object key) {
		put((K) key, null);		
		numberofElements--;
	}

}
