package org.crackcode.ch3.prob3;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;
	
	public void SetOfStacks(int capacity){
		this.capacity = capacity;
	}
	
	// get the last element
	public Stack getLastStack() {
		if(stacks.size() == 0){
			return null;
		}
		return stacks.get(stacks.size()-1);
	}
	
//	public Stack getIndexStack(int index){
//	}
	public void push(int value){
		System.out.println("Push " + value);
		Stack<Integer> last = this.getLastStack();
		if(last != null && last.size() != capacity){
			last.push(value);
		}
		else{
			Stack newstack = new Stack();
			newstack.push(value);
			stacks.add(newstack);
		}
	}
	
	public int pop(){
		Stack<Integer> last = this.getLastStack();
		if (last.size() == 0){
//			System.out.println("empty stack");
			stacks.remove(stacks.size() - 1);
			last = this.getLastStack();
		}
		return last.pop();
	}
	
	public void rollOver(){
		for (int i = 0; i < stacks.size() - 1; i++){
			if (stacks.get(i).size() < capacity){
				stacks.get(i).push(stacks.get(i+1).firstElement());
				stacks.get(i+1).remove(0);
			}
		}
	}
	public int popAt(int index){
		Stack<Integer> indexStack = new Stack();
		indexStack = stacks.get(index / capacity);
		this.rollOver();
		return indexStack.pop();	
	}
}
