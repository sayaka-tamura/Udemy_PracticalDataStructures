/**
 * @author : Sayaka Tamura
 * May 17, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package algo.linearsearch;

public class App {
	public static void main(String[] args) {
		int[] array = { 2, 5, 8, 10, 12 };
		System.out.println(linearSearch(array, 8));
	}

	public static int linearSearch(int[] a, int x) {

		for (int i = 0; i < a.length; i++) {
			if (a[i] == x)
				return i;
		}

		return -1;
	}
}
