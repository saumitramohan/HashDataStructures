package org.dev.test;

import java.util.ArrayList;
import java.util.Random;
import org.dev.datastructures.LinearHashing;
import org.dev.timer.Timer;

public class LinearHashMapTest {
	public static void main(String[] args) {
		LinearHashing<Integer, Integer> map = new LinearHashing();
		ArrayList<Integer> array = null;

		for (int numberOfElements = 1; numberOfElements < 1000;) {
			Random rand = new Random(numberOfElements);
			array = new ArrayList<>();
			//long startTime = Timer.getUserTime();
			for (int i = 0; i < numberOfElements; i++) {
				int element = Math.abs(rand.nextInt());
				//array.add(element);
				map.put(element, element);
			}
			//System.out.println(map.getCollions());
			//map.setCollions();
			double lf = numberOfElements/2000.00;
			System.out.println(lf);


			//map.put(10, 10);
			//map.get(array.get(numberOfElements / 2));
			//long endTime = Timer.getUserTime() - startTime;
			//System.out.println(endTime);
			numberOfElements += 100;
		}
	}
}
