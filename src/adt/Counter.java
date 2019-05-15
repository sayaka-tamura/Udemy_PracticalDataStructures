/**
 * @author : Sayaka Tamura
 * May 15, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package adt;

public class Counter {

	private String name = null;
	private int value = 0;

	public Counter(String str) {
		this.name = str;
	}

	public void increment() {
		value++;
	}

	public int getCurrentValue() {
		return value;
	}

	public String toString() {
		return "Counter [name=" + name + ", value=" + value + "]";
	}
}
