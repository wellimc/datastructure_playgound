package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class TreeNew {


    TreeNode root;

    TreeNew(){
        root = null;
    }

    public static void main(String[] args) {
        TreeNew  tree = new TreeNew();
       tree.insert(0,1);
        tree.insert(1,3);
        tree.insert(2,5);
        tree.insert(3,7);
        tree.insert(4,9);
        tree.insert(5,20);
        tree.insert(6,30);

  /**      tree.insertRecursiveMain(0,4);
        tree.insertRecursiveMain(1,3);
        tree.insertRecursiveMain(2,5);
        tree.insertRecursiveMain(3,2);
        tree.insertRecursiveMain(4,1);
        tree.insertRecursiveMain(5,6);
        tree.insertRecursiveMain(6,7);
        **/
      //  tree.insertRecursiveMain(4,9);
        tree.getInorderKeys();

        System.out.println(tree.get(5));
        System.out.println(tree.getMin());
        System.out.println(tree.getMax());
        tree.remove(1);
        tree.getInorderKeys();

    }


    public  void insert(int key, int val){
        TreeNode newNode = new TreeNode(key, val);
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode current = root;
        while(current != null){
            if ( key < current.key ) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else if (key > current.key ) {
                if (current.right== null) {
                    current.right= newNode;
                    return;
                }
                current = current.right;
            }else{
                current.value = val;
                return;
            }

        }

    }

    public void insertRecursiveMain(int key, int val) {
        if (root == null) {
            root = new TreeNode(key,val);;
            return;
        }
        this.insertRecursive(this.root, key, val);
    }
    public  void insertRecursive(TreeNode node,int key,  int value){
        if ( node.key < key){
            if (node.left != null) {
                insertRecursive(node.left,key,value);
            }else{
                node.left = new TreeNode(key,value);;
            }
        } else if (node.key > value) {
            if (node.right != null) {
                insertRecursive(node.right,key,value);
            }else{
                node.right = new TreeNode(key,value);;
            }
        }else{
            node.value = value;
        }
    }

    public int get(int key) {
        TreeNode current = root;
        while (current != null){
            if (current.key < key) {
                current = current.right;
            } else if (current.key > key) {
                current = current.left;
            }else{
                return current.value;
            }
        }

        return -1;
    }
    public int getMin() {
        TreeNode current = root;
        while(current!= null){
            if (current.left != null) {
                current = current.left;
            }else{
                return current.value;
            }
        }
        return -1;
    }

    public int getMin2() {
        TreeNode current = findMin(root);
        return (current != null) ? current.value : -1;
    }

    private TreeNode findMin(TreeNode node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getMax() {

        TreeNode current = root;
        while (current != null){
            if(current.right!= null){
                current = current.right;
            }else{
                return  current.value;
            }
        }
        return  -1;
    }

    public void printTree(){
        print(this.root);
    }

    public void print(TreeNode current){
        if ( current == null){
            return;
        }
        System.out.println("Current element key :"+current.key +" value :"+ current.value );
        print(current.left);
        print(current.right);

    }

    public void remove(int key) {
        root = removeRemoveItem(root,key);
    }

    public TreeNode removeRemoveItem(TreeNode current , int key) {
        if ( current == null){
            return null;
        }

        if ( key > current.key  ){
            current.right = removeRemoveItem(current.right,key);
        } else if (key < current.key ) {
            current.left = removeRemoveItem(current.left,key);
        }else{
                if(current.left == null){
                    return  current.right;
                } else if (current.right == null) {
                    return  current.left;
                }else{
                    TreeNode minNode= findMin(current.right);
                    current.key = minNode.key;
                    current.value = minNode.value;
                    current.right = removeRemoveItem(current.right,minNode.key);
                }
        }
        return current;

    }

    public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        printElementInOrder(root,result);
        return result;
    }

    private void printElementInOrder(TreeNode node, List<Integer> result ){
        if ( node == null){
            return;
        }
        printElementInOrder(node.left,result);
        System.out.println("Current element key :"+node.key +" value :"+ node.value );
        result.add(node.key);
        printElementInOrder(node.right,result);

    }


    static class TreeNode{

        int value;

        int key;
        TreeNode left;
        TreeNode right;

        TreeNode( int key, int value){
            this.value = value;
            this.key = key;
            this.left = null;
            this.right = null;

        }

        TreeNode( int key, int value,  TreeNode right, TreeNode left ){
            this.value = value;
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }
}

//       4
//   3      5
// 2  1   6    7