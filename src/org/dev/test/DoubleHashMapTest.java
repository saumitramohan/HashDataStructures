package org.dev.test;
import org.dev.datastructures.DoubleHashing;

public class DoubleHashMapTest {

	public static void main(String[] args) {
		DoubleHashing <Integer, Integer> map = new DoubleHashing();
		for (int i = 0; i < 15; i++) {
			//int rand = (int) (Math.random() * ((100000 - 1) + 1)) + 1;
			map.put(i, i);
		}

		System.out.println(map.get(14));

	}
}
