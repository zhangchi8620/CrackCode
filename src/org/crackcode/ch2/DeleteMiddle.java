package org.crackcode.ch2;

import org.crackcode.library.LinkedListNode;

// Problem 2.3
public class DeleteMiddle {
	
	// Wrong! Look at the problem carefully!! "Given only access to that node"
	public static void deleteMiddle(LinkedListNode head){
		LinkedListNode runner = head.next;
		LinkedListNode n = head;
		int count = 0;
		while(runner != null){
			count++;
			n = n.next;
			runner = runner.next.next;
		}
		System.out.println(n.data);

		n = head;
		while(count != 1){
			n = n.next;
			count--;
		}
		n.next = n.next.next;
	}
	
	// Correct solution
	public static boolean deleteNode(LinkedListNode n){
		if(n == null || n.next == null)
			return false;
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
	
	public static void main(String[] args){
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		
		for (int i = 1; i < 9; i++) {
//			if (i>2 && i < 5)
//				second = new LinkedListNode(2, null, null);
//			else
				second = new LinkedListNode(i % 4, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println("Original link:\n" + head.printForward());
		deleteMiddle(head);
		System.out.println("Deleted Middle:\n" + head.printForward());

	}
}
