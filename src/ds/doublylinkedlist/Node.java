/**
 * @author : Sayaka Tamura
 * May 16, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package ds.doublylinkedlist;

public class Node {
	public int data;
	public Node next;
	public Node previous;

	public void displayNode() {
		System.out.println("{ " + data + " }");
	}
}
