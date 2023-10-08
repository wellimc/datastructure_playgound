package LinkedList;

import java.time.temporal.JulianFields;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an unsorted Linked List, the task is to remove duplicates from the list.
 * <p>
 * Examples:
 * <p>
 * Input: linked_list = 12 -> 11 -> 12 -> 21 -> 41 -> 43 -> 21
 * Output: 12 -> 11 -> 21 -> 41 -> 43
 * Explanation: Second occurrence of 12 and 21 are removed.
 * <p>
 * Input: linked_list = 12 -> 11 -> 12 -> 21 -> 41 -> 43 -> 21
 * Output: 12 -> 11 -> 21 -> 41 -> 43
 */
public class RemoveDuplicates2 {

    public static void main(String args[]) {
        int[] array = new int[]{
                10, 12, 11, 11, 12, 11, 10
        };

        LinkedList item1 = new LinkedList(10);
        LinkedList item2 = new LinkedList(12);
        LinkedList item3 = new LinkedList(13);
        LinkedList item4 = new LinkedList(13);
        LinkedList item5 = new LinkedList(14);
        LinkedList item6 = new LinkedList(14);
        LinkedList item7 = new LinkedList(15);

        item1.next = item2;
        item2.next = item3;
        item3.next = item4;
        item4.next = item5;
        item5.next = item6;
        item6.next = item7;

        //result 10,12,,11
        printList(item1);
        removeDuplicatesFromLinkedList(item1);
        System.out.println(" Duplicated removed");


    }

    //Brutal force

    public static void removeDuplicatesFromLinkedList(LinkedList head) {
        // Write your code here.
        LinkedList item = head;
        Map<Integer,LinkedList> items = new HashMap<>();
        items.put(item.value, item);

        while(item.next != null){
            if (item.value == item.next.value) {
                // delete
                System.out.println("Removed item" + item.next.value);
                item.next = item.next.next;
            } else {
                item = item.next;
            }
        }
        printList(head);
    }



    public static void   printList(LinkedList head){

        LinkedList item = head;
        while(item != null){
            System.out.print(item.value);
            System.out.println(" - ");
            item = item.next;
        }
    }


    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }


}
