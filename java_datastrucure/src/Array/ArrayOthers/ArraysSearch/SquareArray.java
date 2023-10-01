package Array.ArrayOthers.ArraysSearch;

import java.util.Arrays;

public class SquareArray {
	
	
	public int[] sortedSquaredArray(int[] array) {
		
		if(array.length == 0) {
			return new int[] {};
		}
	
		int[] square_array = new int[array.length];
		int i = 0;
		for(int num : array) {
			square_array[i] = num * num;
			i++;
		}
		// Write your code here.
		Arrays.sort(square_array);
		return square_array;
	}

}
