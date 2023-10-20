package Hash;

public class HashTable {



    Node[] hashtable;
    int capacity;
    int size;

    public HashTable(int capacity) {
        hashtable = new Node[capacity];
        size = 0;
        this.capacity = capacity;
    }


    public static void main(String[] args) {
        HashTable hash = new HashTable(2);
        System.out.println("Capacity --> "+hash.getCapacity());
        hash.insert(6,7);
        System.out.println("Capacity --> "+hash.getCapacity());
        hash.insert(1,2);
        System.out.println("Capacity --> "+hash.getCapacity());
        hash.insert(3,4);
        System.out.println(hash.get(0));
        System.out.println(hash.get(1));
        System.out.println(hash.get(2));
        System.out.println(hash.get(3));
        System.out.println(hash.remove(3));
        System.out.println(hash.get(3));
    }

    public void insert(int key, int value) {
          int index = hashFunction(key);
          Node node = this.hashtable[index];

          if ( node == null){
              this.hashtable[index] = new Node(key,value);
              this.size++;
          }else{
              //collision
              Node prev = null;
              while (node != null){
                  if(node.key == key){
                      node.val = value;
                      return;
                  }
                  prev = node;
                  node = node.next;
              }

              prev.next = new Node(key,value);
              this.size++;


          }

        if ((double) this.size / this.capacity >= 0.5) {
            this.resize();
        }
    }

    private int hashFunction(int key) {
        return key % this.capacity;
    }

    public void resize() {
        int newCapacity = this.capacity * 2;
        Node[] newTable = new Node[newCapacity];

        for (Node node : this.hashtable) {
            while (node != null) {
                int index = node.key % newCapacity;
                if (newTable[index] == null) {
                    newTable[index] = new Node(node.key, node.val);
                } else {
                    Node newNode = newTable[index];
                    while (newNode.next != null) {
                        newNode = newNode.next;
                    }
                    newNode.next = new Node(node.key, node.val);
                }
                node = node.next;
            }
        }
        this.capacity = newCapacity;
        this.hashtable = newTable;
    }

    public int get(int key) {
        int index = this.hashFunction(key);
        Node node = this.hashtable[index];
        while(node != null){
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public boolean remove(int key) {

        int index = this.hashFunction(key);
        Node node = hashtable[index];
        Node prev = null;

        while (node != null) {
            if (node.key == key) {
                if (prev != null) {
                    prev.next = node.next;
                } else {
                    this.hashtable[index] = node.next;
                }

                this.size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    public int getSize() {
        return  this.size;
    }

    public  int getCapacity() {
        return this.capacity;
    }

    private static class Node{
        int key;
        int val;
        Node next;

        public Node(int key,int  val){
         this.key = key;
         this.val  = val;
         this.next = null;
        }
    }
}
