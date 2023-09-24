package BinaryTree;

public class BSTFind {

	public static void main(String args[]) {

		BSTFind tree = new BSTFind();
		Node root = new Node(7);
		tree.insertNew(root, 3);
		tree.insertNew(root, 10);

		tree.insertNew(root, 1);
		tree.insertNew(root, 4);

		tree.insertNew(root, 9);
		tree.insertNew(root, 15);
		tree.printTree(root);

		System.out.println(tree.search(root, 3));

		tree.delete(root, 3);
		System.out.println(tree.search(root, 3));
		tree.printTree(root);

	}

	public void insert(Node root, int value) {

		if (value < root.value) {
			if (root.left == null) {
				System.out.println("  Inserted " + value + " to left of " + root.value);
				Node new_node = new Node(value);
				root.left = new_node;
			} else {
				insert(root.left, value);
			}
		} else {
			if (root.right == null) {
				System.out.println("  Inserted " + value + " to right of " + root.value);
				Node new_node = new Node(value);
				root.right = new_node;
			} else {
				insert(root.right, value);
			}
		}

	}

	public Node insertNew(Node root, int value) {

		if (root == null) {
			return new Node(value);
		}

		if (value < root.value) {
			System.out.println("  Inserted " + value + " to left of " + root.value);
			root.left = insertNew(root.left, value);

		} else if (value > root.value) {
			System.out.println("  Inserted " + value + " to right of " + root.value);
			root.right = insertNew(root.right, value);
		}

		return root;

	}

	public Node delete(Node root, int value) {

		if (root == null)
			return root;

		if (contains(root, value)) {
			if (value < root.value) {
				System.out.println("  Values " + value + " is in the left of root " + root.value);
				root.left = delete(root.left, value);
			} else if (value > root.value) {
				System.out.println("  Values " + value + " is in the right of root " + root.value);
				root.right = delete(root.right, value);
			} else {
				System.out.println("  Values " + value + " found");
				if (root.left == null && root.right == null) {
					System.out.println("deleting 1 with no child nodes populated " + root.value);
					return null;
				} else if (root.left != null && root.right == null) {
					System.out.println("deleting 2 with left node populated " + root.value);
					return root.left;

				} else if (root.left == null && root.right != null) {
					System.out.println("deleting 3 with right node populated" + root.value);

					return root.right;

				} else if (root.left != null && root.right != null) {
					System.out.println("deleting 4 with both child nodes populated " + root.value);
					Node smallest = getSmallest(root.right);
					root.value = smallest.value;
					root.right = delete(root.right, smallest.value);
					return root;

				}

			}
		}

		return root;

	}

	Node getSmallest(Node root) {

		Node curr = root;
		while (curr != null && curr.left != null) {
			curr = curr.left;
		}
		return curr;

	}

	public void printTree(Node root) {

		if (root.right != null) {
			printTree(root.right);
		}
		System.out.println(root.value);

		if (root.left != null) {
			printTree(root.left);
		}

	}

	public boolean contains(Node root, int value) {
		// Write your code here.
		if (root == null) {
			return false;
		}
		if (value < root.value) {
			return contains(root.left, value);
		} else if (value > root.value) {
			return contains(root.right, value);
		} else {
			return true;
		}

	}

	public Boolean search(Node root, int target) {

		if (root == null) {
			return false;
		}

		if (target < root.value) {
			return search(root.left, target);

		} else if (target > root.value) {
			return search(root.right, target);

		} else {

			return true;
		}

	}

	static class Node {

		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;

		}

	}

}
