package Stack;

public class JavaStackDemo {

	public static void main(String[] args) {

		Stack<Integer> intStack = new LinkedStack<Integer>();
		intStack.push(10);
		System.out.println("Stack after push 10: " + intStack);
		intStack.push(20);
		System.out.println("Stack after push 20: " + intStack);
		intStack.push(30);
		System.out.println("Stack after push 30: " + intStack);
		System.out.println("The top element is: " + intStack.peek() + " (not removed)");
		System.out.println("Stack after peek: " + intStack);
		System.out.println("Top element is: " + intStack.pop() + " (removed)");
		System.out.println("Stack after pop: " + intStack);
		System.out.println("Is stack empty? " + intStack.empty());
		System.out.println("Number of elements is " + intStack.size());
		


		System.out.println("Now testing Array Stack...");
		Stack<Integer> intStack2 = new ArrayStack<Integer>(10);
		intStack2.push(10);
		System.out.println("Stack after push 10: " + intStack2);
		intStack2.push(20);
		System.out.println("Stack after push 20: " + intStack2);
		intStack2.push(30);
		System.out.println("Stack after push 30: " + intStack2);
		System.out.println("The top element is: " + intStack2.peek() + " (not removed)");
		System.out.println("Stack after peek: " + intStack2);
		System.out.println("Top element is: " + intStack2.pop() + " (removed)");
		System.out.println("Stack after pop: " + intStack2);
		System.out.println("Is stack empty? " + intStack2.empty());
		System.out.println("Number of elements is " + intStack2.size());


	}

}
