package org.crackcode.ch5.prob6;

// TODO print Integer to Binary with fixed digit number
public class Question {
	public static void main(String[] args){
		int num = 103217;

		System.out.println(num + "\n" + "0" + Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(swapOddEven(num)));
 	}

	private static int swapOddEven(int num) {
		return ((num & 0xaaaaaa) >> 1) | ((num & 0x555555) << 1);
	}
}
