package Queue;

public class QueueNew {


    Node head;
    Node tail;

    int size;


    public static void main(String[] args) {

        QueueNew q = new QueueNew();
        System.out.println(q.isEmpty());
        q.append(10);
        q.appendLeft(20);
        q.print();
        System.out.println("POP LEFT-->"+q.popLeft());
        System.out.println(q.isEmpty());
        q.print();
        System.out.println("POP-->"+q.pop());
        q.print();
        System.out.println("POP-->"+q.pop());
        System.out.println(q.isEmpty());
        q.append(30);
        q.print();
        q.pop();
        System.out.println(q.isEmpty());

    }

    QueueNew(){
        this.head = new Node(-1);
        this.tail = new Node(-1);;
        this.head.next = this.tail;
        this.tail.prev = this.head;
        size = 0;
    }

    public boolean isEmpty(){
        return this.head.next == this.tail;
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
