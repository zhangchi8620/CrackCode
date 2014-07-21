package org.crackcode.ch3.prob4;

import java.util.Stack;

public class Tower extends Stack<Integer>{
	public void add(int disk){
		if (this.isEmpty()){
			System.out.println("Empty tower.");
			this.push(disk);
		}
		else if(!this.isEmpty() && this.peek() >= disk){
			System.out.println("Pushing " + disk + " into tower");
			this.push(disk);
		}
		else
			System.out.println("Error placing disk " + disk);
	}
	
	public void print(){
		if (!this.isEmpty()){
			for(int i = this.size() - 1; i >= 0; i--) {
				System.out.println(this.get(i));
			}
		}
		else
			System.out.println("Empty tower.");
	}
	public void moveDisks(int n, Tower destination, Tower buffer) {
		if(n > 0){
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n-1, destination, this);
		}
	}

	private void moveTopTo(Tower destination) {
		int top = this.pop();
		destination.push(top);
	}
	
}
