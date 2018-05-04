package org.dev.test;

import java.util.ArrayList;
import java.util.Random;

import org.dev.datastructures.DoubleHashing;
import org.dev.timer.Timer;

public class DoubleHashMapTest {

	public static void main(String[] args) {
		DoubleHashing<Integer, Integer> map = new DoubleHashing();
		ArrayList<Integer> array = null;

		for (int numberOfElements = 1; numberOfElements < 5000;) {
			Random rand = new Random(numberOfElements);
			long startTime = Timer.getUserTime();
			array = new ArrayList<>();
			for (int i = 0; i < numberOfElements; i++) {
				int element = Math.abs(rand.nextInt());
				map.put(element, element);
			}
			//map.remove(array.get(numberOfElements / 2));
			long endTime = Timer.getUserTime() - startTime;
			System.out.println(endTime);
			numberOfElements += 100;
		}
	}
}
