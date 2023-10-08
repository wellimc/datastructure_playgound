package Array.ArrayOthers.ArraySum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of positive and negative numbers, the task is to find if there is a subarray (of size at least one) with 0 sum.
 * <p>
 * Examples:
 * <p>
 * Input: {4, 2, -3, 1, 6}
 * Output: true
 * Explanation:
 * There is a subarray with zero sum from index 1 to 3.
 * <p>
 * <p>
 * Input: {-3, 2, 3, 1, 6}
 * Output: false
 */
public class ZeroSumArray {

    public static void main(String args[]) {

  //        int[] array = {4, 2, -3, 1, 6};
      //  int[] array = {4, 2, -2, -4};
        int[] array = {-3, 2, 3, 1, 6,-5,-4};
        System.out.println(zeroCalc(array));
    }

    private static boolean zeroCalc(int[] array) {

        int currentSum = 0;
        Map<Integer, ArrayList<Integer>> subSum = new HashMap<>();
        List<Integer> items = new ArrayList<>();



        for (int j : array) {
            currentSum += j;
            if (j == 0 || currentSum == 0 || subSum.containsKey(currentSum)) {

                for (Map.Entry<Integer, ArrayList<Integer>> entry : subSum.entrySet()) {
                    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
                }

                return true;
            }
            items.add(j);
            subSum.put(currentSum, new ArrayList<>(items));
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : subSum.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }

        return false;

    }
}
