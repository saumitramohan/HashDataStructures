package org.dev.test;

import org.dev.datastructures.LinearHashing;

public class LinearHashMapTest {
	public static void main(String[] args) {
		LinearHashing<Integer, Integer> map = new LinearHashing<>();

		for (int i = 0; i < 100; i++) {
			map.put(i, i);
		}

		System.out.println(map.get(89));

	}
}
