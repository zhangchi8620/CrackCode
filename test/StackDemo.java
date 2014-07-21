import java.util.EmptyStackException;
import java.util.Stack;

// http://www.tutorialspoint.com/java/java_stack_class.htm

public class StackDemo {
	static void showpush(Stack<Integer> st, int a){
		st.push(new Integer(a));
		System.out.println("push " + a);
		System.out.println("Stack: " + st);
	}
	
	static void showpop(Stack<Integer> st){
		Integer a = st.pop();
		System.out.println("pop " + a);
		System.out.println("Stack: " + st);
	}
	
	public static void main(String[] args){
		Stack<Integer> st = new Stack<Integer>();
		System.out.println("Stack: " + st);
		showpush(st, 41);
		showpush(st, 62);
		showpush(st, 99);
		System.out.println("Size of stack: " + st.size());

		try{
			System.out.println("Stack get: " + st.get(st.size()));

			showpop(st);
			showpop(st);
			showpop(st);
		}
		catch(EmptyStackException e){
			System.out.println("Empty stack");
		}
	}
}
