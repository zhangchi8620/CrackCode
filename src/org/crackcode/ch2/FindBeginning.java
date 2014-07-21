package org.crackcode.ch2;

import java.util.HashSet;

import org.crackcode.library.LinkedListNode;

public class FindBeginning {
	
	// Method 1: fast / slow pointer
	public static LinkedListNode findBeginning(LinkedListNode head){
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow)
				break;
		}
		
		if(fast == null || slow == null)
			return null;
		
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}
	
	public static void printLoop(LinkedListNode n, int len){
		while (n != null && len != 0){
			System.out.printf("%d  ", n.data);
			n = n.next;
			len--;
		}
		System.out.println();
	}
	
	// Method 2: hashtable
	public static LinkedListNode findBeginning2(LinkedListNode n){
		HashSet<LinkedListNode> set = new HashSet<LinkedListNode>();
		while(n != null){
			if (set.contains(n))
				return n;
			else
				set.add(n);
			n = n.next;
		}
		return null;
	}
	
	public static void main(String[] args){
		int len = 10;
		int k = 4;
		
		LinkedListNode[] nodes = new LinkedListNode[len];
		for(int i = 0; i < len; i++){
			nodes[i] = new LinkedListNode(i%5, null, null);
		}
		for(int i = 0; i < len - 1; i++)
			nodes[i].setNext(nodes[i+1]);
		
		nodes[len-1].setNext(nodes[k]);
		printLoop(nodes[0], len * 2);
		
		LinkedListNode loop = findBeginning2(nodes[0]);
		System.out.println("Result:" + loop.data);
	}
}
