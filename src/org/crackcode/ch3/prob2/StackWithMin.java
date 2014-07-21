package org.crackcode.ch3.prob2;

import java.util.Stack;

// Method 1: each node has keeps track of the min beneath itself
public class StackWithMin extends Stack<NodeWithMin>{
	public void push(int value){
		int newmin = Math.min(value, min());
		super.push(new NodeWithMin(value, newmin));
	}

	public int min(){
		if (this.empty())
			return Integer.MAX_VALUE;
		else
			return peek().min;
	}
}
