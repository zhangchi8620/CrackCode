package org.crackcode.ch3.prob5;

import java.util.Random;

public class Question {
	public static void main(String[] args){
		MyQueue<Integer> myqueue = new MyQueue<Integer>();
		Random rn = new Random();

		System.out.println("Input: ");
		for (int i = 0; i < 10; i++) {
			int answer = rn.nextInt(10) + 1;
			System.out.print(answer + " ");
			myqueue.enMyqueue(answer);
		}
		System.out.println();
		
		myqueue.deMyqueue();
		myqueue.deMyqueue();

		System.out.println(myqueue.peekMyqueue());

	}
}
