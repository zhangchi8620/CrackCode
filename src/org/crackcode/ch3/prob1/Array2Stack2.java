package org.crackcode.ch3.prob1;

public class Array2Stack2 {
	
	// TODO
	static int stackSize = 10;
	static int indexUsed = 0;
	static int[] stackPointer = {-1, -1, -1};

	static StackNode [] buffer = new StackNode[stackSize * 3];

	static void push(int stackNum, int value){
		int lastIndex = stackPointer[stackNum];
		
	}
	
	static int pop(int stackNum){
		return 0;
	}
	
	static int peek(int stackNum){
		return 0;
	}
	
	static boolean isEmpty(int stackNum) {
		return true;
	}	
	
	public static void main(String[] args) throws Exception {
//		System.out.println("Peek Stack 0: " + peek(0));
		push(0, 4);
		System.out.println("Peek Stack 0: " + peek(0));
		push(0, 3);
		push(0, 7);
		push(0, 5);
		System.out.println("Peek Stack 0: " + peek(0));
//		pop(0);
//		System.out.println("Peek Stack 0: " + peek(0));
//		pop(0);
//		System.out.println("Peek Stack 0: " + peek(0));
	}
}

class StackNode{
	public int previous;
	public int value;
	
	public StackNode(int p, int v){
		value = v;
		previous = p;
	}
}