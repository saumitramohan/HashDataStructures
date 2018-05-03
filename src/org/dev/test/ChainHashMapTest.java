package org.dev.test;

import java.util.Random;

import org.dev.datastructures.ChainHashing;
import org.dev.timer.Timer;

public class ChainHashMapTest {

	public static void main(String[] args) {

		for (int numberOfElements = 1; numberOfElements < 40000;) {
			Random rand = new Random(numberOfElements);
			ChainHashing<Integer, Integer> map = new ChainHashing();
			long startTime = Timer.getUserTime();
			for (int i = 0; i < numberOfElements; i++) {
				int element = Math.abs(rand.nextInt());
				map.put(element, element);
			}
			long timeTaken = Timer.getUserTime() - startTime;
			System.out.print(numberOfElements + "    ");
			//System.out.print(timeTaken);
			System.out.println();
			numberOfElements += 100;

		}

	}
}
