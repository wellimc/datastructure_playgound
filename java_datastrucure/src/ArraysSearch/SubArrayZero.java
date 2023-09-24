package ArraysSearch;

import java.util.HashSet;
import java.util.Set;

public class SubArrayZero {

	public static boolean zeroSumSubarray(int[] nums) {

		int currentSum = 0;
		Set<Integer> sums = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			currentSum += nums[i];

			if (nums[i] == 0 || currentSum == 0 || sums.contains(currentSum)) {
				return true;
			}

			sums.add(currentSum);
		}

		return false;

	}

	public static void main(String args[]) {

		int[] nums = { -5, -5, 2, 4, -2 };

		System.out.print(zeroSumSubarray(nums));

	}

}
