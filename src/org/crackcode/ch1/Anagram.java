package org.crackcode.ch1;

import java.util.Arrays;

public class Anagram {

    public static boolean areAnagrams(String string1, String string2){
    	String cleanStr1 = removeJunk(string1);
    	String cleanStr2 = removeJunk(string2);
    	
    	cleanStr1 = sort(cleanStr1);
    	cleanStr2 = sort(cleanStr2);
    	
    	
		if (cleanStr1.equals(cleanStr2))
    		return true;
    	else
    		return false;
    }

    protected static String removeJunk(String string) {
    	StringBuilder sb = new StringBuilder(string);
    	
       for (int i = 0; i < sb.length(); i++){
    	   if(!Character.isLetter(string.charAt(i))){
    		   sb.deleteCharAt(i);
    	   } 	   
       }
       
       return sb.toString();
    }

    protected static String sort(String string) {
	    char[] cArr = string.toCharArray();
	    Arrays.sort(cArr);
	    //System.out.println(cArr.toString());
		return new String(cArr);
    }

    public static void main(String[] args) {
        String string1 = "Cosmo, !";
        String string2 = "cosmo, !";

        System.out.println();
        System.out.println("Testing whether the following "
                         + "strings are anagrams:");
        System.out.println("    String 1: " + string1);
        System.out.println("    String 2: " + string2);
        System.out.println("Result: \n");

        
        if (areAnagrams(string1, string2)) {
			System.out.println("are Anagrams");
		}
        else{
			System.out.println("are NOT Anagrams");

        }
        	
    }
}
