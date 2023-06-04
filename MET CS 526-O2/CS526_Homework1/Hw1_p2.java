/**
 * @author Elizabeth Oyebade
 * @course MET CS 526-O2
 * @date 3/22/2022
 */

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Hw1_p2 {

	/**
	 * The findByMake method will take the Car objects as an array and the make as a parameter
	 * Find and print all cars in the array that have the same make as the given make.
	 * Print an appropriate message if there is no car with the given make
	 */
	public static void findByMake(Car[] cars, String make) {
		// implement this method
		// the for loop to iterate through the array
		boolean found = false;
		for(int i=0; i<cars.length; i++) {
			// calling the getMake method from the Car.java file
			String cMake = cars[i].getMake();
			// if the car make passes and the car object is equal
			if (cMake.equals(make)) {
				// then print the object
				System.out.println(cars[i]);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No cars with the given make was found!");
		}
	}

	/**
	 * The olderThan method will take the Car objects as an array the year as a parameter
	 * Find and print all cars in the array that are older than the given year (in other words, the cars made earlier than the given year).
	 * Prints an appropriate message, if there is no car older than the given year.
	 */
	public static void olderThan(Car[] cars, int year) {
		// implement this method
		// the for loop to iterate all the cars
		boolean found = false;
		for (int i=0; i<cars.length; i++){
			// if the car object is less than the given year
			if (cars[i].getYear() < year) {
				// then print
				System.out.println(cars[i]);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No cars older than the given year was found!");
		}
	}
	
	public static void main(String[] args) throws IOException {

		// complete this part
		// create an array of Car objects, cars, of size 10
		// array creation
		Car[] cars = new Car[10];
		// read input file and store 10 car Objects in the array
		// the car_input.txt file must be in the current directory
		File file = new File("car_input.txt");
		// use the Scanner class to read through the file
		Scanner input = new Scanner(file);
		for (int i=0; i<cars.length; i++) {
			// storing the current line into a string
			String readLine = input.nextLine();
			// creating a string array to read the strings
			String[] arrayLine = readLine.split(",\\s+");
			// storing 'make' into its own string variable
			String make = arrayLine[0];
			// converting string into integer
			// then storing 'price' into its own integer variable
			int price = Integer.parseInt(arrayLine[1]);
			// storing 'year' into its own integer variable
			int year = Integer.parseInt(arrayLine[2]);

			// creating a new car object
			Car newC = new Car(make, year, price);
			// storing the new car object into a car array
			cars[i] = newC;
		}
		input.close();

		System.out.println("\nAll cars:");
		for (int i=0; i<cars.length; i++) {
			System.out.println(cars[i]);
		}
		
		String make = "Honda";
		int year = 2017;
		
		System.out.println("\nAll cars made by " + make);
		findByMake(cars, make);
		System.out.println("\nAll cars made before " + year);
		olderThan(cars, year);
	}

}
