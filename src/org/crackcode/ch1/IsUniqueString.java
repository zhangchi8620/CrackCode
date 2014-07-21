package org.crackcode.ch1;

public class IsUniqueString {
	// Solution 1: 256 array to keep record, O(n) time complexity and 
	// O(n) space complexity
	public static boolean isUniqueChars2(String str){
		boolean[] char_set = new boolean[256];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val]= true;
		}
		return true;
	}
	
	// Solution 2: bit vector, O(n) time and O(1) space
	public static boolean isUniqueChars(String str){
		int checker = 0;
		for(int i = 0; i < str.length(); ++i){
			int var = str.charAt(i) - 'a';
			if ((checker & (1 << var)) > 0) return false;
			checker |= (1 << var);
		}
		return true;
	}
	
	// Solution 3: check every char of string with every other 
	//	char of the string, O(n^2)
	
	// Solution 4: sort and compare neighboring char, O(nlogn) 
	// for sorting, may take extra space for sorting
	
	// main
	public static void main(String[] args){
		if (IsUniqueString.isUniqueChars2("abcdeefg")){
			System.out.println("is unique");
		} else {
			System.out.println("not unique");
		}
		
		if (IsUniqueString.isUniqueChars("abcdzefg")){
			System.out.println("is unique");
		} else {
			System.out.println("not unique");
		}
	}
}
