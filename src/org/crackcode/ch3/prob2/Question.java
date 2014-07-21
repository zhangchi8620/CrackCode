package org.crackcode.ch3.prob2;

import java.util.Random;

public class Question {
	public static void main(String[] args){
		Random generator = new Random(); 
		//StackWithMin st = new StackWithMin();
		StackWithMin st = new StackWithMin();
		
		for (int i = 0; i < 10; i++){
			int val = generator.nextInt(10) + 1;
			st.push(val);
			
			System.out.print(val + " ");
		}
		
		System.out.println();
		for(int i = 0; i < 10; i++){
			System.out.print("Poped" + st.pop().val + "\t");
			System.out.println("Min: " + st.min());
		}
	}

}