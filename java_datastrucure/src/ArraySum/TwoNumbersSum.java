package ArraySum;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers nums and an integer target,
 return indices of the two numbers such that they add up to
 We need to return the indices of these two integers as an array.

 For example, suppose we have the following array of integers:

 [2, 7, 11, 15]

 If the target value is 9, then the two integers that add up to the target value are 2 and 7. Their indices in the array are 0 and 1, respectively. Therefore, the function should return the following array:

 [0, 1]
 **/
public class TwoNumbersSum {
     public static  void main(String[] args){
        int[]   numbers = new int[]{ 2,7,11,15 };
        int[] result = twoNumberSumBruteOptimized(numbers,9);
        System.out.println(Arrays.toString(result));

    }

     // brute force
     // 2 for loops
     // o log N
    public static int[] twoNumberSumBruteForce(int[] array, int targetSum) {
        int[] result = new int[2];
        for(int i = 0; array.length >= i; i++){
             for(int j=i+1; array.length >= j;j++){
                 if (array[i] + array[j] == targetSum){
                    result[0] = array[i];
                    result[1] = array[j];
                    return result;
                 }
            }
        }
        return result;
    }

    // loop through the array
    // i + j = target
    // j = target - i
    // add j to the map
    public static int[] twoNumberSumBruteOptimized(int[] array, int targetSum) {
        Map<Integer, Integer> complements = new HashMap<>();

        for(int i =0;i<array.length;i++) {

            int diff = targetSum - array[i];
            if (complements.containsKey(diff)) {
                return new int[]{array[i], array[complements.get(diff)]};
            } else {
                complements.put(array[i],i);
            }
        }
        return new int[]{};
    }
}







