package org.crackcode.ch5.prob2;

public class Question {
	private static String convertDem(double num) {
		if (num >= 1 | num <0){
			System.out.println("out of range");
			return null;
		}

		String result=".";
		while (num != 0){
			double tmp = num * 2;

			int bit = tmp >= 1 ? 1 : 0;
			result += String.valueOf(bit);
			num = tmp - (double)bit;
		}
		
		if (result.length() > 32){
			return "ERROR";
		}
			
		return result;
	}
	
	public static void main(String[] args){
		double num = 0.72;
		String result = convertDem(num);
		System.out.println("result: " + result);
	}


}
