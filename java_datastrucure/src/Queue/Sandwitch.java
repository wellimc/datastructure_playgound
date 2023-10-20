package Queue;

import java.util.Stack;

public class Sandwitch {


    Node head;
    Node tail;

     public  static int noteaten = 0;
    public  static  int  eat = 0;

    int size;


    public static void main(String[] args) {

        Sandwitch q = new Sandwitch();
        Stack<Integer> stack = new Stack<Integer>();


        int[] students = new int[]{1,1,0,0};
        int[] sandwiches = new int[]{0,1,0,1};
        int count = sandwiches.length;
        for(int i=0;i<students.length;i++){
            q.append(students[i]);
            stack.push(sandwiches[--count]);
        }
        q.print();
        System.out.println( q.getSize());
        System.out.println(" Stack print");

        int j = 0;
        while(true){
            System.out.println("sandwich -->"+stack.peek());
            q.print();
              if (q.getNext() == stack.peek()) {
                  q.popLeft();
                  stack.pop();
                  System.out.println(" matches");
                  eat++;
                  noteaten=0;
              }else{
                  q.append(q.popLeft());
                  System.out.println("not match");
                  q.print();
                  noteaten++;
              }
            System.out.println("--------------");
              if(noteaten == stack.size() ){
                  break;
              }
        }

        System.out.println(noteaten);
        System.out.println(eat);

    }

    Sandwitch(){
        this.head = new Node(-1);
        this.tail = new Node(-1);;
        this.head.next = this.tail;
        this.tail.prev = this.head;
        size = 0;
    }

    public boolean isEmpty(){
        return this.head.next == this.tail;
    }
    public int getSize(){
        return size;
    }

    public void append(int value){
        Node newItem = new Node(value);
        Node current = this.tail.prev;

        this.tail.prev = newItem;

        newItem.prev = current;
        newItem.next = this.tail;
        current.next = newItem;
        this.size++;

    }

    public void appendLeft(int value){
        Node newItem = new Node(value);
        Node current = this.head.next;
        this.head.next = newItem;
        newItem.next = current;
        newItem.prev = this.head;
        current.prev = newItem;
        this.size++;

    }

    public int pop(){
        if(this.isEmpty()){
            return  -1;
        }
        Node targetNode = this.tail.prev;
        Node prevNode = targetNode.prev;
        int value = targetNode.val;
        this.tail.prev = prevNode;
        prevNode.next = this.tail;
        size--;
        return value;
    }

    public int getNext(){
        if(this.isEmpty()){
            return  -1;
        }
        return head.next.val;
    }

    public int popLeft(){
        if(this.isEmpty()){
            return  -1;
        }
        Node targetNode = this.head.next;
        Node prevNode = targetNode.next;
        int value = targetNode.val;
        this.head.next = prevNode;
        prevNode.prev = this.head;
        size--;
        return value;
    }

     public void print(){
        System.out.print("QUEUE-->");
        Node current  = this.head;
        while(current != null){
            System.out.print(current.val+" - ");
            current = current.next;
        }
         System.out.println(" ");
     }



    static  class Node {

        int val;
        Node next;
        Node prev;

        public Node(int val ){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

}
