package org.crackcode.ch3.prob4;

public class Question {
	
	
	public static void main(String[] args){
		int n = 5;
		Tower[] towers = new Tower[3];  
		for (int i=0; i< 3; i++)  
			  towers[i] = new Tower();  

		for(int i = n - 1; i >= 0; i--){
			towers[0].add(i);
		}
		for(int i = 0; i < 3; i++){
			System.out.println("Tower " + i);
			towers[i].print();
		}
		
		towers[0].moveDisks(n, towers[2], towers[1]);
		
		for(int i = 0; i < 3; i++){
			System.out.println("Tower " + i);
			towers[i].print();
		}
	}
}
