/**
 * @author : Sayaka Tamura
 * May 15, 2019
 * Practical Data Structures & Algorithms in Java + HW
 */
package Prerequisite_OOP_Animal;

public class Animal {
	private String category;
	private int age;
	private char gender;
	private double weightInpounds;

	public Animal() {
		this.category = null;
		this.age = 0;
		this.gender = ' ';
		this.weightInpounds = 0;
	}

	public Animal(String category, int age, char gender, double weightInpounds) {
		super();
		this.category = category;
		this.age = age;
		this.gender = gender;
		this.weightInpounds = weightInpounds;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getWeightInpounds() {
		return weightInpounds;
	}

	public void setWeightInpounds(double weightInpounds) {
		this.weightInpounds = weightInpounds;
	}

	public void eat() {
		System.out.println(this.category + " is eating...");
	}

	public void walk() {
		System.out.println(this.category + " is walking...");
	}

	public void sleep() {
		System.out.println(this.category + " is sleeping...");
	}

	@Override
	public String toString() {
		return "Animal [category=" + category + ", age=" + age + ", gender=" + gender + ", weightInpounds="
				+ weightInpounds + "]";
	}
}
