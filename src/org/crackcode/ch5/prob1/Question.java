package org.crackcode.ch5.prob1;

public class Question {
	
	private static int insertBit(int a, int b, int i, int j) {
		// check bits
		if (i > j || j >= 32 || i < 0)
			return 0;
		
		// shift b
		int b1 = b << i;

		// clear i to j in a
		for (int t = i; t < j + 1; t++){
			a = a & ~(1 << t);
		}
//		System.out.println("a: " + Integer.toBinaryString(a));

		return a | b1;
	}
	
	public static void main(String[] args){
		int a = 103217;
		int b = 13;
		
		int i = 4;
		int j = 12;
		int c = insertBit(a, b, i, j);
		System.out.println("a: " + Integer.toBinaryString(a));
		System.out.println("b: " + Integer.toBinaryString(b));
		System.out.println("c: " + Integer.toBinaryString(c));
		System.out.println("c: " + c);

	}
}
