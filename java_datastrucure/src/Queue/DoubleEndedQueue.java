package Queue;

/**
 * Design a Double-ended Queue class.
 * <p>
 * Your Deque class should support the following operations:
 * <p>
 * Deque() will initialize an empty queue.
 * bool isEmpty() will return whether the queue is empty or not.
 * void append(int value) will insert value at the end of the queue.
 * void appendleft(int val) will insert value at the beginning of the queue.
 * int pop() will remove and return the value at the end of the queue. If the queue is empty, return -1.
 * int popleft() will remove and return the value at the beginning of the queue. If the queue is empty, return -1.
 * Note: You should implement each operation in
 * �
 * (
 * 1
 * )
 * O(1) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["isEmpty", "append", 10, "isEmpty", "appendLeft", 20, "popLeft", "pop", "pop", "append", 30, "pop", "isEmpty"]
 * <p>
 * Output:
 * [true, null, false, null, 20, 10, -1, null, 30, true]
 */
public class DoubleEndedQueue {


    Node queueHead;
    Node queueEnd;
    int queueSize;

    public DoubleEndedQueue() {
        // dummy start and end nodes with -1 / -100
        queueHead = new Node(-1);
        queueEnd = new Node(-1);
        queueEnd.prev = queueHead;
        queueHead.next = queueEnd;
        queueSize = 0;
    }

    public boolean isEmpty() {
        return queueHead.next ==queueEnd;
    }


    // inset to the end;
    public void append(int value) {
        Node  newItem = new Node(value);
        newItem.prev = queueEnd.prev;
        newItem.next = queueEnd;
        queueEnd.prev.next = newItem;
        queueEnd.prev = newItem;
        queueSize++;
    }

    // insert in the beginning
    public void appendleft(int value) {
        Node newItem = new Node(value);

        newItem.next = queueHead.next;
        newItem.prev = queueHead;
        queueHead.next.prev = newItem;
        queueHead.next = newItem;
        queueSize++;

    }

    public int pop() {
        if(isEmpty()){
            return -1;
        }
        Node targetNode = this.queueEnd.prev;
        Node prevNode = targetNode.prev;
        int value = targetNode.value;

        queueEnd.prev = prevNode;
        prevNode.next = queueEnd;
        if (queueSize > 0) {
            queueSize--;
        }
        return value;
    }

    public int popleft() {
        if(isEmpty()){
            return -1;
        }
        Node targetNode = this.queueHead.next;
        Node nextNode = targetNode.next;
        int firstValue = targetNode.value;

        this.queueHead.next = nextNode;
        nextNode.prev = this.queueHead;

        if (queueSize > 0) {
            queueSize--;
        }

        return firstValue;
    }

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
        Node(int value,Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
