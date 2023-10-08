package BinaryTree;

import java.util.ArrayList;
import java.util.List;

// Binary Search Tree Node
class TreeNodeNeet {
    int key;
    int val;
    TreeNodeNeet left;
    TreeNodeNeet right;

    public TreeNodeNeet(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// Implementation for Binary Search Tree Map
class TreeMapNeet {
    private TreeNodeNeet root;

    public TreeMapNeet() {
        root = null;
    }

    public static void main(String[] args) {
        TreeMapNeet tree = new TreeMapNeet();
        tree.insert(0,1);
        tree.insert(1,3);
        tree.insert(2,5);
        tree.insert(3,7);
        tree.insert(4,9);
        tree.insert(5,20);
        tree.insert(6,30);
        tree.printTree();
        System.out.println(tree.get(3));
        System.out.println(tree.getMin());
        System.out.println(tree.getMax());
        tree.remove(2);
        tree.printTree();
    }

    public void insert(int key, int val) {
        TreeNodeNeet newNode = new TreeNodeNeet(key, val);
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNodeNeet current = root;
        while (true) {
            if (key < current.key) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else if (key > current.key) {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            } else {
                current.val = val;
                return;
            }
        }
    }

    public int get(int key) {
        TreeNodeNeet current = root;
        while (current != null) {
            if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else {
                return current.val;
            }
        }
        return -1;
    }

    public void printTree(){
        print(this.root);
    }

    public void print(TreeNodeNeet current){
        if ( current == null){
            return;
        }
        System.out.println("Current element key :"+current.key +" value :"+ current.val );
        print(current.left);
        print(current.right);

    }

    public int getMin() {
        TreeNodeNeet current = findMin(root);
        return (current != null) ? current.val : -1;
    }

    private TreeNodeNeet findMin(TreeNodeNeet node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getMax() {
        TreeNodeNeet current = root;
        while (current != null && current.right != null) {
            current = current.right;
        }
        return (current != null) ? current.val : -1;
    }

    public void remove(int key) {
        root = removeHelper(root, key);
    }

    private TreeNodeNeet removeHelper(TreeNodeNeet curr, int key) {
        if (curr == null) {
            return null;
        }

        if (key > curr.key) {
            curr.right = removeHelper(curr.right, key);
        } else if (key < curr.key) {
            curr.left = removeHelper(curr.left, key);
        } else {
            if (curr.left == null) {
                // Replace curr with right child
                return curr.right;
            } else if (curr.right == null) {
                // Replace curr with left child
                return curr.left;
            } else {
                // Swap curr with inorder successor
                TreeNodeNeet minNode = findMin(curr.right);
                curr.key = minNode.key;
                curr.val = minNode.val;
                curr.right = removeHelper(curr.right, minNode.key);
            }
        }
        return curr;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNodeNeet root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.key);
            inorderTraversal(root.right, result);
        }
    }
}