package LinkedList;

/**
 * import LinkedList.DoubleLinkNode;
 * import LinkedList.DoublyLinkedList;
 *
 * @author Elizabeth Oyebade
 * course MET CS 526-O2
 * date 03/29/2022
 */
public class Hw2_p3 {

	/**
	 * This method will receive a doubly linked list that stores integers.
	 * It will then reverse the order of all integers in the list.

	// implement reverse method
	// you may want to write a separate method with additional parameters, which is recursive

	 * Method used at the start of the recursion...
	 * ...which is then passed to the next recurse method in order to continue...
	 * ...the retaining position of the node within the recursion
	 * @param intList: taking the  initial DoublyLinkedList from the main method
	 */
	public static void reverse(DoublyLinkedList<Integer> intList) {
		// complete this method
		//pointing to the next position on the list
		DoubleLinkNode<Integer> current = intList.getTrailer().getPrev();

		// using the if statement to check the list
		// if the statement is true then an empty list is returned
		if (current == intList.getHeader().getNext()) {
			return;
		}

		// adding the first value to the node position
		intList.addBetween (intList.first(), current, current.getNext());
		// removing the first element
		intList.removeFirst();
		// move to next method
		newReverse(intList, current);
	}

	/**
	 *
	 * Second method with an additional parameter...
	 * ...continues the recursion from the reverse method
	 * @param intList taking the  initial DoublyLinkedList from the main method
	 * @param current tracking the intList
	 */
	public static void  newReverse(DoublyLinkedList<Integer> intList, DoubleLinkNode current) {
		if (current == intList.getHeader().getNext()) {
			return;
		}

		// adding the first value to the node position
		intList.addBetween (intList.first(), current, current.getNext());
		// removing the first element
		intList.removeFirst();
		// move to next method
		newReverse(intList, current);
	}

	// use the main method for testing with arrays of different lengths
	public static void main(String[] args) {


		DoublyLinkedList<Integer> intList = new DoublyLinkedList<>();

		int[] a = {10, 20, 30, 40, 50};
		for (int i=0; i<a.length; i++) {
			intList.addLast(a[i]);
		}
		System.out.println("Initial list: size = " + intList.size() + ", " + intList.toString());

		// Here, invoke the reverse method you implemented above
		reverse(intList);

		System.out.println("After reverse: " + intList.toString());

		intList = new DoublyLinkedList<>();
		int[] b = {10, 20, 30, 40, 50, 60};
		for (int i=0; i<b.length; i++) {
			intList.addLast(b[i]);
		}
		System.out.println();
		System.out.println("Initial list: size = " + intList.size() + ", " + intList.toString());

		// Here, invoke the reverse method you implemented above
		reverse(intList);

		System.out.println("After reverse: " + intList.toString());

	}

}
