##Exception and File I/O with Collections

1. The memory means that it keeps the track of what has been searched. In simple words, you
need to store inputs which we give to the search.
2. This means the search criteria and timestamp, should be stored in a collection.
3. There should be a method to call and print the number of search terms, their timestamps,
and frequency

The purpose of this assignment is to keep track of the words that were searched in Assignment 2. In simple words, storing the inputs which was given to the search. Therefore, the search criteria and timestamp should be stored in a collection.

This assignment is developed using OOPs concepts such as *JSON Object*, *Try/Catch Block*, *collections* and *java.io classes such as BufferedReader, BufferedWriter and so on.* method

The MergeAndSearch.java has the following:

* A main method that is the starting point of execution for the program.
* The *newFileReaderAndWriter* method that is reading the content from multiple and writing the content to the file that needs to be merged.
* The *searchKeywords* method that is reading the content of the merged text file and then searching for the keywords.
* The *keywordsSearch* method that is being used to search for the keywords in each line using the regex method.
* The *stringToJsonObj* method that is going to convert string to json. 

The FileTracker.java has the following: 

* static LinkedHashMap<String, String> searchCriteria = new LinkedHashMap<>();
  * Used the **'LinkedHashMap'** object to contain the values based on the key
* static HashMap<String, Integer> searchFreq = new HashMap<>();
  * Used the **'HashMap'** object to store the data in pairs and then access them by an index of another type
* static HashSet<String> searchedItems = new HashSet<>();
  * Used the **'Set'** object to remove any duplicates from the keywords searched
* static ArrayList<String> files = new ArrayList<>();
  * Used the **'ArrayList'** object to collect the set in the json files
* The main method allows user to input the provided searched keyword that's provided in the data/.json files and then prints out the search criteria, frequency and timestamps.

The external library I used for this assignment is org.json.
* Downloaded from **https://jar-download.com/artifacts/org.json/json/20211205/source-code** 
* Documentation from **https://github.com/stleary/JSON-java**



