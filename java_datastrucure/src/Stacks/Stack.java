package Stacks;

public class Stack {

	String stack[];
	private int top;
	private int capacity;

	public static void main(String[] args) {
		Stack stack = new Stack(3);

		stack.push("1"); // inserting 1 in the stack
		stack.push("2"); // inserting 2 in the stack

		stack.pop(); // removing the top element (2)
		stack.pop(); // removing the top element (1)

		stack.push("3"); // inserting 3 in the stack

		System.out.println("The top element is " + stack.peek());
		System.out.println("The stack size is " + stack.size());

		stack.pop(); // removing the top element (3)

		// check if the stack is empty
		if (stack.isEmpty()) {
			System.out.println("The stack is empty");
		} else {
			System.out.println("The stack is not empty");
		}
	}

	Stack(int size) {
		stack = new String[size];
		capacity = size;
		top = -1;
	}

	public void push(String value) {
	    System.out.println("Inserting " + value);
		stack[++top] = value;

	}

	public String pop() {
		System.out.println("Removing " + peek());
		return stack[top--];
	}

	public String peek() {

		return stack[top];
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

}
