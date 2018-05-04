package org.dev.datastructures;

import java.util.ArrayList;

import org.dev.datastructures.contract.HashDataStructure;
import org.dev.datastructures.contract.HashDataStructureAbstract;

public class CuckooHashing<K, V> extends HashDataStructureAbstract<K, V> implements HashDataStructure<K, V> {

	public LinkedListNode<K, V> arrayOne[] = null;
	public LinkedListNode<K, V> arrayTwo[] = null;

	@Override
	public void put(Object key, Object value) {

		numberofElements++;
		// System.out.println("Counter value :: " + counter);
		checkCapacity();
		// TODO Auto-generated method stub
		if (_getFromTableOne(key) == null) {
			int index = retrieveIndexFromTableOne(key);
			arrayOne[index] = new LinkedListNode<>(key, value);

		} else if (_getFromTableOne(key) != null && _getFromTableTwo(key) == null) {
			LinkedListNode tempNode = (LinkedListNode) _getFromTableOne(key);
			arrayTwo[retrieveIndexFromTableTwo(key)] = tempNode;
			arrayOne[retrieveIndexFromTableOne(key)] = new LinkedListNode<>(key, value);
		} else if (_getFromTableOne(key) != null && _getFromTableTwo(key) != null) {
			LinkedListNode tempNode = (LinkedListNode<K, V>) _getFromTableOne(key);
			arrayOne[retrieveIndexFromTableOne(key)] = new LinkedListNode<>(key, value);
			LinkedListNode tempNode2 = (LinkedListNode) _getFromTableTwo(key);
			arrayTwo[retrieveIndexFromTableTwo(key)] = new LinkedListNode<>(tempNode.key, tempNode.value);
			counter++;
			put(tempNode2.key, tempNode2.value);
		}
		// counter = 0;
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
		return arrayOne[index];
	}

	private LinkedListNode<K, V> _getFromTableTwo(Object key) {
		return arrayOne[retrieveIndexFromTableTwo(key)];
	}

	private int retrieveIndexFromTableOne(Object key) {
		// System.out.println("HashCode"+key.hashCode());
		// System.out.println("Number : "+ key.hashCode() % arrayOne.length);
		return (int) Math.abs(key.hashCode() % arrayOne.length);
	}

	private int retrieveIndexFromTableTwo(Object key) {
		return (int) Math.abs(((key.hashCode() / arrayTwo.length) % arrayTwo.length));
	}

	@Override
	public void remove(Object key) {
		// TODO Auto-generated method stub
		if (key != null) {
			Object object = _getFromTableOne(key);
			if (object != null) {
				arrayOne[retrieveIndexFromTableOne(key)] = null;
			} else {
				arrayTwo[retrieveIndexFromTableTwo(key)] = null;
			}
		}

	}

	public CuckooHashing() {
		arrayOne = new LinkedListNode[currentCapcity];
		arrayTwo = new LinkedListNode[currentCapcity];
	}

	public void rehash() {
		// System.out.println("Rehashed" + currentCapcity);

		LinkedListNode<K, V> tempArray1[] = new LinkedListNode[currentCapcity];
		LinkedListNode<K, V> tempArray2[] = new LinkedListNode[currentCapcity];

		for (int i = 0; i < currentCapcity; i++) {
			tempArray1[i] = arrayOne[i];
			tempArray2[i] = arrayTwo[i];
		}

		int previousCapacity = currentCapcity;
		currentCapcity = 2 * currentCapcity;

		arrayOne = new LinkedListNode[currentCapcity];
		arrayTwo = new LinkedListNode[currentCapcity];

		for (int key = 0; key < previousCapacity; key++) {
			LinkedListNode<K, V> node = tempArray1[key];
			if (node != null) {
				numberofElements--;
				put(node.key, node.value);

			}
		}

		for (int key = 0; key < previousCapacity; key++) {
			LinkedListNode<K, V> node = tempArray2[key];
			if (node != null) {
				numberofElements--;
				put(node.key, node.value);

			}
		}

	}
}
