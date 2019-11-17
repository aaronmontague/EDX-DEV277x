package evals;

import java.util.ArrayList;
import java.util.Arrays;

public class Module1 {

	public static void main(String[] args) {
		System.out.println("Q10");
		ArrayList < Integer >  numbers = new ArrayList < Integer > ();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.remove(2);
		numbers.set(1, 0);
		numbers.add(5);
		numbers.remove(0);
		System.out.println(numbers);
		System.out.println("Q10-end");
		
		System.out.println("Q9");
		String[][] set2 = { { "Hello", "world!" }, { "world", "Hello " }, { "Hello", "!", "Hello" } };
		System.out.println(Arrays.toString(set2));
		System.out.println("Q9-end");
		
		System.out.println("Q8");
		int[] values = {1, 4, -7, -3};
		multiply(values, 2);
		System.out.println("Q8-end");

		System.out.println("Q7");
		String[][] set = { { "Hello", "world!" }, { "world", "Hello " }, { "Hello", "!", "Hello" } };
		String hello1 = set[0][1] + set[1][0];
		String hello2 = set[1][1] + set[0][1];
		String hello3 = set[1][1] + set[1][0] + set[2][1];

		System.out.println("Hello1: " + hello1);
		System.out.println("Hello2: " + hello2);
		System.out.println("Hello3: " + hello3);
		System.out.println("Q7-end");

		System.out.println("Q6");
		int[] array = new int[10];
		array[9] = 5;
		System.out.println("Q6-end");

		System.out.println("Q5");
		int[] nums = { 5, 3, 6, 8, 11, 2 };
		change(nums);
		System.out.println("Q5-end");

		System.out.println("Q3");
		int[] anArray = new int[4];
		anArray[0] = 4;
		anArray[1] = 6;
		anArray[2] = 7;
		anArray[3] = 3;
		for (int j = 0; j < anArray.length; j++) {
			System.out.print(anArray[j] + " ");
		}
		System.out.println("Q3-end");
		System.out.println("Q2");
		int[][] arr = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] % 2 == 0) {
					System.out.println(arr[i][j]);
				}
			}
		}
		System.out.println("Q1");
		int[][] q1Array = { { 44, 45, 16, 50 }, { 16, 12, 66, 9 }, { 52, 83, 3, 37 }, { 56, 61, 69, 61 } };
		twoDimensions(q1Array);
	}

	public static void multiply(int[] values, int amount) {
		for (int i = 0; i < values.length; i++) {
			values[i] = values[i] + amount;
			System.out.print(values[i] + " ");
		}
	}

	public static void change(int[] arr) {
		int k = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (k < arr[i]) {
				arr[0] = arr[i];
				arr[i] = k;
				k = arr[0];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void twoDimensions(int[][] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers[i].length - 1; j++) {
				if (numbers[i][j] < numbers[i][j + 1]) {
					numbers[i][j] = numbers[i][j] + numbers[i + 1][j];
					numbers[i + 1][j] = numbers[i + 1][j] / 2;
				}
				if (j == numbers[i].length - 2) {
					System.out.print(numbers[i][j] + "\n");
				} else {
					System.out.print(numbers[i][j] + " ");
				}
			}
		}
	}
}
