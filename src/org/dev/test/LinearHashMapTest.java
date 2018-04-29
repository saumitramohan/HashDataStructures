package org.dev.test;
import org.dev.datastructures.LinearHashing;

public class LinearHashMapTest {
	public static void main (String [] args) {
		LinearHashing <Integer, String> map = new LinearHashing<>(6);
		map.put(1, "Hello");
		map.put(2, "World");
		map.put(3, "*Test*");
		map.put(7, "Yolo");
		System.out.println(map.get(7));

	}
}
