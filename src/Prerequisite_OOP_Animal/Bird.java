/**
 * @author : Sayaka Tamura
 * May 15, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package Prerequisite_OOP_Animal;

public class Bird extends Animal {

	public Bird() {
		super();
	}

	public Bird(String category, int age, char gender, double weightInpounds) {
		super(category, age, gender, weightInpounds);
	}

	public void fly() {
		System.out.println("Bird is flying...");
	}

}
