package BinaryTree;

public class FindClosestBST {
	
	public static int value = 0;
	public static int difMax = 0;

	public static int findClosestValueInBst(BST tree, int target) {
		// Write your code here.
		int difValue =  tree.value - target;
		if (difMax > difValue ) {
			 difMax = difValue;
			 value  = tree.value; 
		}
		
		if (target > tree.value) {
			findClosestValueInBst(tree.right,target);
		}else {
			findClosestValueInBst(tree.left,target);
		}
		
		return value;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}

}
