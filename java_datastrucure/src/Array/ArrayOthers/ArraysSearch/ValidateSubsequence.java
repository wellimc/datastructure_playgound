package Array.ArrayOthers.ArraysSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 Given two non-empty arrays of integers, our goal is to write a function that establishes whether the second array is a valid subsequence of the first array.
 A valid subsequence of an array is classified as a set of numbers that aren’t necessarily adjacent in the array but are in the same order as they appear in the array.

 For example, [2, 5, 6] and [2, 6] are both considered as valid subsequences of the array [2, 3, 4, 5, 6].
 It is also important to note that [2] and [2, 3, 4, 5, 6] are both valid subsequences of the array.

 Sample:

 Input array → [3, 6, 23, 7, 2, 4]

 Sequence → [3, 7, 4]

 Output → True

**/
public class ValidateSubsequence {

    /*test block command
    * */
    public static void main(String args[]){

        int[] array = new int[]{3, 6, 23, 7, 2, 4};
        int[] sequence = new int[]{3,7,4};
        System.out.println(isValidSubsequence(array,sequence));
   //     System.out.println(isValidSubsequenceWhile(array,sequence));
    //    System.out.println(isValidSubsequenceFor(array,sequence));
    }

    // time O(n)
    // space O(1)
    public static boolean isValidSubsequenceWhile(int[] array, int[] sequence){


        int arrayPointer = 0;
        int sequencePointer = 0;

        while (arrayPointer < array.length && sequencePointer < sequence.length){
            if (array[arrayPointer] == sequence[sequencePointer]){
                    sequencePointer++;
            }
            arrayPointer++;
        }
        System.out.println(sequencePointer);

        return  sequencePointer == sequence.length;

    }

    // brutal force
    // iterate through sequence array
    // iterate through array until find the next element
    // time O(n)
    // space O(n)
    public static boolean isValidSubsequence(int[] array, int[] sequence){

        int j = 0;
        List<Integer> result = new ArrayList<>();

        for (int k : array) {
            if ( j == sequence.length){
                break;
            }
            if (k == sequence[j]) {
                result.add(k);
                j++;
            }
        }
        System.out.println(Arrays.toString(sequence));
        System.out.println(result);

        return  sequence.length == result.size();

    }

    // brutal force
    // iterate through sequence array
    // iterate through array until find the next element
    // time O(n)
    // space O(1)
    public static boolean isValidSubsequenceFor(int[] array, int[] sequence){

        int j = 0;

        for (int k : array) {
            if (k == sequence[j]) {
                j++;
            }
        }
        System.out.println(Arrays.toString(sequence));
        System.out.println(j);

        return  sequence.length == j;

    }



}
