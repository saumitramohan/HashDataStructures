package org.dev.test;

import java.util.Random;

import org.dev.datastructures.CuckooHashing;

public class CuckooHashingTest {

	public static void main(String[] args) {
		CuckooHashing<Integer, Integer> map = new CuckooHashing();
		for (int i = 0; i < 100000; i++) {
			int rand = (int) (Math.random() * ((100000 - 1) + 1)) + 1;
			map.put(rand, rand);
		}

		System.out.println(map.get(3));

	}
}
