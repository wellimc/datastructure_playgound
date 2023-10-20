package BinaryTree;

import java.awt.color.ICC_ColorSpace;
/*
      -1
   -2      -4
 5    6   7   8

 */
public class MathOperationsTree {

    Node root;


    public static void main(String[] args) {
        MathOperationsTree tree = new MathOperationsTree();

        tree.insert(1);

        tree.insert(3);
        tree.insert(5);

        tree.insert(7);
        tree.insert(9);

        tree.insert(20);
        tree.insert(30);
        tree.print();
       System.out.println(tree.calc());
    }

    public MathOperationsTree(){
        root = null;
    }

    public int calc(){
        return  calcNode(this.root);
    }
    private int calcNode(Node node){

        if(node != null && node.left == null && node.right == null){
           return node.val;
        }

        int leftValue = calcNode(node.left);
        int rightValue = calcNode(node.right);


        if (node.val == -1){
            return leftValue + rightValue;
        } else if (node.val == -2) {
            return leftValue - rightValue;
        } else if (node.val == -3) {
            return Math.abs(leftValue / rightValue);
        }else if  (node.val == -4) {
            return leftValue * rightValue;
        }else{
            return  0;
        }

    }

    public void insert(int val){
        Node newItem = new Node(val);
        if(root == null){
            root =  newItem;
            return;
        }
        Node current = root;

        while (current != null) {
            if (val > current.val) {
                if (current.right == null) {
                    current.right = newItem;
                    return;
                }
                current = current.right;
            } else if (val < current.val) {
                if (current.left == null) {
                    current.left = newItem;
                    return;
                }
                current = current.left;
            } else {
                current.val = val;
                return;
            }
        }

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

    static class Node{
        int val;
        Node right;
        Node left;

        Node(int val){
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }


}

