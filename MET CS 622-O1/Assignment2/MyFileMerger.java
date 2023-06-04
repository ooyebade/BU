import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Elizabeth Oyebade
 * Assignment 2
 * 05/24/2022
 *
 * The purpose of this assignment is to merge multiple single files into a single file. Then within
 *      the merged file, search for the provided keywords and print out its close_date and
 *      funds_raised_percent.
 */
public class MyFileMerger {

    // constants
    static final String mergeFilePath = "mergedFile.json";
    static final String filePath1 = "file1.json";
    static final String filePath2 = "file2.json";
    static final String filePath3 = "file3.json";


    public static void main(String[] args) throws IOException {

        // reading from the three given files and writing them into the merged file
        newFileReaderAndWriter(filePath1);
        newFileReaderAndWriter(filePath2);
        newFileReaderAndWriter(filePath3);
        // searching for the provided keywords in the merged file
        searchKeywords();
    }

    /**
     * This method is reading the content from multiple and writing the content to the file that needs
     *      to be merged
     * @param fileNamePath represents the main method to read the file from
     */
    private static void newFileReaderAndWriter(String fileNamePath) throws IOException {
        // initializing the br variable
        // initializing the bw variable

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(mergeFilePath, true));
             BufferedReader br = new BufferedReader(new FileReader(fileNamePath))) {
            // creation of the BufferWriter object
            // set append to true with the new filewriter file
            // creation of the BufferReader object
            // the fileNamePath with the filereader object

            // creating a new variable with the value of an empty string
            String line;
            // using the while loop to check the content from the file
            while ((line = br.readLine()) != null) {
                bw.write(line + "\n");
            }
            // catch handle exception
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // print the exception details
        } // the finally block always executes
    }

    /**
     * This method is reading the content of the merged text file and then searching for the keywords
     */
    private static void searchKeywords() throws IOException {
        // initializing the br variable
        BufferedReader br = null;
        // using the try/catch method to handle the exceptions
        try {
            // creating a new variable with the value of an empty string
            String content;
            // creation of the BufferReader object
            br = new BufferedReader(new FileReader(mergeFilePath));
            // using the while loop to check the content from the file
            while ((content = br.readLine()) != null) {
                // passing each line of the searched content
                keywordsSearch(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally { // the finally block always executes
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * This method is being used to search for the keywords in each line using the regex method
     * @param line represents the given keywords that needs to be searched in each line
     */
    private static void keywordsSearch (String line) {
        // create a list object
        List<Pattern> keywords = new ArrayList<>();

        // add the keywords to the list
        // then compile the keywords to create pattern using compile() method
        keywords.add(Pattern.compile("robots"));
        keywords.add(Pattern.compile("fitness"));
        keywords.add(Pattern.compile("wearable"));

        // using the for loop to check whether the keywords match
        for(Pattern p: keywords) {
            // get a matcher object
            Matcher m = p.matcher(line);
            // using the .find method to search for the specific pattern
            if (m.find()) {
                stringToJsonObj(line);
            }
        }

    }

    /**
     * This method is going to convert string to json
     *
     * @param line represents the keywords that match previous method
     **/

    private static void stringToJsonObj(String line) {
        try {
            // creation of a new json object
            JSONObject js = new JSONObject(line);
            JSONObject data = js.getJSONObject("data");
            double funds_raised_percent = data.getDouble("funds_raised_percent");
            // print out funds_raised_percent
            System.out.println("funds_raised_percent: " + funds_raised_percent);
            // used optString instead of getSting because I wasn't sure whether the data was missing
            String close_date = data.optString("close_date");
            // print out close_date
            System.out.println("close_date: " + close_date);
        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}