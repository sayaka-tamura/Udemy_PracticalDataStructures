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
		if (first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}

	// assume non-empty list
	public boolean insertAfter(int key, int data) {
		Node current = first;
		// Search a key from a doubly linked list
		while (current.data != key) {
			current = current.next;
			if (current == null) {
				return false;
			}
		}
		// If a key is found
		Node newNode = new Node();
		newNode.data = data;

		if (current == last) {
			current.next = null;
			last = newNode;
		} else {
			newNode.next = current.next;
			current.next.previous = newNode;
		}

		newNode.previous = current;
		current.next = newNode;

		return true;
	}

	// assume non-empty list
	public Node deleteKey(int key) {
		Node current = first;
		while (current.data != key) {
			current = current.next;
			if (current == null) {
				System.out.println("There is no Node that has \'" + key + "\'");
				return null;
			}
		}

		if (current == first) {
			first = current.next;
		} else {
			current.previous.next = current.next;
		}

		if (current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}

		return current;
	}

	public void displayForward() {
		System.out.println("List(first -->last)");
		Node current = first;
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println("");
	}

	public void displayBackward() {
		System.out.println("List(last -->first)");
		Node current = last;
		while (current != null) {
			current.displayNode();
			current = current.previous;
		}
		System.out.println("");
	}
}
