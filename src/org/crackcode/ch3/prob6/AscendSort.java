package org.crackcode.ch3.prob6;

import java.util.Random;
import java.util.Stack;

public class AscendSort {
	public static Stack<Integer> ascendSort(Stack<Integer> st){
		Stack<Integer> buffer = new Stack<Integer>();
		
		while(!st.isEmpty()){
			int tmp = st.pop();
			while(!buffer.isEmpty() && buffer.peek() > tmp)
				st.push(buffer.pop());
			buffer.push(tmp);
		}

		return buffer;
	}
	
	public static void main(String[] args){
		Stack<Integer> st = new Stack<Integer>();
		Random rn = new Random();

		for(int i = 0; i < 10; i++)
			st.push(rn.nextInt(10) + 1);

		System.out.println("Input: " + st.toString());
		
		System.out.println("Ascend Sorted: " + ascendSort(st).toString());
	}
}
