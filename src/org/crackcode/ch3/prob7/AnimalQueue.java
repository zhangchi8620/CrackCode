package org.crackcode.ch3.prob7;

import java.util.LinkedList;

public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	
	private int order = 0;
	
	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Dog){
			dogs.add((Dog) a);
		}
		else if(a instanceof Cat){
			cats.add((Cat) a);
		}
	}
	
	public Animal dequeueAny(){
		if(dogs.isEmpty())
			return cats.poll();
		else if(cats.isEmpty())
			return dogs.poll();
		
		if (dogs.peek().getOrder() < cats.peek().getOrder())
			return dogs.poll();
		else
			return cats.poll();
	}
	
	public Animal peek(){
		if(dogs.isEmpty())
			return cats.peek();
		else if(cats.isEmpty())
			return dogs.peek();
		
		if (dogs.peek().getOrder() < cats.peek().getOrder())
			return dogs.peek();
		else
			return cats.peek();
	}

	public int size() {
		return dogs.size() + cats.size();
	}
	

	public Dog dequeueDogs() {
		return dogs.poll();
	}

	public Dog peekDogs() {
		return dogs.peek();
	}

	public Cat dequeueCats() {
		return cats.poll();
	}

	public Cat peekCats() {
		return cats.peek();
	}
}
