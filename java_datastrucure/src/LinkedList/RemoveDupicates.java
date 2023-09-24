package LinkedList;

public class RemoveDupicates {

	public static void main(String args[]) {
		RemoveDupicates obj = new RemoveDupicates();

		Node list = new Node(1);
		list.insert(2);
		list.insert(2);
		list.insert(3);
		list.insert(5);
		list.insert(5);
		list.insert(5);
		list.insert(10);
		list.printList();
		removeDuplicatesFromLinkedList(list.head);
		list.printList();

	}

	public static Node removeDuplicatesFromLinkedList(Node head) {

		Node last = head;
		while (last.next != null) {

			if (last.value == last.next.value) {
				// delete
				System.out.println("Removed item" + last.next.value);
				last.next = last.next.next;

			} else {
				last = last.next;
			}

		}

		// Write your code here.
		return head;
	}

	public static class Node {
		public int value;
		public Node next;
		Node head = null;
		int size = 0;

		public Node(int value) {
			this.value = value;
			this.next = null;
			this.head = this;
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

				last = new_node;
			}
			size++;

		}

		public void printList() {

			Node last = head;
			while (last != null) {
				System.out.println(last.value);
				last = last.next;
			}

		}
	}

}
