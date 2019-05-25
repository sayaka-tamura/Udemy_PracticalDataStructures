/**
 * @author : Sayaka Tamura
 * May 25, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package binarysearchtree;

public class BST {
	private Node root;

	public void insert(int key, String value) {

		Node newNode = new Node(key, value);

		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;

			while (true) {
				parent = current;
				if (key < current.key) {
					current = current.leftchild;
					if (current == null) { // It's parent is the leaf node
						parent.leftchild = newNode;
						return;
					}
				} else if (key > current.key) {
					current = current.rightchild;
					if (current == null) { // It's parent is the leaf node
						parent.rightchild = newNode;
						return;
					}
				}
			}
		}
	}

	public Node findMin() {
		Node current = root;
		Node last = null;

		while (current != null) {
			last = current;
			current = current.leftchild;
		}
		return last;
	}

	public Node findMax() {
		Node current = root;
		Node last = null;

		while (current != null) {
			last = current;
			current = current.rightchild;
		}
		return last;
	}

	public boolean remove(int key) {

		Node currentNode = root;
		Node parentNode = root;

		boolean isLeftChild = false;

		// Searching to find the node with the key to delete
		while (currentNode.key != key) {
			parentNode = currentNode;
			if (key < currentNode.key) {
				isLeftChild = true;
				currentNode = currentNode.leftchild;
			} else {
				currentNode = currentNode.rightchild;
				isLeftChild = false;
			}
			if (currentNode == null)
				return false;
		}

		// found the node
		Node nodeToDelete = currentNode;

		// Case 1: if node is a leaf
		if (nodeToDelete.leftchild == null && nodeToDelete.rightchild == null) {
			if (nodeToDelete == root)
				root = null;
			else if (isLeftChild)
				parentNode.leftchild = null;
			else
				parentNode.rightchild = null;
		}

		// Case 2-1 : if node has one child that is on the left
		else if (nodeToDelete.rightchild == null) {
			if (nodeToDelete == root)
				root = nodeToDelete.leftchild;
			else if (isLeftChild)
				parentNode.leftchild = nodeToDelete.leftchild;
			else
				parentNode.rightchild = nodeToDelete.leftchild;
		}
		// Case 2-2 :if node has one child that is on the right
		else if (nodeToDelete.leftchild == null) {
			if (nodeToDelete == root)
				root = nodeToDelete.rightchild;
			else if (isLeftChild)
				parentNode.leftchild = nodeToDelete.rightchild;
			else
				parentNode.rightchild = nodeToDelete.rightchild;
		}

		// Case 3 :if node has 2 children (tricky)
		else {
			Node successor = getSuccessor(nodeToDelete);
			// connect parent of nodeToDelete to successor instead
			if (nodeToDelete == root)
				root = successor;
			else if (isLeftChild)
				parentNode.leftchild = successor;
			else
				parentNode.rightchild = successor;

			successor.leftchild = nodeToDelete.leftchild;
		}
		return true;
	}

	private Node getSuccessor(Node nodeToDelete) {
		Node successorParent = nodeToDelete;
		Node successor = nodeToDelete;

		Node current = nodeToDelete.rightchild; // Go to the right child

		while (current != null) { // start going left down the tree until node has no left child
			successorParent = successor;
			successor = current;
			current = current.leftchild;
		}
		// successor not a right child
		if (successor != nodeToDelete.rightchild) {
			successorParent.leftchild = successor.rightchild;
			successor.rightchild = nodeToDelete.rightchild;
		}
		return successor;
	}
}
