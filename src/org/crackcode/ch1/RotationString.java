package org.crackcode.ch1;

public class RotationString {
	public static boolean rotationString(String str1, String str2){
		String newstr = str1.concat(str1);
		System.out.println(newstr);
		if (newstr.contains(str2))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args){
		String str1 = "waterbottle";
		String str2 = "erbottlewat";
		System.out.println(rotationString(str1, str2));
	}
}
