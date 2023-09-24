package Queue;

import java.util.LinkedList;
import java.util.Stack;

public class Queue {

	public Node tail = null;
	public Node head = null;
	public int size = 0;
	public static int notServed = 0;

	public static void main(String args[]) {

		//int[] students = { 1, 1, 0, 0 }; //scenario ok output = 0
		//int[] sandwiches = { 0, 1, 0, 1 };//scenario ok output = 0
		
		int[] students =  {1,1,1,0,0,1};
		int[] sandwiches = {1,0,0,0,1,1};

		
		
		Stack<Integer> sand_stack = new Stack<Integer>();
		Queue queue = new Queue();
		int j = 0;
		for (int i = sandwiches.length - 1; i >= 0; i--) {
			sand_stack.push(sandwiches[i]);
			queue.insert(students[j++]);

		}

		System.out.println("Sandwitches on the Stack-->" + sand_stack.size());
		System.out.println("Students on the queue-->" + queue.size);

		//queue.printQueue();

		while (!sand_stack.isEmpty()) {

			int current_sandwitch = sand_stack.peek();
			System.out.println("Current Sandwitch-->" + current_sandwitch);
			System.out.println("Current Student-->" + queue.head.value);
			Node current_student = queue.head;

			if (current_sandwitch == current_student.value) {
				sand_stack.pop();
				queue.dequeue();
				System.out.println("Student left the queue");
				queue.printQueue();
				notServed = 0;

			} else {
				System.out.println("Student left the queue and join again");
				Node item = queue.dequeue();
				queue.equeue(item);
				notServed++;
				queue.printQueue();
			}
			
			
			if (notServed > queue.size ){
				break;
			}

		}
		
		System.out.println("Students remaining-->"+queue.size);
		System.out.println("Sandwitches remaining-->"+sand_stack.size());

	}

	public void insert(int value) {

		Node new_node = new Node(value);
		if (head == null) {
			head = new_node;
			tail = new_node;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}

			current.next = new_node;
			tail = current.next;
		}
		size++;

	}

	public void equeue(Node node) {

		tail.next = node;
		tail = node;
		tail.next = null;
		size++;

	}

	public Node dequeue() {

		Node temp = head;
		if (size == 1) {
			head.next = null;
		} else {
			head = head.next;
		}

		size--;
		return temp;

	}

	public void printQueue() {

		Node current = this.head;
		System.out.print("QUEUE-->");
		while (current != null) {
			System.out.print("-" + current.value);
			current = current.next;
		}

		System.out.println(" ");

	}

	public static class Node {

		int value;
		Node next;

		Node(int value) {
			this.value = value;
			this.next = null;
		}

	}
	
	 public int countStudents(int[] students, int[] sandwiches) {

	        Stack sandwitchesq = new Stack<Integer>();
	        LinkedList<Integer> studentsq = new LinkedList<Integer>();
	        int j=0;
	        int notServed = 0;
	        for (int i=0;i<students.length;i++){
	             sandwitchesq.push(sandwiches[i]);
	              studentsq.add(j++);
	        }


	        while(!sandwitchesq.isEmpty()){
	            Integer current_sandwitche =  (Integer) sandwitchesq.peek();
	            Integer current_student = (Integer)studentsq.peek(); 
	            
	            if (current_sandwitche == current_student ){
	                sandwitchesq.pop();
	                studentsq.remove();
	                notServed = 0;
	            }else{
	                 
	                 studentsq.poll();
	                 studentsq.offer(current_student);
	                 notServed++;
	            }

	            if(notServed >= studentsq.size()){
	                break;
	            }
	        }

	        return studentsq.size();
	        
	    }

}
