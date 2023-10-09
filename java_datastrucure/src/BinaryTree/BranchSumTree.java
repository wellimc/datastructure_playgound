package BinaryTree;

import javax.crypto.NullCipher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*~*
https://codewrestling.medium.com/branch-sums-in-binary-tree-competitive-programming-with-time-and-space-complexity-4e066d36ce43
Write a function that takes in a Binary Tree and returns a list of its branch sums ordered from leftmost branch sum to rightmost branch sum.

A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree branch is a path of nodes in a tree
that starts at the root node and ends at any leaf node. Each BinaryTree node has an integer value, a left
 child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or None / null.

              1
       2             3
   4        5     6     7
 8   9   10

Sample Output:
[15, 16, 18, 10, 11]

// 15 == 1 + 2 + 4 + 8
// 16 == 1 + 2 + 4 + 9
// 18 == 1 + 2 + 5 + 10
// 10 == 1 + 3 + 6
// 11 == 1 + 3 + 7

 */
public class BranchSumTree {

    Node root;
    public static void main(String[] args) {

        BranchSumTree tree = new BranchSumTree();
        tree.insert(7);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(4);
        tree.insert(9);
        tree.insert(15);

        tree.printTree();
      //  tree.sumTree();
        tree.sumBranch();


    }

    BranchSumTree(){
        root = null;
    }

    public void sumTree(){
        System.out.println(sumNode(this.root));
    }

    public int sumNode(Node current){

        int sum = 0,leftSum = 0,rightSum =0;

        if( current == null){
            return 0;
        }

        if (current.left != null){
            leftSum = sumNode(current.left);
        }
        if (current.right!= null){
            rightSum = sumNode(current.right);
        }
        sum  = current.val + leftSum + rightSum;
        return sum;
    }


    private void insert(int val){
        Node newNode = new Node(val);
        if(root == null){
            root = newNode;
            return;
        }
        Node current = root;
        while ( current != null){
            if (val > current.val ) {
                if(current.right == null){
                    current.right = newNode;
                    return;
                }
                current = current.right;
            } else if (val < current.val) {
                if(current.left == null){
                    current.left = newNode;
                    return;
                }
                current = current.left;
            }else {
                current.val = val;
                return;
            }
        }
    }

    public void sumBranch(){
        List<Integer> results = new ArrayList<>();
        sumBranchNode(this.root,results,0);
        System.out.println(Arrays.toString(results.toArray()));
    }

    private void  sumBranchNode(Node node, List<Integer> results, int sum){
          if ( node == null){
             return;
          }

          int runningSum = sum + node.val;
          if(node.left == null && node.right == null){
              results.add(runningSum);
              System.out.println("added :"+runningSum);
              return;
          }

          sumBranchNode(node.left,results,runningSum);
          sumBranchNode(node.right,results,runningSum);

    }



    private void  printTree(){
        printElement(this.root);
    }

    public void printElement(Node node){
        if ( node == null){
            return;
        }

        System.out.println(node.val);
        printElement(node.left);
        printElement(node.right);
    }

    static  class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }
}

//        10
//    3        12
//  1   4   7      15


// total sum of nodes: 52
//Sum branches :
// Branch  1 : 10 + 3 + 1  = 14
// Branch 2 :  10+3+4 = 17
// Branch 3 : 10+12+7 = 29
//Branch 4 = 10+12+15 = 37



//        7
//    3        10
//  1   4    9     15
//B1 = 11
//B2 = 14
//B3 = 26
//B4 = 32