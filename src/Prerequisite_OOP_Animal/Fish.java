/**
 * @author : Sayaka Tamura
 * May 15, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package Prerequisite_OOP_Animal;

public class Fish extends Animal {

	public Fish() {
		super();
	}

	public Fish(String category, int age, char gender, double weightInpounds) {
		super(category, age, gender, weightInpounds);
	}

	public void swim() {
		System.out.println("Fish is swimming...");
	}

}
