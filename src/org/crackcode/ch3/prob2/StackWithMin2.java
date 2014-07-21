package org.crackcode.ch3.prob2;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer>{
	Stack<Integer> sMin = new Stack<Integer>();

	public void push(int value){
		super.push(value);
		if(value < min()){
			sMin.push(value);
		}
	}
	
	public Integer pop(){
		int value = super.pop();
		if (value == sMin.peek())
			sMin.pop();
		
		return value;
	}
	
	public int min(){
		if (sMin.isEmpty())
			return Integer.MAX_VALUE;
		else
			return sMin.peek();
	}
}
