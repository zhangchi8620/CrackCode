package org.crackcode.ch1;

public class ReplaceSpace {
	
	 // My own method, require a new copy of string, different from the book P100
	 public static void main(String[] args) {
	        String str = "Fred F. Flintstone";
	        str.replace(" ", "%20");
	        System.out.println(str.replace(" ", "%20"));
	        System.out.println(replaceSpace(str.toCharArray()));
	    }
	 
	 // Book method, 1) calculate new length, 2) replace reversely
	 // Doesn't require additional space, in place
	 public static char[] replaceSpace(char[] str){
		 // TODO
		 return str;
	 }
}
