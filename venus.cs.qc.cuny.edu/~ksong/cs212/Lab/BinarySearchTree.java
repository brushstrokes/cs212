import cs212lib.Queue;
import cs212lib.QueueException;
import list.UnorderedList;

class BinaryNode<E extends Comparable<E>> implements Comparable<E> {
	E data;
	BinaryNode<E> left;
	BinaryNode<E> right;

	/**
	 * default constructor
	 */
	public BinaryNode() {
		data = null;
		left = null;
		right = null;
	}

	/**
	 * parameterized constructor with the item
	 * 
	 * @param item
	 */
	public BinaryNode(E item) {
		data = item;
		left = null;
		right = null;
	}

	/**
	 * parameterized constructor with the item and a reference to the next Node
	 * 
	 * @param item
	 * @param n
	 */
	public BinaryNode(E item, BinaryNode<E> l, BinaryNode<E> r) {
		data = item;
		left = l;
		right = r;
	}

	/**
	 * sets (changes) the reference to the next Node
	 * 
	 * @param n
	 */
	public void setLeft(BinaryNode<E> l) {
		left = l;
	}

	public void setRight(BinaryNode<E> r) {
		right = r;
	}

	/**
	 * returns a reference to the next Node in the list
	 * 
	 * @return next
	 */
	public BinaryNode<E> getLeft() {
		return left;
	}

	public BinaryNode<E> getRight() {
		return right;
	}

	/**
	 * sets (changes) the data in the Node
	 * 
	 * @param item
	 */
	public void setData(E item) {
		data = item;
	}

	/**
	 * returns the data in the Node
	 * 
	 * @return data - the data in the node
	 */
	public E getData() {
		return data;
	}

	public String toString() {
		return "" + data;
	}

	@Override
	public int compareTo(E arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class BinarySearchTree<T extends Comparable<T>> {

	BinaryNode<T> tree;

	public BinarySearchTree() {
		tree = null;
	}

	public void insert(T d) {
		tree = insert(d, tree);
	}

	protected BinaryNode<T> insert(T d, BinaryNode<T> root) {
		if (root == null) {
			root = new BinaryNode<T>(d);
		} else if (root.data.compareTo(d) > 0) {
			root.left = insert(d, root.left);
		} else {
			root.right = insert(d, root.right);
		}
		return root;
	}

	public static void buildHeap(int[] a, int size) {
		// start from last parent to first parent
		for (int i = size / 2 - 1; i >= 0; i--)
			heapify(a, i, size);
	}

	public static void heapify(int[] a, int i, int size) {
		int l = 2 * i + 1; // left child
		int r = 2 * i + 2; // right child
		int largest = i; // parent
		// find the larger of parent and left child
		if (l <= size - 1 && a[l] > a[i])
			largest = l;
		else
			largest = i;
		// find the larger of parent and right child
		if (r <= size - 1 && a[r] > a[largest])
			largest = r;
		// swap parent and larger child if necessary
		if (largest != i) {
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			// repeat heapify until all children are in a heap
			heapify(a, largest, size);
		}
	}

	/**
	 * Helper method for the "height(BinaryNode<T> node)" method
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return height(tree);
	}

	private int height(BinaryNode<T> node) {
		if (node == null)
			return -1;
		return (Math.max(height(node.left), height(node.right)) + 1);
	}

	public void levelOrderPrint() throws QueueException {
		levelOrderPrint(tree);
	}
	
	private void levelOrderPrint(BinaryNode<T> root) throws QueueException {

		Queue<BinaryNode<T>> queue = new Queue<>();
		UnorderedList<T> list = new UnorderedList<T>();
		queue.enqueue(root);

		while (!queue.isEmpty()) {
			BinaryNode<T> item = (BinaryNode<T>) queue.dequeue();
			if (item != null) {
				list.add((T) item);
				if (item.left != null)
					queue.enqueue(item.left);
				if (item.right != null)
					queue.enqueue(item.right);
			}
		}

		System.out.println(list);
	}

	private void postorder(BinaryNode<T> root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.data);
		}
	}

	private void inorder(BinaryNode<T> root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}

	private void preorder(BinaryNode<T> root) {
		if (root != null) {
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

}