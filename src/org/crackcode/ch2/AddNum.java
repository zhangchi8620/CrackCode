package org.crackcode.ch2;

import org.crackcode.library.LinkedListNode;

// Problem 2.5
public class AddNum {
	
	// Method 1: equal length, reverse lists
	public static LinkedListNode addNum(LinkedListNode n1, LinkedListNode n2){
		LinkedListNode head = new LinkedListNode();
		LinkedListNode result = head;
		int tmp = 0;
		
		while (n1 != null && n2 != null){
			LinkedListNode next = new LinkedListNode(tmp, null, null);
			int sum = n1.data + n2.data;
			result.data = sum % 10 + tmp;

			tmp = sum / 10;
			if (n1.next != null)
				result.next = next;
			else
				result.next = null;

			n1 = n1.next;
			n2 = n2.next;
			result = result.next;
		}
		
		return head;
	}
	
	public static int list2int(LinkedListNode n){
		int value = 0;
		if(n.next != null)
			value = 10 * list2int(n.next);
		return value + n.data;
	}
	public static LinkedListNode createLinkedList(int[] val){
		LinkedListNode head = new LinkedListNode(val[0], null, null);
		LinkedListNode current = head;
		for(int i = 1; i < val.length; i++){
			current = new LinkedListNode(val[i], null, current);
		}
		return head;
	}
	
	
	// TODO Method 2: unequal length, reverse lists
	// Method 3: forward order lists
	public static LinkedListNode addNum3(LinkedListNode n1, LinkedListNode n2){
		LinkedListNode head = new LinkedListNode(0, null, null);
		LinkedListNode result = head;
		while(n1 != null && n2 != null){
			int sum = n1.data + n2.data;
			result.data += sum % 10;
			LinkedListNode next = new LinkedListNode(sum / 10, null, null);
			

			if (n1.next != null)
				result.next= next;
			else
				result.next = null;
			
			result = result.next;
			n1 = n1.next;
			n2 = n2.next;
		}
		
		return head;
	}
	
	public static void main(String[] args){
		int[] val1 = {7, 1, 6};
		int[] val2 = {5, 9, 2}; 
		LinkedListNode n1 = createLinkedList(val1);
		LinkedListNode n2 = createLinkedList(val2);
		//System.out.println(n1.printForward());
		//System.out.println(n2.printForward());
		
		//LinkedListNode result = addNum(n1, n2);
		LinkedListNode result = addNum3(n1, n2);
		System.out.println(result.printForward() + "\t" + list2int(result));
	}
}
