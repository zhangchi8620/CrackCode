package org.crackcode.ch3.prob5;

import java.util.Stack;

public class MyQueue<T>{
	Stack<T> stackNew, stackOld;
	
	// constructor
	public MyQueue(){
		stackNew = new Stack<T>();
		stackOld = new Stack<T>();
	}
	
	public void shiftStacks(){
		if(this.stackOld.isEmpty()){
			while (!this.stackNew.isEmpty()){
				this.stackOld.push(this.stackNew.pop());
			}
		}
	}
	
	public void enMyqueue(T value){
		this.stackNew.push(value);
	}
	
	public T peekMyqueue(){
		shiftStacks();
		//System.out.print("Peek: ");
		return this.stackOld.peek();
	}
	
	public T deMyqueue(){
		shiftStacks();
		return this.stackOld.pop();
	}
}
