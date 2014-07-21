package org.crackcode.ch3.prob7;

public abstract class Animal {
	private int order;
	public String name;
	public Animal(String n){
		name = n;
	}
	
	public void setOrder(int n){
		order = n;
	}
	
	public int getOrder(){
		return order;
	}
	
	public boolean isOlderThan(Animal n){
		return this.order < n.getOrder();
	}
}
