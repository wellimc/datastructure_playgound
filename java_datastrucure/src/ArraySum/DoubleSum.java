package ArraySum;

import java.util.HashMap;
import java.util.Map;

public class DoubleSum {

	public static void main(String args[]) throws Exception {
		// 0 1 2 3 4 --> 1 and 4
		Integer[] x = { 3, 6, 9, 10, 20 };
		// 19 - 3 = 16
		Integer[] a = doubleSum(x, 19);
		System.out.println(a[0]);
		System.out.println(a[1]);

	}

	public static Integer[] doubleSum(Integer[] values, int target) throws Exception {

		
		Map<Integer, Integer> complements = new HashMap<Integer, Integer>();
		for ( int i=0;i<=values.length;i++) {
		
			if (complements.containsKey(values[i])) {
				return new Integer[] {i,complements.get(values[i])};
			}else {
				complements.put(target  - values[i], i);			
			}
		}
		

		throw new Exception("Error");

	}

}
