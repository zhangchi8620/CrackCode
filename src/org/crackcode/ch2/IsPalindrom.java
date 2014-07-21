package org.crackcode.ch2;

import java.util.Stack;

import org.crackcode.library.LinkedListNode;

//http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
public class IsPalindrom {
//	public static boolean isPalindrom(LinkedListNode head){
//		LinkedListNode reverse = head;
//		LinkedListNode orig = head;
//		LinkedListNode end = head;
//		int len = 0;
//		while(end.next != null){
//			end = end.next;
//			len++;
//		}
//		int count = 0;
//		while(reverse != null && end != null){
//			reverse.data = end.data;
//			
//			reverse = end;
//		
//			LinkedListNode tmp = reverse;
//			tmp.next = null;
//			
//			head = next;
//			end.next = tmp;
//			end = end.next;
//
//			reverse = head;
//			count--;
//		}
//		
//		System.out.println("Reversed:\n" + head.printForward());
//		if (compareLink(head, orig))
//			return true;
//		else
//			return false;
//	}
	
	// Method 2: stack
	public static boolean isPalindrome2(LinkedListNode head){
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.next != null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// if odd # of nodes, skip the middle node
		if(fast != null){
			slow = slow.next;
		}
		
		while(slow != null){
			int top = stack.pop().intValue();
			if(top != slow.data)
				return false;
			slow = slow.next;
		}
		return true;
	}
	
	public static boolean compareLink(LinkedListNode n1, LinkedListNode n2){
		while(n1 != null && n2 != null){
			if (n1.data != n2.data){
				return false;
			}
			else{
				n1 = n1.next;
				n2 = n2.next;
			}
		}
		return true;
	}
	
	// TODO recurse method
	
	public static LinkedListNode createLinkedList(int[] val){
		LinkedListNode head = new LinkedListNode(val[0], null, null);
		LinkedListNode current = head;
		for(int i = 1; i < val.length; i++){
			current = new LinkedListNode(val[i], null, current);
		}
		return head;
	}
	
	public static void main(String[] args){
		int[] val = {1, 2, 3, 10 ,11, 10, 3, 2, 1}; 
		LinkedListNode head = createLinkedList(val);
		System.out.println("Orig link:\n" + head.printForward());
		System.out.println(isPalindrome2(head));
	}
}
