package BinaryTree;

import java.util.List;

public class TreeMap {


    Node root ;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        Node newNode = new Node(val,key);
        if(root == null){
              root = newNode;
              return;
        };

        Node current = root;
        while (true){
            if (key < current.key){
                if ( current.left == null){
                    current.left = newNode;
                    return;
                }
                current = current.left;
            }else if(key > current.key){
                if ( current.right == null){
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }else {
                current.value = val;
                return;
            }
        }

    }

    public int get(int key) {
        Node current = root;
        while (current != null){
            if (key < current.key){
                current = current.left;
               // if
            }else if(key > current.key){
                current = current.right;
            }else {
                return current.value;
            }
        }
        return -1;
    }

    public int getMin() {
        return 0;
    }

    public int getMax() {
        return 0;
    }

    public void remove(int key) {

    }

    public List<Integer> getInorderKeys() {

        return null;
    }


    static  class Node{

        int value;
         int key;
        Node left;
        Node right;

        Node(int value,int key, Node left,Node right) {
            this.value = value;
            this.value = key;
            this.left = left;
            this.right= right;
        }

        Node(int value , int key){
            this.value = value;
            this.key = key;
            this.left = null;
            this.right= null;
        }

    }
}


//       4
//   3      5
// 2  1   6    7