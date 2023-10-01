package LinkedList;

import java.util.ArrayList;

public class DesignLinkedList {

    Node head = null;
    Node tail = null;

    public DesignLinkedList() {
        this.head = new Node(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        int i = 0;
        Node item = head.next;
        while (item != null){
            if (i == index){
                return  item.value;
            }
            i++;
            item = item.next;
        }
        return  -1;
    }

    public void insertHead(int val) {
        Node item = new Node(val);
        item.next = head.next;
        head.next = item;
        if ( item.next == null){
            tail = item;
        }

    }

    public void insertTail(int val) {
        Node item = new Node(val);
        this.tail.next = item;
        this.tail = this.tail.next;

    }

    public boolean remove(int index) {
        int i = 0;
        Node item = head;

        while (i < index && item != null){
            i++;
            item = item.next;
        }

        // Remove the node ahead of curr
        if (item != null && item.next != null) {
            if (item.next == this.tail) {
                this.tail = item;
            }
            item.next = item.next.next;
            return true;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        int i = 0;
        Node item = head.next;
        ArrayList<Integer> items = new ArrayList<>();

        while (item != null){
            items.add(item.value);
            item = item.next;
        }
        return items;
    }

    public static void main(String args[]) {

        DesignLinkedList list = new DesignLinkedList();
        list.insertHead(1);
        list.insertHead(2);
        list.insertTail(4);

        list.printList();

    }

    public void printList() {

        Node last = head;
        while(last != null) {
            System.out.println(last.value);
            last = last.next;
        }

    }

    static  class Node{
        int value;
        Node next;

        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

        Node(int value){
            this.value = value;
            this.next =null;
        }

    }
}
