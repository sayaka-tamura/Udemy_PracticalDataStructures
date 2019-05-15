/**
 * @author : Sayaka Tamura
 * May 15, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package Prerequisite_OOP_Animal;

public class Zoo {
	public static void main(String[] args) {

//		Animal panther = new Animal("Panther", 3, 'F', 56.4);
//		Animal elephant = new Animal("Elephant", 5, 'M', 1500.2);
//
//		System.out.println(panther);
//		panther.eat();
//		panther.walk();
//		panther.sleep();
//		System.out.println(elephant);
//		elephant.eat();

		Bird bird = new Bird();
		bird.fly();

		Bird hawk = new Bird("Hawk", 2, 'M', 673.1);
		System.out.println(hawk);
		hawk.fly();

		Fish fish = new Fish();
		fish.swim();
	}
}
