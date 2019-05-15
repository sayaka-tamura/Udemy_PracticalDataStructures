/**
 * @author : Sayaka Tamura
 * May 15, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package adt;

public class App {

	public static void main(String[] args) {
		Counter myCounter = new Counter("myCOunter");
		myCounter.increment();
		myCounter.increment();
		myCounter.increment();
		myCounter.increment();

		System.out.println(myCounter.getCurrentValue());
	}

}
