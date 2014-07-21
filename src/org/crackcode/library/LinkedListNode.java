package org.crackcode.library;

public class LinkedListNode {
	public int data;
	public LinkedListNode prev;
	public LinkedListNode next;
	
	public LinkedListNode(int d, LinkedListNode n, LinkedListNode p){
		data = d;
		setNext(n);
		setPrevious(p);
	}
	
	public LinkedListNode(){}
	
	public void setNext(LinkedListNode n){
		this.next = n;
		if(n != null && n.prev != this)
			n.setPrevious(this);
	}
	
	public void setPrevious(LinkedListNode p){
		this.prev = p;
		if (p != null && p.next != this)
			p.setNext(this);
	}
	
	public String printForward(){
		if (next != null)
			return data + "->" + next.printForward();
		else
			return ((Integer)data).toString();
	}
	
	public LinkedListNode clone(){
		LinkedListNode next2 = null;
		if (next != null){
			next2 = next.clone();
		}
		
		LinkedListNode head2 = new LinkedListNode(data, next2, null);
		
		return head2;
	}
	
}
