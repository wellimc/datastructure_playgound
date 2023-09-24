package LinkedList;

public class LinkedListTest {

	Node head = null;
	int size = 0;

	public static void main(String args[]) {
		
		LinkedListTest list = new LinkedListTest();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(5);
		list.insert(10);
		
		list.printList();
		
	}

	public void insert(int data) {

		Node new_node = new Node(data);

		if (head == null) {
			head = new_node;
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}

			last.next = new_node;
		}
		size++;

	}

	public void printList() {
		
		Node last = head;
		while(last != null) {
			System.out.println(last.value);
			last = last.next;
		}
		
	}

	static class Node {

		public int value;
		public Node next;

		Node(int value) {
			this.value = value;
			this.next = null;
		}

	}

}
