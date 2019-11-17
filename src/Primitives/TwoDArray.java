package Primitives;

import java.util.Arrays;
import java.util.Random;

public class TwoDArray {
	public static void make2DArray(int numberOfRows, int numberOfColumns) {
		// initialize array
		int [][] a = new int[numberOfRows][numberOfColumns];
		
		// create random generator
		Random rnd = new Random();
		
		// add 1-100 to each element in the array
		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < a[row].length; column++) {
				a[row][column] = rnd.nextInt(99) + 1;
			}
		}
		
		// display
		for (int row = 0; row < a.length; row++) {
			System.out.println(Arrays.toString(a[row]));
		}
	}
}
