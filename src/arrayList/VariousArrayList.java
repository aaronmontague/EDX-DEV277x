package arrayList;

import java.util.ArrayList;
import java.util.Random;

public class VariousArrayList {
	public static void makeArrayList() {
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		// add 5-15 values
		Random rnd = new Random();
		for (int i = 0; i < rnd.nextInt(10) + 5; i++) {
			primeList.add(rnd.nextInt(100));
		}
		
		for (int number : primeList) {
			System.out.print(number + " ");
		}
		System.out.println();
		
		// String ArrayList
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("Eggs");
		myList.add("Eggs2");
		System.out.println("size: " + myList.size());
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
			myList.remove(i);
		}
	}
}
