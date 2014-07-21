package org.crackcode.ch3.prob7;

// TODO learn "abstract" 
// http://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
public class Question {
	public static void main(String[] args) {

		AnimalQueue animals = new AnimalQueue();
		animals.enqueue(new Cat("Callie"));
		animals.enqueue(new Cat("Kiki"));
		animals.enqueue(new Dog("Fido"));
		animals.enqueue(new Dog("Dora"));
		animals.enqueue(new Cat("Kari"));
		animals.enqueue(new Dog("Dexter"));
		animals.enqueue(new Dog("Dobo"));
		animals.enqueue(new Cat("Copa"));
	
		System.out.println(animals.dequeueAny().name);	
		System.out.println(animals.dequeueAny().name);	
		System.out.println(animals.dequeueAny().name);	
	
		System.out.println(animals.dequeueDogs().name);
//		animals.enqueue(new Dog("Dapa"));
//		animals.enqueue(new Cat("Kilo"));
//	
//		while (animals.size() != 0) {
//			System.out.println(animals.dequeueAny().name);	
//		}
	}
}
