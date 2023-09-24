package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baseball {

	int stack[];
	private int top;
	private int capacity;

	public static void main(String[] args) {

		List<String> ops = new ArrayList<String>(Arrays.asList("5", "2", "C", "D", "+"));
		Baseball stack = new Baseball(ops.size());

		for (String item : ops) {

			if (item.equals("+")) {
				int val1 = stack.peek();
				stack.pop();
				int val2 = stack.peek();
				int totalVal = val1 + val2;
				stack.push(val1);
				stack.push(totalVal);
			} else if (item.equals("D")) {
				int doubleVal = stack.peek() * 2;
				stack.push(doubleVal);
			} else if (item.equals("C")) {
				stack.pop();
			} else {
				int value = Integer.parseInt(item);
				stack.push(value);

			}

		}

		int total = 0;
		while (!stack.isEmpty()) {

			total += stack.peek();
			stack.pop();
		}
		
		System.out.print(total);

	}

	Baseball(int size) {
		stack = new int[size];
		capacity = size;
		top = -1;
	}

	public void push(int value) {
		System.out.println("Inserting " + value);
		stack[++top] = value;

	}

	public int pop() {
		System.out.println("Removing " + peek());
		return stack[top--];
	}

	public int peek() {

		return stack[top];
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

}
