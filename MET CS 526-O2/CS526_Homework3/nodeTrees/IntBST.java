/**
 * @author Elizabeth Oyebade
 * course MET CS 526-O2
 * date 04/05/2022
 */
package nodeTrees;

import java.util.ArrayList;
import java.util.List;

// binary search tree storing integers
public class IntBST extends NodeBinaryTree<Integer> {

	private int size = 0;

	public IntBST() {	}

	public int size() {
		return size;
	}

	public void setSize(int s) { size = s; }
	
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Places element e at the root of an empty tree and returns its new Node.
	 *
	 * @param e the new element
	 * @return the Node of the new element
	 * @throws IllegalStateException if the tree is not empty
	 */

	public Node<Integer> addRoot(Integer e) throws IllegalStateException {
		if (size != 0)
			throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}

	/**
	 * Print a binary tree horizontally Modified version of
	 * https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
	 * Modified by Keith Gutfreund
	 * 
	 * @param n Node in tree to start printing from
	 */
	
	  public void print(Node<Integer> n){ print ("", n); }
	  
	  public void print(String prefix, Node<Integer> n){
		  if (n != null){
			  print(prefix + "       ", right(n));
			  System.out.println (prefix + ("|-- ") + n.getElement());
			  print(prefix + "       ", left(n));
		  }
	  }
	  
	  
	  public void inorderPrint(Node<Integer> n) {
		if (n == null)
			return;
		inorderPrint(n.getLeft());
		System.out.print(n.getElement() + "  ");
		inorderPrint(n.getRight());
	}

	
	public Iterable<Node<Integer>> children(Node<Integer> n) {
		List<Node<Integer>> snapshot = new ArrayList<>(2); // max capacity of 2 
		if (left(n) != null) 
			snapshot.add(left(n)); 
		if (right(n) != null)
			snapshot.add(right(n)); return snapshot; 
	}
	
	public int height(Node<Integer> n) throws IllegalArgumentException { 
		if (isExternal(n)) { return 0; } 
		int h = 0; // base case if p is external
		for (Node<Integer> c : children(n)) h = Math.max(h, height(c)); return h + 1; 
	}

	// This method will be...
	// Receiving an array of integers and creates a search of binary tree
	// Inputting --> an array of integers with size of a = 2^k – 1, k = 1,2,......, and
	// 		integers in the array are sorted in non-decreasing order.
	// Outputting --> a “complete” binary search tree that contains all integers in the array of 'a'
	//		also known as "IntBST"
	public static IntBST makeBinaryTree(int[] a){
		return recursiveBinaryTree(a, 0, a.length - 1);
	}

	/**
	 * This method will receive an array of integers and convert the array to
	 * 		a binary search tree
	 * @param a --> the integer array
	 * @param start --> the index of the first element in the array
	 * @param end --> the index of the last element in the array
	 * @return --> binary search tree
	 */
	public static IntBST recursiveBinaryTree(int[] a, int start, int end) {

		// creates a new instance tree
		IntBST tree = new IntBST();

		// base case
		// if the first element (start) > the last element (end)
		// 		return an empty tree
		if (start > end) {
			return tree;
		}

		// calculates the root of each element in the tree
		int mid = (start + end ) / 2;
		// assign the root of the tree
		Node root = tree.addRoot(a[mid]);

		// calculates the left and right subtrees
		IntBST leftTree = recursiveBinaryTree(a, start, mid - 1);
		IntBST rightTree = recursiveBinaryTree(a, mid + 1, end);

		// adding the left tree to the root
		if (!leftTree.isEmpty()) {
			root.setLeft(leftTree.root);
			// calculates the left tree size
			tree.size += leftTree.size;
		}

		// adding the right tree to the root
		if (!rightTree.isEmpty()) {
			root.setRight(rightTree.root);
			// calculates the right tree size
			tree.size += rightTree.size;
		}

		// return tree
		return tree;
	}

}
