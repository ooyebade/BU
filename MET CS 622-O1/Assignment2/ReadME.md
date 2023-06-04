##Exception and File I/O

1. Download some files from Indiegogo dataset available under this link:
   https://webrobots.io/indiegogo-dataset
2. Merge the content of all days into a single file, which will be a big file. If your hard disk cannot handle that, you can download it partially or keep it in separate file, but I need to see you are able to write a code to merge files.
3. Write a code to search for a given keyword, e.g., “robot”, “fitness”, “wearable” and the result should present “fund_raised_percent” and “close_date”. In other words, you are reading from file and presenting the output to the user in java console

The purpose of this assignment is to merge multiple single files into a big file. Then within the merged file, search for the provided keywords (robots, wearable, fitness) and print out its close_date and funds_raised_percent. 

This assignment is developed using OOPs concepts such as *JSON Object*, *Try/Catch Block* and *java.io classes such as BufferedReader, BufferedWriter and so on.* method

The MyFileMerger.java has the following:

* A main method that is the starting point of execution for the program. 
* The *newFileReaderAndWriter* method that is reading the content from multiple and writing the content to the file that needs to be merged.
* The *searchKeywords* method that is reading the content of the merged text file and then searching for the keywords.
* The *keywordsSearch* method that is being used to search for the keywords in each line using the regex method.
* The *stringToJsonObj* method that is going to convert string to json. 




