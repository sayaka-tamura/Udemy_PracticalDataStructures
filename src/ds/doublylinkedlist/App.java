/**
 * @author : Sayaka Tamura
 * May 16, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package ds.doublylinkedlist;

public class App {
	public static void main(String[] args) {
		DoublyLinkedList myList = new DoublyLinkedList();

		myList.insertLast(999999);
		myList.insertFirst(50);
		myList.insertFirst(100);

		myList.displayBackward();
	}
}
