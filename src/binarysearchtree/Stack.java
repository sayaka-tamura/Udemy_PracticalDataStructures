/**
 * @author : Sayaka Tamura
 * May 15, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package binarysearchtree;

public class Stack {
	private int maxSize = 100;
	private Node[] stackArray;
	private int top;

	public Stack() {
		this.stackArray = new Node[100];
		this.top = -1;
	}

	public void push(Node root) {
		if (isFull()) {
			System.out.println("This stack is already full");
		} else {
			top++;
			stackArray[top] = root;
		}
	}

	public Node pop() {
		if (isEmpty()) {
			System.out.println("This stack is already empty");
			return null;
		} else {
			int old_top = top;
			top--;
			return stackArray[old_top];
		}
	}
//
//	public char peek() {
//		return stackArray[top];
//	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (maxSize - 1 == top);
	}

}
