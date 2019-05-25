/**
 * @author : Sayaka Tamura
 * May 20, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package algo.quicksort;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int[] inputArray = { 12, 81, 74, 43, 1098, 3, 2, 6, 754, 912, 6, 4, 0 };
		quickSort(inputArray, 0, inputArray.length - 1);

		System.out.println(Arrays.toString(inputArray));
	}

	public static void quickSort(int[] inputArray, int start, int end) {
		if (start < end) {
			// return index position of the correctly placed value in the array
			int pp = Partition(inputArray, start, end);

			quickSort(inputArray, start, pp - 1); // sorts the left half of the range
			quickSort(inputArray, pp + 1, end); // sorts the right half of the range
		}
	}

	public static int Partition(int[] inputArray, int start, int end) {
		int pivot = inputArray[end];
		// in the first iteration, i starts from -1
		int i = start - 1;

		for (int j = start; j <= end - 1; j++) {
			if (inputArray[j] <= pivot) {
				i++;
				// swap A[i] with A[j]
				int temp = inputArray[i];
				inputArray[i] = inputArray[j];
				inputArray[j] = temp;
			}
		}

		// swap A[i+1] with A[r] (put the pivot value in the correct slot next)
		int temp = inputArray[i + 1];
		inputArray[i + 1] = inputArray[end];
		inputArray[end] = temp;

		return i + 1; // pivot position
	}
}
