/**
 * @author : Sayaka Tamura
 * May 17, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */

/*
 * All recursive algorithms must have the following:
 * 1) Base Case (i.e., when to stop)
 * 2) Work toward Base Case 
 * 3) Recursive Call (i.e., call ourselves)
 */
package algo.binarysearch;

public class App {
	public static void main(String[] args) {

		// System.out.println(binarysearch(new int[] { 2, 4, 5, 6, 8, 10 }, 7));
		System.out.println(recursiveBinarySearch(new int[] { 2, 4, 5, 6, 8, 10, 13 }, 0, 6, 13));
	}

	public static int binarysearch(int[] A, int x) {
		int p = 0;
		int r = A.length - 1;

		while (p <= r) {
			int q = (p + r) / 2;

			if (x < A[q])
				r = q - 1;
			else if (x > A[q])
				p = q + 1;
			else // if (x == A[q])
				return q;
		}
		return -1;
	}

	/**
	 * 
	 * @param A an array that want to search
	 * @param p represent the subarray A[p..r]
	 * @param r represent the subarray A[p..r]
	 * @param x a number that want to search
	 * @return index of an element matching x in the subarray from A[i] through A[n]
	 */
	public static int recursiveBinarySearch(int[] A, int p, int r, int x) {
		System.out.println("[" + p + "..." + r + "]");
		if (p > r)
			return -1;
		else {
			int q = (p + r) / 2;

			if (x == A[q])
				return q;
			else if (x < A[q]) {
				return recursiveBinarySearch(A, p, q - 1, x);
			} else { // if (x > A[q])
				return recursiveBinarySearch(A, q + 1, r, x);
			}
		}
	}

}
