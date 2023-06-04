import java.io.File;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Scanner;
import java.util.*;

/**
 * @author Elizabeth Oyebade
 * course MET CS-O2
 * Assignment 6 redo
 */

public class Hw6_p5redo {

    public static void main(String[] args) {

        try {
            // saving the letters in the file with an array list
            ArrayList<Node> adjList = new ArrayList<>();
            // reading the provided file
            Scanner scanner = new Scanner(new File("follows_input.txt"));
            while (scanner.hasNext()) {
                // reading all the provided lines in the txt file
                String[] src = scanner.nextLine().replaceAll("\\s+", "").split(",");
                // add new element to the array
                String arr = src[0];

                // allocating the node and putting in the arr
                Node node = new Node(arr);
                // iterating the src variable
                // defining new element
                // setting the direct follows letters
                node.directFollows.addAll(Arrays.asList(src));
                // adding node to the adjList using the first char in each line
                adjList.add(node);
            }
            // calling allFollows method
            // displayFollows(adjList);

            System.out.println();
            allFollows("A", adjList);
            allFollows("B", adjList);
            allFollows("C", adjList);
            allFollows("D", adjList);
            allFollows("E", adjList);
            allFollows("F", adjList);
            allFollows("G", adjList);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method is printing all the letters X directly and indirectly follows
     * @param X letters in the node
     * @param adjList arraylist of the letters node
     */
    public static void allFollows(String X, ArrayList<Node> adjList) {
        // initializing all X letters
        Set<String> processedLetters = new HashSet<>();
        ArrayList<String> directLetters = new ArrayList<>();
        Set<String> indirectLetters = new HashSet<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        // while the priority queue is empty
        while (priorityQueue.isEmpty()) {
            // then add the processed letters to the String X letters
            if (processedLetters.add(X)) {
                // searching for adjList nodes
                for (Node node : adjList) {
                    if (node.letters.equals(X)) {
                        for (String follows : node.directFollows) {
                            // adding the 'follows' within the directFollows node to the queue
                            priorityQueue.add(follows);
                            if (processedLetters.contains(follows)) {
                                continue;
                            }
                            else {
                                indirectLetters.add(follows);
                            }
                        }
                        // stop looping
                        break;
                    }
                }
            }
        }
        // print indirectly follows
        System.out.println(X + " directly follows " + indirectLetters.toString().replace("[", "{").replace("]", "}"));


        for (Node node: adjList) {
            if (node.letters.equals(X)) {
                directLetters = node.directFollows;
            }
            break;
        }
        // print directly follows
        System.out.println(X + " indirectly follows " + directLetters.toString().replace("[", "{").replace("]", "}"));
    }

    public static class Node {
        String letters;
        ArrayList<String> directFollows = new ArrayList<>();

        /**
         *
         * @param letters representing the letters in the follows_input.txt
         */
        public Node(String letters) {
            this.letters = letters;
            // this.directFollows = directFollows;
        }
    }
}
