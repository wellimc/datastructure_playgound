package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class SumNodes {

	public static void main(String[] args) {

		List<Integer> results = new ArrayList<Integer>();
		Node root = new Node(7);
		root.insert(root, 3);
		root.insert(root, 10);

		root.insert(root, 1);
		root.insert(root, 4);

		root.insert(root, 9);
		root.insert(root, 15);
		root.printTree(root);

		System.out.println(root.sumCalculation(root));
		root.sumCalculationPerBranch(root,0, results);

		System.out.println(results);

	}

	static class Node {

		public Node right = null;
		public Node left = null;
		public int value = 0;

		public Node(int value) {
			this.value = value;

		}

		public void insert(Node node, int value) {

			if (value < node.value) {
				if (node.left == null) {
					Node newNode = new Node(value);
					node.left = newNode;

				} else {
					insert(node.left, value);
				}

			} else if (value > node.value) {
				if (node.right == null) {
					Node newNode = new Node(value);
					node.right = newNode;

				} else {
					insert(node.right, value);
				}

			}

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

		public int sumCalculation(Node node) {

			int sumRight = 0;
			int sumLeft = 0;

			if (node == null) {
				return 0;
			} else {

				if (node.left != null) {
					sumLeft = sumCalculation(node.left);
				}

				if (node.right != null) {
					sumRight = sumCalculation(node.right);
				}

				return node.value + sumRight + sumLeft;

			}

		}

		public void sumCalculationPerBranch(Node node, int sum, List<Integer> results) {

			if (node == null) {
				return;
			}

			int runningSum = sum + node.value;
			if (node.left == null && node.right == null) {
				results.add(runningSum);
				return;
			}

			sumCalculationPerBranch(node.left, runningSum, results);
			sumCalculationPerBranch(node.right, runningSum, results);

		}
	}

}
