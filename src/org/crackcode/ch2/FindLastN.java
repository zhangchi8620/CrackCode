package org.crackcode.ch2;

import org.crackcode.library.LinkedListNode;

// Problem 2.2
public class FindLastN {
	public static LinkedListNode findLastN(LinkedListNode head, int n){
		if (head == null || n < 1)
			return null;
		LinkedListNode runner = new LinkedListNode();
		LinkedListNode tmp = head;
		int count = 0;
		while(tmp != null){
			tmp = tmp.next;
			count++;
			if (count == n){
				runner = head;
			}
			if (count > n ){
				runner = runner.next;
			}
		}
		if (count < n) {
			System.out.println("No result. String too small.");
			return null;
		}
		else
			return runner;
	}
	
	// Same method, more concise
	public static LinkedListNode findlastN2(LinkedListNode head, int n){
		if(head == null || n < 1)
			return null;
		
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		for(int j = 0; j < n - 1; ++j){
			if(p2 == null)
				return null;
			p2 = p2.next;
		}
		while (p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	public static void main(String[] args){
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		int n = 2;
		for (int i = 1; i < 10; i++) {
			//if (i>2 && i < 5)
			//	second = new LinkedListNode(2, null, null);
			//else
				second = new LinkedListNode(i % 5, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		
		System.out.println("Find " + n + " to last in Original link:\n" + head.printForward());
		
		// Method 1
		head = findLastN(head, n);
		System.out.println("Result:\n" + head.printForward());

		// Method 1 (concise)
		//head =findlastN2(head, n);
		//System.out.println("Result:\n" + head.printForward());

	}
}
