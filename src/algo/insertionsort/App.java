/**
 * @author : Sayaka Tamura
 * May 19, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package algo.insertionsort;

public class App {
	public static void main(String[] args) {
		int[] myArray = insertionSort(new int[] { 9, 8, 3, 13, 99, 12, 87 });
		for (int i = 0; i < myArray.length; i++) {
			System.out.println(myArray[i]);
		}
	}

	public static int[] insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int element = a[i]; // this contains the data we intend on over to the sorted area
			int j = i - 1; // the last value in the sorted area

			while (j >= 0 && a[j] > element) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = element;
		}
		return a;
	}

}
