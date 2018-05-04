package org.dev.test;

import java.util.ArrayList;
import java.util.Random;
import org.dev.datastructures.CuckooHashing;
import org.dev.timer.Timer;

public class CuckooHashingTest {

	public static void main(String[] args) {
		CuckooHashing<Integer, Integer> map = new CuckooHashing();
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
			map.put(20,20);
			long endTime = Timer.getUserTime() - startTime;
			System.out.println(endTime);
			numberOfElements += 100;
		}
	}
}
