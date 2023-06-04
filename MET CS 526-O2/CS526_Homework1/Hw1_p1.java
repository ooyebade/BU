/**
 * @author Elizabeth Oyebade
 * @course MET CS 526-O2
 * @date 3/22/2022
 */

public class Hw1_p1 {

	/**
	 * Start by setting an integer 'count' to zero
	 * The integer is then used to count the amount of times the input integer x appears in the array
	 * If the count does not increase then the input integer x will not appear in the array
	 *
	 * Then using the 'for loop' to process through the array by creating a count integer 'i'
	 * The 'for loop' ran and increased 'i' by 1 because 'i' is less than the length of the array
	 *
	 * Within the loop, using the if statement...if the value of int 'x' is equal while the loop ran
	 * then the program will print the value in the array where int 'x' appears
	 * @param a
	 * @param x
	 */
	// find method declaration and definition
	public static void find(int[] a, int x) {
		// implement this method
		// using 'count' to check whether the integer x is in the array
		int count = 0;
		// the for loop to iterate through each variable of the array
		for (int i = 0; i < a.length; i++) {
			// checking to see whether the value x is equal to the value of the array
			// if array exists then print the index
			if (a[i] == x) {
				System.out.printf("%d is in a[%d]%n", x, i);
				// increase the count by one
				count++;
			}
		}
		// if count is zero that means that there's no element in the array
		if (count == 0) {
			System.out.println(x + " does not exist");
		}
	}

	/**
	 * If the arguments are true then the boolean will return false
	 * Otherwise the class will return false
	 *
	 * (Receives two strings s1 and s2. Assume that length of s1 <= length of s2.)
	 * (Returns true if s1 is a prefix of s2 and returns false otherwise.)
	 *
	 * @param s1
	 * @param s2
	 * @return
	 */
	// isPrefix method declaration and definition
	public static boolean isPrefix(String s1, String s2) {
		// implement this method
		// find the length of String s1 and s2
		int length1 = s1.length();
		int length2 = s2.length();

		// if s1 length is greater than s2
		if (length1 > length2)
			return false;

		// the for loop to loop through each element in String s1
		for (int i = 0; i < length1; i++) {
			// if String s1 is not equal to s2
			if (s1.charAt(i) != s2.charAt(i)) {
				// return false
				return false;
			}
		}
		// else return true
		return true;
	}
	
	
	public static void main(String[] args) {
		
		int[] a = {5, 3, 5, 6, 1, 2, 12, 5, 6, 1};
		
		find(a, 5);
		find(a, 10);
		System.out.println();
		
		String s1 = "abc";
		String s2 = "abcde";
		String s3 = "abdef";
		
		if (isPrefix(s1,s2)) {
			System.out.println(s1 + " is a prefix of " + s2);
		}
		else {
			System.out.println(s1 + " is not a prefix of " + s2);
		}
		
		if (isPrefix(s1,s3)) {
			System.out.println(s1 + " is a prefix of " + s3);
		}
		else {
			System.out.println(s1 + " is not a prefix of " + s3);
		}
	}
}
