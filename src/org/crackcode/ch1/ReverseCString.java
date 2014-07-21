package org.crackcode.ch1;

public class ReverseCString {
	public static String reverseCString(String str){
		int len = str.length();
		String t = null;
		for (int  i = 0; i < len / 2 ; i++){
	        t = Character.toString(str.charAt(i));
	        StringBuilder sb = new StringBuilder(str);
	        sb.setCharAt(i, str.charAt(len -1 - i));
			sb.setCharAt(len-1-i, t.charAt(0));
	        str = sb.toString();
		}
		return str;
	}
	
	// main
	public static void main(String[] args){
		//ReverseCString testReverseCString = new ReverseCString();
		
		System.out.println(ReverseCString.reverseCString("abcdef\n"));
	}
}
