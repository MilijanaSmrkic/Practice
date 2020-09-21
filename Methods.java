package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Methods {

	public static int[] array = { 8, 6, 1, 5, 3, 9, 2 };

	public static void sort() {

		for (int i = 0; i < array.length; i++) {
			int position = i;
			int min = array[i];

			for (int j = i; j < array.length; j++) {
				if (array[j] < min) {
					position = j;
					min = array[j];
				}
			}

			int temp = array[i];
			array[i] = array[position];
			array[position] = temp;
		}
		System.out.println(Arrays.toString(array));

	}

	public static void prime() {

		for (int i = 0; i < array.length; i++) {

			boolean isPrime = true;

			if (array[i] == 1)
				isPrime = false;
			else {

				for (int j = 2; j <= array[i] / 2; j++) {
					if (array[i] % j == 0) {
						isPrime = false;
						break;
						// krece od 2 jer 1 nije prost broj pa sledeci koji treba da
						// proveri je dva (nije klasicno i= 0,1,2 vec se gleda
						// vrednost elemenata niza )
					}
				}
			}

			if (isPrime)
				System.out.println(array[i] + " is a prime number in the array ");
		}
	}

	public static HashMap<Integer, Boolean> toMap() {

		HashMap<Integer, Boolean> hmap = new HashMap<Integer, Boolean>();

		ArrayList<Integer> alist = new ArrayList<>();
		alist.add(0, 8);
		alist.add(1, 6);
		alist.add(2, 1);
		alist.add(3, 5);
		alist.add(4, 3);
		alist.add(5, 9);
		alist.add(6, 2);

		for (Integer i : alist) {
			hmap.put(i, i % 2 == 0);
			System.out.println(i);
			System.out.println(i % 2 == 0);
		}

		return hmap;
	}

	public static void main(String[] args) {

		sort();
		prime();
		toMap();

	}

}
