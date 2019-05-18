/**
 * @author : Sayaka Tamura
 * May 18, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */

/*
 * All recursive algorithms must have the following:
 * 1) Base Case (i.e., when to stop)
 * 2) Work toward Base Case 
 * 3) Recursive Call (i.e., call ourselves)
 */
package algo.recursion;

public class App {
	public static void main(String[] args) {
		// reduceByOne(10);
		System.out.println(recursiveLinearSearch(new int[] { 4, 6, 8, 9, 11 }, 0, 11));
	}

	public static void reduceByOne(int n) {
		if (n >= 0)
			reduceByOne(n - 1);
		System.out.println("Completed Call: " + n);
	}

	/**
	 * 
	 * @param A an array that want to search
	 * @param i a index that want to start searching
	 * @param x a number that want to search
	 * @return index of an element matching x in the subarray from A[i] through A[n]
	 */
	public static int recursiveLinearSearch(int[] A, int i, int x) {
		if (i > A.length - 1)
			return -1;
		else if (A[i] == x)
			return i;
		else {
			System.out.println("index at: " + i);
			return recursiveLinearSearch(A, i + 1, x);
		}
	}

}
