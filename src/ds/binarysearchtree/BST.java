/**
 * @author : Sayaka Tamura
 * May 25, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package ds.binarysearchtree;

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
					current = current.leftChild;
					if (current == null) { // It's parent is the leaf node
						parent.leftChild = newNode;
						return;
					}
				} else if (key > current.key) {
					current = current.rightChild;
					if (current == null) { // It's parent is the leaf node
						parent.rightChild = newNode;
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
			current = current.leftChild;
		}
		return last;
	}

	public Node findMax() {
		Node current = root;
		Node last = null;

		while (current != null) {
			last = current;
			current = current.rightChild;
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
				currentNode = currentNode.leftChild;
			} else {
				currentNode = currentNode.rightChild;
				isLeftChild = false;
			}
			if (currentNode == null)
				return false;
		}

		// found the node
		Node nodeToDelete = currentNode;

		// Case 1: if node is a leaf
		if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
			if (nodeToDelete == root)
				root = null;
			else if (isLeftChild)
				parentNode.leftChild = null;
			else
				parentNode.rightChild = null;
		}

		// Case 2-1 : if node has one child that is on the left
		else if (nodeToDelete.rightChild == null) {
			if (nodeToDelete == root)
				root = nodeToDelete.leftChild;
			else if (isLeftChild)
				parentNode.leftChild = nodeToDelete.leftChild;
			else
				parentNode.rightChild = nodeToDelete.leftChild;
		}
		// Case 2-2 :if node has one child that is on the right
		else if (nodeToDelete.leftChild == null) {
			if (nodeToDelete == root)
				root = nodeToDelete.rightChild;
			else if (isLeftChild)
				parentNode.leftChild = nodeToDelete.rightChild;
			else
				parentNode.rightChild = nodeToDelete.rightChild;
		}

		// Case 3 :if node has 2 children (tricky)
		else {
			Node successor = getSuccessor(nodeToDelete);
			// connect parent of nodeToDelete to successor instead
			if (nodeToDelete == root)
				root = successor;
			else if (isLeftChild)
				parentNode.leftChild = successor;
			else
				parentNode.rightChild = successor;

			successor.leftChild = nodeToDelete.leftChild;
		}
		return true;
	}

	private Node getSuccessor(Node nodeToDelete) {
		Node successorParent = nodeToDelete;
		Node successor = nodeToDelete;

		Node current = nodeToDelete.rightChild; // Go to the right child

		while (current != null) { // start going left down the tree until node has no left child
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		// successor not a right child
		if (successor != nodeToDelete.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = nodeToDelete.rightChild;
		}
		return successor;
	}

//	public void displayTree_myAnswer() {
//		Node current = root;
//
//		System.out.print(current.key + " ");
//
//		while (current != null) {
//			// For printing right child
//			if (current.leftChild != null)
//				System.out.print(current.leftChild.key + " ");
//			else
//				System.out.println("--" + " ");
//
//			// For printing left child
//			if (current.rightChild != null)
//				System.out.print(current.rightChild.key + " ");
//			else
//				System.out.println("--" + " ");
//
//			current = current.leftChild;
//			current = current.rightChild;
//		}
//	}

	public void displayTree() {
		Stack globalStack = new Stack();
		globalStack.push(root); // put root Node to global stack
		int nBlanks = 24;
		boolean isRowEmpty = false;
		System.out.println("......................................................");

		while (isRowEmpty == false) {
			Stack localStack = new Stack();
			isRowEmpty = true;
			for (int j = 0; j < nBlanks; j++) {
				System.out.print(" ");
			}

			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop(); // pop root Node to global stack
				if (temp != null) {
					System.out.print(temp.key);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if (temp.leftChild != null || temp.rightChild != null) {
						isRowEmpty = false;
					}
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}

				for (int j = 0; j < nBlanks * 2 - 2; j++) {
					System.out.print(" ");
				}
			}

			System.out.println();
			nBlanks = nBlanks / 2;

			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		}
		System.out.println("......................................................");
	}
}
