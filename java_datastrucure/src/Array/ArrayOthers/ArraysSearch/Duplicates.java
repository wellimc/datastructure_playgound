package Array.ArrayOthers.ArraysSearch;

import java.util.HashSet;

public class Duplicates {

	public boolean containsDuplicate(int[] nums) {

		HashSet<Integer> values = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {

			if (values.contains(nums[i])) {
				return false;
			} else {
				values.add(nums[i]);
			}

		}

		return false;
	}

}
