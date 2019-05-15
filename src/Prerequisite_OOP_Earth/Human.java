/**
 * @author : Sayaka Tamura
 * May 15, 2019
 * Practical Data Structures & Algorithms in Java + HW
 */
package Prerequisite_OOP_Earth;

public class Human {
	String name;
	int age;
	int heightInInches;
	String eyeColor;

	public Human(String name, int age, int heightInInches, String eyeColor) {
		super();
		this.name = name;
		this.age = age;
		this.heightInInches = heightInInches;
		this.eyeColor = eyeColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeightInInches() {
		return heightInInches;
	}

	public void setHeightInInches(int heightInInches) {
		this.heightInInches = heightInInches;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public void speak() {
		System.out.println("Hello, my name is " + name);
		System.out.println("I am " + heightInInches + " inches tall");
		System.out.println("I am " + age + " years old");
		System.out.println("My eye color is " + eyeColor);
	}

	public void eat() {
		System.out.println("eating...");
	}

	public void walk() {
		System.out.println("walking...");
	}

	public void work() {
		System.out.println("working...");
	}
}
