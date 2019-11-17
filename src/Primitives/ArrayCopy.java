package Primitives;

import java.util.Arrays;

public class ArrayCopy {
	public static void copyThis() {
		int[] a = new int[5];
		
		for (int i=0; i<a.length; i++) {
			a[i] = i+2;
		}
		System.out.println(Arrays.toString(a));
		changeArr(a);
		System.out.println(Arrays.toString(a));
		int[] b = Arrays.copyOf(a, a.length);
		int[] c = Arrays.copyOf(a, 7);
		b[0] = 12;
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		for (int i=0; i<c.length; i++) {
			if (c[i] == 0) {
				c[i] = 4;
			}
		}
		System.out.println(Arrays.toString(c));
		System.out.println();
	}
	
	public static void changeArr(int[] arrayToChange) {
		arrayToChange[2] = 134;
	}
}
