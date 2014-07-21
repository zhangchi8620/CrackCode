package org.crackcode.ch3.prob3;

public class Question {
	public static void main(String[] args){
		int size_per_stack = 4;
		SetOfStacks set = new SetOfStacks();
		set.capacity = size_per_stack;
		
		for(int i = 1; i < 9; i++)
			set.push(i);
//		for(int i = 1; i < 2; i++)
//			System.out.println("Popped " + set.pop());
		
		System.out.println("Popped At " + 2 + ": " + set.popAt(2));
		System.out.println("Popped At " + 2 + ": " + set.popAt(2));
		System.out.println("Popped At " + 2 + ": " + set.popAt(2));
		System.out.println("Popped At " + 2 + ": " + set.popAt(2));
		System.out.println("Popped At " + 2 + ": " + set.popAt(2));

	}
}
