/**
 * @author : Sayaka Tamura
 * May 17, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package algo.binarysearch;

public class App {
	public static void main(String[] args) {

		System.out.println(binarysearch(new int[] { 2, 4, 5, 6, 8, 10 }, 7));
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
}
