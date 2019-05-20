/**
 * @author : Sayaka Tamura
 * May 20, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package algo.mergesort;

public class MergeSort {

	public void sort(int[] inputArray) {
		sort(inputArray, 0, inputArray.length - 1);
	}

	/**
	 * 
	 * @param A     array that want to sort
	 * @param start first index number
	 * @param end   last index number
	 * @return sorted array
	 */
	public void sort(int[] inputArray, int start, int end) {
		if (end <= start) {
			return; // we're done traversing the array
		}

		int mid = (start + end) / 2;
		sort(inputArray, start, mid);
		sort(inputArray, mid + 1, end);
		merge(inputArray, start, mid, end);
	}

	private void merge(int[] inputArray, int start, int mid, int end) {

		int tempArray[] = new int[end - start + 1];

		int leftSlot = start;
		int rightSlot = mid + 1;
		int k = 0;

		while (leftSlot <= mid && rightSlot <= end) {
			if (inputArray[leftSlot] < inputArray[rightSlot]) {
				tempArray[k] = inputArray[leftSlot];
				leftSlot++;
			} else {
				tempArray[k] = inputArray[rightSlot];
				rightSlot++;
			}
			k++;
		}

		// consider the right side done being sorted. Left must be sorted already.
		if (leftSlot <= mid) {
			while (leftSlot <= mid) {
				tempArray[k] = inputArray[leftSlot];
				leftSlot++;
				k++;
			}
		} else if (rightSlot <= end) {
			while (rightSlot <= end) {
				tempArray[k] = inputArray[rightSlot];
				rightSlot++;
				k++;
			}
		}

		// copy oner the temp array into the appropriate slots of the inputArray
		for (int i = 0; i < tempArray.length; i++) {
			inputArray[start + i] = tempArray[i];
		}

	}

}
