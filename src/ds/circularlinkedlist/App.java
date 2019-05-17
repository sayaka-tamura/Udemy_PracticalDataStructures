/**
 * @author : Sayaka Tamura
 * May 16, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package ds.circularlinkedlist;

public class App {
	public static void main(String[] args) {
		CircularLinkedList myList = new CircularLinkedList();
		myList.insertFirst(100);
		myList.insertFirst(50);
		myList.insertFirst(99);
		myList.insertFirst(88);
		myList.insertLast(999999);

		myList.displayList();
	}
}
