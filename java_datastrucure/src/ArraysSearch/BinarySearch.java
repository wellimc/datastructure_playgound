package ArraysSearch;

public class BinarySearch {

	public static void main(String args[]) {

		int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int result = binarySearch(list, 8);

		System.out.print(result);
	}

	static int binarySearch(int[] list, int target) {

		int left = 0;
		int right = list.length - 1;

		while (right >= left) {

			int middle = (right + left) / 2;

			if (target > middle) {
				left = middle + 1;
			} else if (target > middle) {
				right = middle - 1;
			} else {
				return middle;
			}

		}
		return -1;
	}

}
