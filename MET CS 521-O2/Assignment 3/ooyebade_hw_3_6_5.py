# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/2/2021
Homework Problem #3.6.5
Create a text file with a single sentence of 20 words. 
The program must read and write the words in a new text file composed of four 
lines of five words.
"""

try:
    # open the test file in read mode
    sampleFile = open("test.txt", "r")
    data = sampleFile.read().split() # read the words and split them
    
    if len(data) != 20: # if sentence greater than 20 words, error
        print("Error. Sentence exceed 20 words")
    else:
        newFile = open("test2.txt", "w") # create a new file
        count = 0
        for x in data: # after every 5 words, add new lines
            newFile.write(x + " ")
            count += 1
            if (count == 5):
                newFile.write("\n\n")
                count = 0
        # close all files
        newFile.close()
        sampleFile.close()
# if file does not exist, exception handling
except FileExistsError:
    print("File does not exist")
    quit()                