package org.dev.test;

import org.dev.datastructures.ChainHashMap;

public class ChainHashMapTest {

	public static void main (String [] args) {
		ChainHashMap<Integer, String> map = new ChainHashMap<>(2);
		map.put(1, "Hello");
		map.put(2, "World");
		map.put(3, "*Test*");
		map.put(3, "Test");
		System.out.print( map.get(3));

	}
}
