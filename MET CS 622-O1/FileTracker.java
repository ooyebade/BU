import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Elizabeth Oyebade
 * 05.31.2022
 * MET CS 622-01
 * Assignment 3
 *
 * The purpose of this program is to keep track of the words that were searched in Assignment 2.
 * In simple words, storing the inputs which was given to the search. Therefore, the search criteria
 * and timestamp should be stored in a collection.
 * Finally, printing out the number of search terms, their timestamps, and frequency.
 */

public class FileTracker {

    // using 'static' so the objects can be accessed from both within and outside the class
    // creating a collection that will store the search criteria, keywords searched and search frequency
    // using the 'LinkedHashMap' object to contain the values based on the key
    static LinkedHashMap<String, String> searchCriteria = new LinkedHashMap<>();
    // using the 'HashMap' object to store the data in pairs and then access them by an index of another type
    static HashMap<String, Integer> searchFreq = new HashMap<>();
    // using the 'Set' object to remove any duplicates from the keywords searched
    static HashSet<String> searchedItems = new HashSet<>();
    // using the 'ArrayList' object to collect the set in the json files
    static ArrayList<String> files = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // String input
        String file1 = "data/file1.json";
        String file2 = "data/file2.json";
        String file3 = "data/file3.json";
        String mergeFile = "data/mergedFile.json";

        // using the add method to add the files above into the set
        files.add(file1);
        files.add(file2);
        files.add(file3);
        files.add(mergeFile);

        // using 'Scanner' to obtain the input
        Scanner input = new Scanner(System.in);
        boolean searched = true;
        String keywords;
        String userSelects;

        while (searched) {
            System.out.println("Enter keyword to search: ");
            keywords = input.nextLine();

            System.out.println("Search Timestamps");
            String pattern = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date saveTimeNow = new Date();
            // formatting the time/date
            String formatDateTime = sdf.format(saveTimeNow);
            String timeStamp = "\nTimestamp: " + formatDateTime + " ";
            String keywrd = " Searched Keyword: " + keywords;
            searchCriteria.put(timeStamp, keywrd);

            System.out.println(searchCriteria);

            System.out.println("Search Frequencies: ");
            if (searchFreq.containsKey(keywords)) {
                int freq = searchFreq.get(keywords);
                searchFreq.put(keywords, freq + 1);
            } else {
                searchFreq.put(keywords, 1);
            }

            System.out.println(searchFreq);

            System.out.println("Amount of searched terms");
            searchedItems.add(keywords);
            System.out.println(searchedItems);

            System.out.println("Do you want to try again");
            userSelects = input.nextLine();
            if (userSelects.equalsIgnoreCase("Yes")) {
                continue;
            }  if (userSelects.equalsIgnoreCase("Nope")) {
                searched = false;
                input.close();
            } else {
                System.out.println();
            }
        }
    }

}