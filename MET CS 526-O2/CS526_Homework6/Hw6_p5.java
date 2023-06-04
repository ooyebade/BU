import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Elizabeth Oyebade
 * course MET CS-O2
 * date 04/26/2022
 */

public class Hw6_p5 {
    /**
     * Storing the follow relationships in an adjacency list.
     * The adjacency list is then being implemented as an ArrayList of nodes.
     */
    public static void main(String[] args) {
        // array list to save letters
        // initializing variables
        ArrayList<Node> adjacencyList = new ArrayList<>();

        // read files
        try {
            Scanner scanner = new Scanner(new File("follows_input.txt"));
            String[] str;
            // node is a person
            Node node;
            while (scanner.hasNext()) {
                // read all lines in txt file
                str = scanner.nextLine().replaceAll("\\s+", "").split(",");
                // creating a node object
                if (str.length == 1) {
                    // not following anyone
                    node = new Node(str[0], null);
                } else {
                    node = new Node(str[0], new ArrayList<>());
                    // Set letters in directly follows
                    node.directlyFollows.addAll(Arrays.asList(str).subList(1, str.length));
                }
                // storing nodes
                adjacencyList.add(node);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // calling allFollows for every adjacencyList node
        for (Node node : adjacencyList) {
            allFollows(node.letters, adjacencyList);
        }
    }

    /**
     * The method will print all people X directly follows and all people X indirectly
     * @param X represents the letters in the node
     * @param adjList as arraylist of the letters node
     */
    public static void allFollows(String X, ArrayList<Node> adjList) {
        // searching for the node to X and then assign it to nodeX
        Node nodeX = null;
        for(Node node : adjList) {
            if(node.letters.equals(X)) {
                nodeX = node;
                break;
            }
        }

        // if X does not exist, then bye
        if (nodeX == null){
            System.out.println(X + " doesn't exist in the adjacency list.");
            return;
        }


        if(nodeX.directlyFollows == null) {
            System.out.println(nodeX.letters + " indirectly follows {} ");
        } else {
            // all people X "indirectly follows"...initializing variables
            HashSet<String> processedNodes = new HashSet<>();
            ArrayList<String> indirectNodes = new ArrayList<>(nodeX.directlyFollows);

            // iterating over all the letters of nodes in the indirectNodes to find the 'indirectly follows'
            for(int i = 0; i < indirectNodes.size(); i++) {
                // do nothing and move to the next iteration
                // if node has been processed
                if (processedNodes.contains(indirectNodes.get(i))) {
                    continue;
                } else {
                    // add letters to current nodes
                    processedNodes.add(indirectNodes.get(i));
                    // searching for adjList nodes
                    for(Node node : adjList) {
                        // comes out to be true if found
                        if (node.letters.equals(indirectNodes.get(i)) && node.directlyFollows != null) {

                            // iterating over current nodes in directly follows
                            for (String s : node.directlyFollows) {
                                // do nothing and move to the next iteration
                                // if node has been processed
                                if (processedNodes.contains(s)) {
                                    continue;
                                } else {
                                    indirectNodes.add(s);
                                }
                            }
                            // stops for loops
                            break;
                        }
                    }
                }
            }

            // removing duplicates
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(indirectNodes);
            indirectNodes.clear();
            indirectNodes.addAll(linkedHashSet);

            // removing the directly follows
            for(String s : nodeX.directlyFollows) {
                indirectNodes.remove(s);
            }
            indirectNodes.remove(nodeX.letters);

            // printing the all letters in indirectly follows
            System.out.println(nodeX.letters + " indirectly follows " +
                    indirectNodes.toString().replace("[", "{")
                            .replace("]", "}"));
        }

        // print directly follows
        if(nodeX.directlyFollows == null) {
            System.out.println(nodeX.letters + " directly follows {} ");
        }
        else {
            System.out.println(nodeX.letters + " directly follows " +
                    nodeX.directlyFollows.toString().replace("[", "{")
                            .replace("]", "}"));
        }
    }

    public static class Node {
        String letters;
        ArrayList<String> directlyFollows;

        /**
         *
         * @param letters representing the letters
         * @param directlyFollows as arraylist of the letters node
         */
        Node(String letters, ArrayList<String> directlyFollows) {
            this.letters = letters;
            this.directlyFollows = directlyFollows;
        }
    }
}