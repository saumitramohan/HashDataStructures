package org.dev.datastructures.contract;
import org.dev.datastructures.LinkedListNode;

public abstract class HashDataStructureAbstract<K, V> implements HashDataStructure<K, V> {

	protected LinkedListNode<K, V> array[];

	protected static int numberofElements = 0;
	protected static int currentCapcity = initialCapacity;

	public void put(K key, V value) {
		LinkedListNode<K, V> node = getNodeForKey(key);
		if (node != null) {
			node.value = (V) value;
		} else {
			node = new LinkedListNode<K, V>(key, value);
			array[getIndexForKey(key)] = node;
		}

	}

	protected int getIndexForKey(Object key) {
		return (int) Math.abs(key.hashCode() % array.length);
	}

	protected LinkedListNode<K, V> getNodeForKey(Object key) {
		// TODO Auto-generated method stub
		int index = getIndexForKey(key);
		LinkedListNode<K, V> node = array[index];
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

	public void checkCapacity() {
		System.out.println("Current capacity" + 0.75 * currentCapcity);
		System.out.println("No. of elements" + numberofElements);
		if (numberofElements >= 0.75 * currentCapcity) {
			rehash();
		}
	}

	public void rehash() {
		System.out.println("Inside rehashing");
		System.out.println("Current capacity" + currentCapcity);
		LinkedListNode<K, V> tempArray[] = new LinkedListNode[currentCapcity];
		for (int i = 0; i < currentCapcity; i++) {
			tempArray[i] = array[i];
		}

		currentCapcity = 2 * currentCapcity;
		array = new LinkedListNode[currentCapcity];
		for (int key = 0; key < currentCapcity / 2; key++) {
			LinkedListNode<K, V> node = tempArray[key];
			if (node != null) {
				numberofElements--;
				put(node.key, node.value);

			}
		}

	}

}
