package org.dev.test;
import org.dev.datastructures.CuckooHashing;

public class CuckooHashingTest {

	public static void main(String[] args) {
		CuckooHashing<Integer, String> map = new CuckooHashing<>(6);
		map.put(1, "Hello");
		map.put(2, "World");
		map.put(3, "*Test*");
		map.put(9, "*Nineth*");

		System.out.println(map.get(9));

	}
}
