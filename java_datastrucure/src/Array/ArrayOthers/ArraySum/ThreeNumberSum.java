package Array.ArrayOthers.ArraySum;

import java.util.*;

/**
 * Given an array of integers, find all triplets in the array that sum up to a given target value.
 *
 * In other words, given an array arr and a target value target, return all triplets a, b, c such that a + b + c = target.
 * Example:
 *
 * Input array: [7, 12, 3, 1, 2, -6, 5, -8, 6]
 * Target sum: 0
 *
 * Output: [[2, -8, 6], [3, 5, -8], [1, -6, 5]]
 *
 * none of the numbers are repeated
 */
public class ThreeNumberSum {

    public static  void main(String args []){
      //  int[] array = new int[] {7, 12, 3, 1, 2, -6, 5, -8, 6}; target 10 // 7 + 2 + 1
        int[] array = new int[] {12, 3, 1, 2, -6, 5, -8, 6}; //  target 0
        int targetSum = 0;
    //    System.out.println(Arrays.toString(threeSum(array, targetSum)));
    //    System.out.println(Arrays.toString(threeSumMap(array, targetSum)));
          List<Integer[]> list = threeSumOpt(array, targetSum);
        for(Integer[] arrayElement:list) {
            for(Integer item:arrayElement) {
                System.out.print(item);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    //brute force
    private static int[] threeSum(int[] array, int targetSum ){

        for (int i=0;i< array.length;i++){
            for(int j=i+1;j<array.length;j++){
                for(int k = j+1;k<array.length;k++){
                    if (array[i] + array[j] + array[k] == targetSum){
                        return new int[]{i,j,k};
                    }
                }
            }

        }
        return new int[]{};
    }

    //using the same strategy of TwoSum
    // Issues : Double loop and  unnecessary space consume
    // main issue: duplicate triples for example : [-8,2,6] and [2,6,-8]
    private static int[] threeSumMap(int[] array, int targetSum ){
        Map<Integer,Integer> complements = new HashMap<>();
        for (int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++) {
                int diff = targetSum - (array[i]+array[j]);
                if (complements.containsKey(diff)) {
                    return new int[]{array[i], array[j],array[complements.get(diff)]};
                } else {
                    complements.put(array[i], i);
                    complements.put(array[j], j);
                }
            }

        }
        return new int[]{};

    }


    //optimized  way withou hash table
    // sort the array
    // use right and left pointer
    //  int[] {-8, -6, 1, 2, 3, 5, 6,12};
    // current position = -8
    // left pointer = -6
    // right pointer = 12
    // time = O(N2)
    // space = O(N)
    private static List threeSumOpt(int[] array, int targetSum ){

        Arrays.sort(array);

        int current = 0;
        int leftPointer = 1;
        int rightPointer = array.length-1;
        int sum = 0;
        List<Integer[]> result = new ArrayList<>();
        while(current<array.length-1) {
            while (leftPointer < rightPointer) {
                sum = array[current] + array[leftPointer] + array[rightPointer];
                if (sum == targetSum) {
                    result.add(new Integer[]{array[current],array[leftPointer],array[rightPointer]});
                  //  System.out.println(array[current]+","+array[leftPointer]+","+array[rightPointer]);
                    leftPointer++;
                    rightPointer--;
                } else {
                    if (sum > targetSum) {
                        rightPointer--;
                    } else {
                        leftPointer++;
                    }
                }
            }

            current++;
            leftPointer = current+1;
            rightPointer = array.length-1;
        }
        return result;

    }

}
