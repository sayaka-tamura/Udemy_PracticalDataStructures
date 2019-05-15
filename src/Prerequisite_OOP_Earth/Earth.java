/**
 * @author : Sayaka Tamura
 * May 15, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package Prerequisite_OOP_Earth;

public class Earth {
	public static void main(String[] args) {

		Human tom = new Human("Tom Szabo", 5, 72, "brown");
		Human joe = new Human("Joe Greensilk", 36, 68, "green");

		tom.speak();
		joe.speak();
	}
}
