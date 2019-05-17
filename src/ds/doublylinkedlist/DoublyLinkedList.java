/**
 * @author : Sayaka Tamura
 * May 17, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package ds.doublylinkedlist;

public class DoublyLinkedList {
	private Node first;
	private Node last;

	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;

		if (isEmpty()) {
			last = newNode;
		} else {
			first.previous = newNode;
		}

		newNode.next = first;
		this.first = newNode;
	}

	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;

		if (isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode;
			newNode.previous = last;
		}

		this.last = newNode;
	}

	// assume non-empty list
	public Node deleteFirst() {
		Node temp = first;
		if (first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}

	public Node deleteLast() {
		Node temp = last;
		if (last.previous == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}

	public void displayList() {
		System.out.println("List(first -->last)");
		Node current = first;
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println("");
	}
}
