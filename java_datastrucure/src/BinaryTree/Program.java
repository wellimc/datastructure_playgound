package BinaryTree;

public class Program {

    public static void main(String[] args) {
        BST root = new BST(10);
        root.insert(5);
        root.insert(11);
        root.print();
        System.out.println(root.contains(5));
        System.out.println(root.contains(12));
        BST p_new=  root.remove(11);
        root.print();

    }
    static class BST {

        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST current = this;
            BST newItem = new BST(value);
            while(true) {

                if (value > current.value){
                    if(current.right == null){
                        current.right = newItem;
                        break;
                    }
                    current = current.right;
                }else if (value < current.value){
                    if(current.left == null){
                        current.left = newItem;
                        break;
                    }
                    current = current.left;

                }else{
                    current.value = value;
                }
            }
            return this;
        }

        public void print(){
            BST current= this;
            System.out.println("Current value :"+ current.value );
            printNode(current.left);
            printNode(current.right);

        }

        public void printNode(BST current){
            if ( current == null){
                return;
            }
            System.out.println("Current value :"+ current.value );
            printNode(current.left);
            printNode(current.right);

        }

        public boolean contains(int value) {

            BST current = this;
            while(current != null) {

                if (value > current.value){
                    current = current.right;
                }else if (value < current.value){
                    current = current.left;

                }else{
                    return true;
                }
            }
            return false;

        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST current = this;
            if (this.contains(value)){
                System.out.println("contains");
                current =  removeHelper(current,current,value);
            }
            return current;
        }


        public BST removeHelper(BST node , BST parent, int value) {

            if (node == null){
                System.out.println("null"+parent.value);
                return parent;
            }

            if(value < node.value){
                System.out.println("left");
                node.left = removeHelper(node.left,node,value);
            }else if(value > node.value){
                System.out.println("right");
                node.right = removeHelper(node.right,node,value);
            }else{
                 if (node.left == null ){
                     System.out.println("= right");
                     return node.right;
                }else if(node.right == null){
                     System.out.println("=  left");
                     return  node.left;
                }else{
                    BST minValue = getMinValue(node);
                     System.out.println("min value-->"+minValue.value);
                    node.value = minValue.value;
                    node.right = removeHelper(node.right,node,minValue.value);

                }
            }

            return node;

        }

        public BST getMinValue(BST root){
            BST current = root;
            while(current != null && current.left != null){
                current = current.left;
            }

            return current;
        }
    }
}
