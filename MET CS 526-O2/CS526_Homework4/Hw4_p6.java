/**
 * @author Elizabeth Oyebade
 * course MET CS 526-O2
 * date 04/12/2022
 */
import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Hw4_p6 {

    public static void main(String[] args) {
        insertAndSearchTime();
    }
    /**
     * Creating a HashMap instance, an ArrayList instance and a LinkedList instance.
     * Generating 100,000 distinct random integers in the range [1, 1,000,000] and
     *      storing them in the insertKeys array
     *
     * Generating 100,000 distinct random integers in the range [1, 2,000,000] and
     *       storing them in the searchKeys array
     */
    public static void insertAndSearchTime() {
        // creating the HashMap instance
        HashMap<Integer, Integer> myMap;
            // creating an empty HashMap
            myMap= new HashMap<>();
        // creating the ArrayList instance
        ArrayList<Integer> myArrayList;
            // creating an empty ArrayList
            myArrayList = new ArrayList<>();
        // creating the LinkedList instance
        LinkedList<Integer> myLinkedList;
            // creating an empty LinkedList
            myLinkedList= new LinkedList<>();

        long startTime, endTime, elapsedTime;
        // using long array to capture the variables for insert time and search time
        //      within the HashMap, ArrayList and LinkedList
        long[] insertTime = new long[3];
        long[] searchTime = new long[3];

        // initializing an int array to store the random numbers
        int[] insertKeys = new int[100000];
        int[] searchKeys = new int[100000];
        // generate new random numbers
        Random r = new Random();
        // repeat 10 times
        for (int i = 0; i < 10; i++) {
            // generating a sequence of random numbers using the Random instance
            //      for insert keys
            r.setSeed(System.currentTimeMillis());
            // storing the '100000' random integers
            for (int s = 0; s < 100000; s++) {
                insertKeys[s] = r.nextInt(100000) + 1;
            }

            // need an empty HashMap, ArrayList and LinkedList
            myMap.clear();
            myArrayList.clear();
            myLinkedList.clear();

            // HashMap for measuring the total insert time
            startTime = System.currentTimeMillis();
            for (int h = 0; h < 100000; h++) {
                // using the put method for HashMap
                myMap.put(insertKeys[h], h); //"1");
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            insertTime[0] += elapsedTime;

            // ArrayList for measuring the total insert time
            startTime = System.currentTimeMillis();
            for (int h = 0; h < 100000; h++) {
                // using the add method for ArrayList
                myArrayList.add(insertKeys[h]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            insertTime[1] += elapsedTime;

            // LinkedList for measuring the total insert time
            startTime = System.currentTimeMillis();
            for (int h = 0; h < 100000; h++) {
                // using the add method for LinkedList
                myLinkedList.add(insertKeys[h]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            insertTime[2] += elapsedTime;

            // generating a sequence of random numbers using the Random instance
            //      for search keys
            r.setSeed(System.currentTimeMillis());
            // storing the '100000' random integers
            for (int s = 0; s < 100000; s++) {
                searchKeys[s] = r.nextInt(200000) + 1;
            }

            // HashMap for measuring the total search time
            startTime = System.currentTimeMillis();
            for (int h = 0; h < 100000; h++) {
                // using the containsKey method gor HashMap
                myMap.containsKey(searchKeys[h]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            searchTime[0] += elapsedTime;

            // ArrayList for measuring the total search time
            startTime = System.currentTimeMillis();
            for (int h = 0; h < 100000; h++) {
                // using the containsKey method gor HashMap
                myArrayList.contains(searchKeys[h]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            searchTime[1] += elapsedTime;

            // LinkedList for measuring the total search time
            startTime = System.currentTimeMillis();
            for (int h = 0; h < 100000; h++) {
                // using the containsKey method gor HashMap
                myLinkedList.contains(searchKeys[h]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            searchTime[2] += elapsedTime;
        }

        // print the following output
        System.out.println("Number of keys = " + insertKeys.length + "\n");

        // print the following average insert time output
        System.out.println("HashMap average total insert time = " + insertTime[0]);
        System.out.println("ArrayList average total insert time = " + insertTime[1]);
        System.out.println("LinkedList average total insert time = " + insertTime[2]);

        System.out.println("\n");

        // print the following average search time output
        System.out.println("HashMap average total search time = " + searchTime[0]);
        System.out.println("ArrayList average total search time = " + searchTime[1]);
        System.out.println("LinkedList average total search time = " + searchTime[2]);
    }
}