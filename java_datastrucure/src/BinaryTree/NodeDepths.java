package BinaryTree;

/**
 *         7
 *     3         10
 *  1    4    9     12
 */


public class NodeDepths {


    NodeTree root;


    public static void main(String[] args) {
        NodeDepths  tree = new NodeDepths();
        tree.insert(7);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(4);
        tree.insert(9);
        tree.insert(12);
        tree.print();
        System.out.println(tree.nodeDepthsnode());
    }

    public NodeDepths(){
        this.root = null;
    }

    public void  print(){
        printNode(this.root);
    }

    private void printNode(NodeTree node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        printNode(node.left);
        printNode(node.right);

    }

    public int  nodeDepthsnode() {
        return nodeDepthsPernode(this.root,0);
    }

    private int nodeDepthsPernode(NodeTree node , int depth){

        if (node == null){
            return 0;
        }

        return depth + nodeDepthsPernode(node.left,depth+1) + nodeDepthsPernode(node.right,depth+1);

    }

    public void  insert(int val){
        NodeTree newNode = new NodeTree(val);
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        NodeTree current = this.root;
        while(current != null){

            if(val > current.val){
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
            }else{
                current.val = val;
                return;
            }
        }
    }

    static class NodeTree {

        int val;
        int key;
        NodeTree left;
        NodeTree right;

        public  NodeTree(int val){
            this.left = null;
            this.right = null;
            this.val = val;

        }

    }
}
