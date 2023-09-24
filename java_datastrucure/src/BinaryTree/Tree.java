package BinaryTree;

public class Tree {

	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = new Node(5);
		System.out.println("Binary Tree Example");
		System.out.println("Building tree with root value " + root.value);
		tree.insert(root, 2);
		tree.insert(root, 4);
		tree.insert(root, 8);
		tree.insert(root, 6);
		tree.insert(root, 7);
		tree.insert(root, 3);
		tree.insert(root, 9);
		System.out.println("Traversing tree in order");
		tree.traverseInOrder(root);
		// root.printTree();

	}

	public void insert(Node node, int value) {
		if (value < node.value) {
			if (node.left != null) {
				insert(node.left, value);
			} else {
				System.out.println(" Inserted " + value + " to left of " + node.value);
				node.left = new Node(value);
			}
		} else if (value > node.value) {
			if (node.right != null) {
				insert(node.right, value);
			} else {
				System.out.println("  Inserted " + value + " to right of " + node.value);
				node.right = new Node(value);
			}
		}
	}

	public void traverseInOrder(Node node) {
		if (node.left != null) {
			traverseInOrder(node.left);
		}

		System.out.print(" " + node.value);
		if (node.right != null) {
			traverseInOrder(node.right);
		}
	}

	/*
	 * public void insert(Node node, Integer value) {
	 * 
	 * if (node.value != null) { if (value < node.value) {
	 * 
	 * if (node.left == null) { System.out.println(" Inserted " + value +
	 * " to left of " + node.value); node.left = new Node(value); } else {
	 * insert(node.left,value); }
	 * 
	 * } else if (value > node.value) {
	 * 
	 * if (node.right == null) { System.out.println(" Inserted " + value +
	 * " to right of " + node.value); node.right = new Node(value); } else {
	 * insert(node.right,value); }
	 * 
	 * } else { node.value = value;
	 * 
	 * }
	 * 
	 * } }
	 */
	static class Node {

		public Integer value;
		public Node left;
		public Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public void printTree() {
			if (this.left != null) {
				this.left.printTree();
			}

			System.out.println(this.value);

			if (this.right != null) {
				this.right.printTree();
			}

		}

	}

}

//       4
//   3      5
// 2  1   6    7