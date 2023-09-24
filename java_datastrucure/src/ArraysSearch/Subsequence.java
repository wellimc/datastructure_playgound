package ArraysSearch;

import java.util.Arrays;
import java.util.List;

public class Subsequence {

	// iterate the sequence
	// find the current element in the array , exiting the loop when find
	// if is the last element in the sequence return true
	// anything else return false

	public static void main(String arggs[]) {


		Integer[] array = {5, 1, 22, 25, 6, -1, 8, 10};
		Integer[] sequence = {1, 6, -1, 10};

		System.out.println(isValidSubsequence(Arrays.asList(array),Arrays.asList(sequence)));
	

	}

	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

		int j = 0;
		for (int i = 0; i<sequence.size(); i++) {
			Boolean foundEmelemt = Boolean.FALSE;
			while (!foundEmelemt && j<array.size()) {
				if (sequence.get(i) == array.get(j)) {
					foundEmelemt = Boolean.TRUE;
				}
				j += 1;
			}
			if (foundEmelemt) {
				if (i == sequence.size()-1) {
					return true;
				}
			} else {
				return false;
			}
			

		}
		System.out.println("end of the method");
		return false;
	}

}
