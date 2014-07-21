package org.crackcode.ch5.prob5;

public class Question {
	public static void main(String[] args){
		int n1 = 23432;
		int n2 = 512132;
		System.out.println(n1 + "\t" + Integer.toBinaryString(n1));
		System.out.println(n2 + "\t" + Integer.toBinaryString(n2));

		System.out.println(getDiff(n1, n2));
		System.out.println(getDiff2(n1, n2));
		System.out.println(bitSwapRequired2(n1, n2));

	}

	private static int getDiff(int n1, int n2) {
		int count = 0;
		int tmp = n1 ^ n2;
		char[] str = Integer.toBinaryString(tmp).toCharArray();
		for (int i = 0; i < str.length; i ++){
			if (str[i] == '1')
				count ++;
		}
		return count;
	}
	
	private static int getDiff2(int n1, int n2){
		int count = 0;
		for(int c = n1 ^ n2; c != 0; c = c >> 1){
			count += c & 1;
		}
		
		return count;
	}
	
	public static int bitSwapRequired2(int a, int b){
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c-1)) {
			// n & (n -1) clear the first "1" from rightmost
//			System.out.println(Integer.toBinaryString(c));
			count++;
		}
		return count;
	}
}
