package org.dev.test;

import java.util.Random;

import org.dev.datastructures.ChainHashMap;

public class ChainHashMapTest {

	public static void main (String [] args) {
		ChainHashMap<Integer, Integer> map = new ChainHashMap();
		for (int i = 0; i < 1000; i++) {
			Random rand = new Random(1000);
			map.put(rand, rand);
			System.out.println("Value :: "+ map.get(rand));

		}



	}
}
