package Array.ArrayOthers.ArraySort;

import java.util.Arrays;

public class JavaSort {

    public static void main(String args[]){

        int[] arrayScrambled = new int[]{9,8,6,15,63,52,125,500,2};
        System.out.printf(Arrays.toString(arrayScrambled));
        Arrays.sort(arrayScrambled);
        System.out.println("\n");
        System.out.println(Arrays.toString(arrayScrambled));
     }


}
