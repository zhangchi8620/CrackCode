package org.crackcode.ch3.prob1;

import java.util.EmptyStackException;

// Problem 3.1
// Method 1: fixed length for each stack
public class Array2Stack {
	static int stackSize = 2;
	static int[] buffer = new int[stackSize * 3];
	static int[] stackPointer = {-1, -1, -1};
	

	static void push(int stackNum, int value) throws Exception{
		System.out.println("Push " + value + " into Stack " + stackNum);
		if (stackPointer[stackNum] + 1 > stackSize)
			throw new FullStackException("Full Stack!");
		int newp = stackSize * stackNum + stackPointer[stackNum] + 1;
		buffer[newp] = value;
		stackPointer[stackNum]++;
	}

	
	static int pop(int stackNum) throws Exception{
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int newp = stackPointer[stackNum] + stackSize * stackNum;
		stackPointer[stackNum]--;
		int value = buffer[newp];
		buffer[newp] = 0;
		return value;
	}
	
	static int peek(int stackNum){
		if (isEmpty(stackNum))
			throw new EmptyStackException();
		int newp = stackNum * stackSize + stackPointer[stackNum];
		return buffer[newp];
	}
	
	static boolean isEmpty(int stackNum){
		return stackPointer[stackNum] == -1;
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
