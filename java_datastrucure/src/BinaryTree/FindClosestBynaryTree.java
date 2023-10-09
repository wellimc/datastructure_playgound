package BinaryTree;

import javax.swing.plaf.IconUIResource;

/**
 *            10
 *        5         15
 *     2         13    14
 *  1    7                22
 *
 *
 * output = 13
 *
 * */

 public class FindClosestBynaryTree {

    Node root;


    public FindClosestBynaryTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        FindClosestBynaryTree tree = new FindClosestBynaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(13);
        tree.insert(22);
        tree.insert(14);
        tree.print();
        System.out.println(tree.findClosestValueInBst(12));

    }

    public void insert(int val) {

        Node newNode = new Node(val);
        if (this.root == null) {
               this.root = newNode;
        }
        Node  current =  this.root;
        while (current != null){

            if (val > current.val ) {
                if (current.right == null){
                    current.right = newNode;
                    return;
                }
                current = current.right;
            } else if (val < current.val) {
                if (current.left == null){
                    current.left = newNode;
                    return;
                }
                current = current.left;
            }else{
                current.val = val;
                return;
            }
        }
    }

    public int findClosestValueInBst( int target) {
        int maxDiff = Integer.MAX_VALUE;
        int value = 0;

        Node current = this.root;
        while (current != null){
            int dif = Math.abs(current.val - target);

            if (maxDiff > dif){
                maxDiff = dif;
                value = current.val;
            }

            if (target > current.val){
                  current = current.right;
            } else if (target < current.val) {
                 current  = current.left;
            }else{
                 return current.val;
            }
        }
        return value;
    }


    public void print(){
        printNode(this.root);
    }

    private void printNode(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        printNode(node.left);
        printNode(node.right);
    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
