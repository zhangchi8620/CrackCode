package org.crackcode.ch2;

import java.util.HashSet;
import java.util.Hashtable;

import org.crackcode.library.LinkedListNode;

// Problem 2.1
public class RemoveDuplicates {
	
	// Method 1: Hash table
	public static void removeDuplicates1(LinkedListNode n){
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		LinkedListNode previous = null;
		while(n != null){
			// Important!! containsKey
			if (table.containsKey(n.data)){
				previous.next = n.next;
			}
			else{
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}
	
	// Method 2: Hash set, very similar to method 1
	public static LinkedListNode removeDuplicates2(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
		return n;
	}
	
	// Method 3: Without a temporary buffer.
	public static void removeDuplicates3(LinkedListNode head){
		// TODO Rewrite Method 3
		if (head == null) return;
		
		LinkedListNode current = head;
		
		while(current != null){
			//System.out.println("new current: " + current.data);
			LinkedListNode runner = current;
			while (runner.next != null){
				if (runner.next.data == current.data){
					//System.out.println("current data: " + current.data + "  runner data:"+runner.next.data);
					runner.next = runner.next.next;
				}
				else
					runner = runner.next;
			}
			current = current.next;
		}
	}
	
	public static void main(String[] args){
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 10; i++) {
			if (i>2 && i < 5)
				second = new LinkedListNode(2, null, null);
			else
				second = new LinkedListNode(i % 5, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		
		LinkedListNode last = new LinkedListNode(3, null ,null);
		LinkedListNode tmp = head;
		while(tmp.next != null)
			tmp = tmp.next;
		tmp.setNext(last);
		last.setPrevious(tmp);
		
		LinkedListNode clone = head.clone();
		LinkedListNode clone2 = head.clone();

		System.out.println("Method 1 ---\nOriginal link:\n" + head.printForward());
		removeDuplicates1(head);
		System.out.println("Removed Dup:\n" + head.printForward());
		
		System.out.println("Method 2 ---\nOriginal link:\n" + clone.printForward());
		removeDuplicates2(clone);
		System.out.println("Removed Dup link:\n" + clone.printForward());

		System.out.println("Method 3 ---\nOriginal link:\n" + clone2.printForward());
		removeDuplicates3(clone2);
		System.out.println("Removed Dup link:\n" + clone2.printForward());
		
	}
}
