
import java.io.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Elizabeth Oyebade
 * 05.31.2022
 * MET CS 622-01
 * Assignment 3
 *
 * The purpose of this method is to merge all the files provided into one single file.
 * The purpose of this method is to search for the keywords in the merged file.
 */

public class MergeAndSearch {

    // constants
    public static final String mergeFile = "data/mergedFile.json";
    static final String file1 = "data/file1.json";
    static final String file2 = "data/file2.json";
    static final String file3 = "data/file3.json";

    public static void main(String[] args) throws IOException {
        /* Added three .json files into the project with an empty merge.json file which will then
          contain the results of the three .json files. */
        newFileReadAndWrite(file1);
        newFileReadAndWrite(file2);
        newFileReadAndWrite(file3);
        searchKeywords();
    }

    public static void newFileReadAndWrite(String fileName) throws IOException{
        // declaring the bufferReader instance
        BufferedReader br = null;
        // declaring the bufferWriter instance
        BufferedWriter bw = null;

        try {
            // creation of the BufferWriter object
            // set append to true with the new filewriter file
            bw = new BufferedWriter(new FileWriter(mergeFile, true));
            // creation of the BufferReader object
            // the fileNamePath with the filereader object
            br = new BufferedReader(new FileReader(fileName));
            // declaring the string variable that's going to be used in the new file
            String line;
            // checking bufferReader
            // using the while loop to check the content from the file
            while ((line = br.readLine()) != null) {
                // checking bufferWriter
                bw.write(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
            else if (bw != null) {
                bw.close();
            }
        }
    }

    /**
     * This method is reading the content of the merged text file and then searching for the keywords
     */
    public static void searchKeywords() throws IOException {
        // initializing the br variable
        BufferedReader br = null;
        // using the try/catch method to handle the exceptions
        try {
            // creating a new variable with the value of an empty string
            String content;
            // creation of the BufferReader object
            br = new BufferedReader(new FileReader(mergeFile));
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
    public static void keywordsSearch (String line) {
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

    public static void stringToJsonObj(String line) {
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