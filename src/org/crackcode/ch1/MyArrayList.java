package org.crackcode.ch1;

import java.util.ArrayList;

public class MyArrayList {
	String name;
	
	// constructor
	public MyArrayList(String name){
		this.name = name;
	}
	
	// method merge
	public ArrayList<String> merge(String[] words, String[] more){
		ArrayList<String> sentence = new ArrayList<String>();
		
		for(String w : words) sentence.add(w);
		for(String w : more) sentence.add(w);
		
		return sentence;
	}
	
	public static void main(String[] args){
		MyArrayList testArrayList = new MyArrayList("testArrayList");
		String[] w1 = args;
		//String[] w2 = {"Factory", "Garden"};

		System.out.println(testArrayList.merge(w1, w1).toString());
	}
}
