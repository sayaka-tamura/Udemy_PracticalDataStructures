/**
 * @author : Sayaka Tamura
 * May 16, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package ds.singlylinkedlist;

public class SinglyLinkedList {
	private Node first;

	public SinglyLinkedList() {
	}

	public boolean isEmpty() {
		return (first == null);
	}

	// used to insert at the beginning of the list
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = first;
		first = newNode;
	}

	public Node deleteFirst() {
		Node temp = first;
		first = first.next;
		return temp;
	}

	public void displayList() {
		System.out.println("List(first --> last)");
		Node current = first;
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}

	public void insertLast(int data) {
		Node current = first;
		while (current.next != null) {
			current = current.next; // we will loop until is null
		}
		Node newNode = new Node();
		newNode.data = data;
		current.next = newNode;
	}
}
