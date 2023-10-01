package Array.ArrayOthers.ArrayTypes;

import java.util.Arrays;

public class DynamicArray {

    int[] dynamicArray;
    int capacity;

    int index;
    public DynamicArray(int capacity) {
        if(capacity>0) {
            dynamicArray = new int[capacity];
            this.capacity = capacity;
            index=0;
        }
    }

    public int get(int i) {
        return dynamicArray[i];
    }

    public void insert(int i, int n) {
        if (capacity == 0){
            resize();
        }
        dynamicArray[i] = n;
    }

    public void pushback(int n) {
        if (capacity == index){
            resize();
        }
        dynamicArray[index]=n;
        index++;
        //swap

    }

    public int popback() {
        if (index >0){
            index--;
        }
        return   dynamicArray[index];

    }

    private void resize() {
        capacity = capacity*2;
        dynamicArray =  Arrays.copyOf(dynamicArray,capacity);
    }

    public int getSize() {
        return index;
    }

    public int getCapacity() {
        return capacity;
    }

    public static void main(String args[]){
        DynamicArray array = new DynamicArray(3);
        array.pushback(1);
        array.pushback(2);
      //  array.pushback(3);

        System.out.println(array.get(0));
        System.out.println(array.get(1));
     //   System.out.println(array.get(2));

      //  System.out.println(array.getSize());
      //  System.out.println(array.getCapacity());
    }

}
