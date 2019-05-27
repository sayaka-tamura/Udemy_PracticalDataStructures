/**
 * @author : Sayaka Tamura
 * May 27, 2019
 * Udemy - Practical Data Structures & Algorithms in Java + HW Course
 */
package ds.heapimplimentation;

public class Heap {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize; // number of nodes in the array

	public Heap(int size) {
		this.maxSize = size;
		currentSize = 0;
		heapArray = new Node[size]; // actually creates the array
	}

	public int getSize() {
		return currentSize;
	}

	public boolean isEmpty() {
		return (currentSize == 0);
	}

	public boolean insert(int key) {
		if (currentSize == maxSize) // Check if array is full
			return false;

		Node newNode = new Node(key);
		heapArray[currentSize] = newNode; // insert newNode at last slot

		trickleUp(currentSize);

		currentSize++;
		return true;
	}

	// idx = newNode inserted at last slot
	private void trickleUp(int idx) {
		int parentIdx = (idx - 1) / 2; // formula to find parent(of idx) : floor((n-1)/2)
		Node nodeToInsert = heapArray[idx];

		// loop as long as we haven't reached the root and
		// key of nodeToInsert is less than the new node
		while (idx > 0 && heapArray[parentIdx].getKey() < nodeToInsert.getKey()) {
			heapArray[idx] = heapArray[parentIdx]; // move parent down
			idx = parentIdx; // update idx
			parentIdx = (parentIdx - 1) / 2; // it gives us a parent of a parent(move up)
		}

		heapArray[idx] = nodeToInsert;
	}

	public Node remove() {
		Node root = heapArray[0];
		currentSize--;
		heapArray[0] = heapArray[currentSize]; // assign last node to root

		trickleDown(0); // bring heapArray[0] to proper location
		return root;
	}

	private void trickleDown(int idx) {
		int largerChildIdx;
		Node top = heapArray[idx]; // save last node into top variable

		// will run as long as idx is not on the bottom row(at least 1 child)
		while (idx < currentSize / 2) { // check if there is at least 1 child
			int leftChildIdx = 2 * idx + 1; // left child idx position
			int rightChildIdx = leftChildIdx + 1; // right child idx position (= 2 * idx + 2)

			// figure out which child is larger
			if (rightChildIdx < currentSize && heapArray[leftChildIdx].getKey() < heapArray[rightChildIdx].getKey()) {
				largerChildIdx = rightChildIdx;
			} else {
				largerChildIdx = leftChildIdx;
			}

			if (top.getKey() >= heapArray[largerChildIdx].getKey()) {
				// successfully made root the largest key
				break;
			}

			heapArray[idx] = heapArray[largerChildIdx]; // swap larger child node and its parent
			idx = largerChildIdx; // go down
		}

		heapArray[idx] = top;
	}

	public void displayHeap() {
		System.out.println("Heap Array: ");
		for (int i = 0; i < currentSize; i++) {
			if (heapArray[i] != null)
				System.out.print(heapArray[i].getKey() + " ");
		}

		System.out.println();

		int nBlanks = 30;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0; // current item

		String dots = "................................";
		System.out.println(dots + dots);

		while (currentSize > 0) {
			if (column == 0)
				for (int i = 0; i < nBlanks; i++)
					System.out.print(" ");

			System.out.print(heapArray[j].getKey());
			j++;
			if (j == currentSize)
				break;

			column++;
			// end of row
			if (column == itemsPerRow) {
				nBlanks = nBlanks / 2; // half the blanks
				itemsPerRow = itemsPerRow * 2; // twice the item
				column = 0;
				System.out.println();
			} else {
				for (int i = 0; i < nBlanks * 2; i++)
					System.out.print(" ");
			}
		}

		System.out.println("\n" + dots + dots);
	}
}
