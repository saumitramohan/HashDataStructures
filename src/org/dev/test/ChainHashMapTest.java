package org.dev.test;

import java.util.ArrayList;
import java.util.Random;

import org.dev.datastructures.ChainHashing;
import org.dev.timer.Timer;

public class ChainHashMapTest {

	public static void main(String[] args) {
		ChainHashing<Integer, Integer> map = new ChainHashing();
		ArrayList<Integer> array = null;
		for (int numberOfElements = 1; numberOfElements < 30000;) {
			Random rand = new Random(numberOfElements);
			array = new ArrayList<>();
			for (int i = 0; i < numberOfElements; i++) {
				int element = Math.abs(rand.nextInt());
				array.add(element);
				map.put(element, element);
			}
			
			long startTime = Timer.getUserTime();
			map.get(array.get(numberOfElements / 2));
			long endTime = Timer.getUserTime() - startTime;
			System.out.println(endTime);
			numberOfElements += 100;

		}
	}
}
