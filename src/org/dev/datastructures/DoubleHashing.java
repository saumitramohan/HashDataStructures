package org.dev.datastructures;

import org.dev.datastructures.contract.HashDataStructureAbstract;

public class DoubleHashing<K, V> extends HashDataStructureAbstract<K, V> {

	
	@Override
	public void remove(Object key) {
		// TODO Auto-generated method stub
		int index = getIndexForKey(key);
		hashtable[index] = null;
	}

	public DoubleHashing() {
		hashtable = new LinkedListNode[currentCapcity];
	}

	protected int getIndexForKey(Object key) {
		
		int hash1 = hashFunctionOne(key);
		int hash2 = hashFunctionTwo(key);

		while (hashtable[hash1] != null && !hashtable[hash1].key.equals(key)) {
			counter++;
			checkCapacity();
			hash1 += hash2;
			hash1 %= currentCapcity;
		}
		counter = 0;
		return hash1;
	}

	private int hashFunctionOne(Object key) {
		return (int) Math.abs(key.hashCode() % hashtable.length);
	}

	private int hashFunctionTwo(Object key) {
		return (int) Math.abs(getPrime() - key.hashCode() % getPrime());
	}
	
	

}
