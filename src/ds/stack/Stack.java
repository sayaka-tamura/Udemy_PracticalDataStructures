/**
 * @author : Sayaka Tamura
 * May 15, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package ds.stack;

public class Stack {
	private int maxSize;
	private char[] stackArray;
	private int top;

	public Stack(int size) {
		this.maxSize = size;
		this.stackArray = new char[maxSize];
		this.top = -1;
	}

	public void push(char j) {
		if (isFull()) {
			System.out.println("This stack is already full");
		} else {
			top++;
			stackArray[top] = j;
		}
	}

	public char pop() {
		if (isEmpty()) {
			System.out.println("This stack is already empty");
			return '0';
		} else {
			int old_top = top;
			top--;
			return stackArray[old_top];
		}
	}

	public char peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (maxSize - 1 == top);
	}

}
