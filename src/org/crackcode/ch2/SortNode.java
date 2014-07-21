package org.crackcode.ch2;

import org.crackcode.library.LinkedListNode;

// Problem 2.4
public class SortNode {
	// Method 1: my own. Move >= value to the end
	public static void sortNode(LinkedListNode head, int x){
		LinkedListNode runner = head;
		LinkedListNode end = head;
		int count = 0;
		while(end.next != null){
			end = end.next;
			count++;
		}

		while(runner != null && count != 1){
			LinkedListNode tmp = new LinkedListNode(runner.data, null, null);

			if (runner.data >= x){
				end.setNext(tmp); 
				end = tmp;
				//System.out.println("runner: " + runner.data);
				
				LinkedListNode next = runner.next;
				runner.data = next.data;
				runner.next = next.next;
				//System.out.println(head.printForward());
				count--;
			}
			
			else{	
				runner = runner.next;
			}
		}
	}
	
	// Method 2: Partition and merge
	public static LinkedListNode sortNode2(LinkedListNode node, int x){
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		// Partition
		while (node != null){
			LinkedListNode next = node.next;
			//System.out.println("data: " + node.data);
			node.next = null;
			
			if (node.data < x){
				if (beforeStart == null){
					beforeStart = node;
					beforeEnd = beforeStart;
				}
				else{
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}
			else{
				if (afterStart == null){
					afterStart = node;
					afterEnd = afterStart;
				}
				else{
					afterEnd.next = node;
					afterEnd = node;
				}
			}

			node = next;
		}
		// Merge
		if(beforeStart == null)
			return afterStart;
		
		beforeEnd.next = afterStart;
		return beforeStart;
		
	}
	public static void main(String[] args){
		int[] vals = {1,11,7,2,5,9,3,10};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for(int i = 1; i < vals.length; i++){
			current = new LinkedListNode(vals[i], null, current);
		}
		int x = 3;

		System.out.println("Orignial list:\n" + head.printForward());
		System.out.println("x: " + x);
		
		// Test method 1
		//sortNode(head, x);
		//System.out.println("Result:\n" + head.printForward());
		
		// Test method 2
		LinkedListNode result = sortNode2(head, x);
		System.out.println(result.printForward());
	}
}
