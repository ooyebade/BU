# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/16/2021
Homework Problem #5.8.4
Write a program that asks user for a file name, read the file and convert the 
words into a list.
"""

def list_to_once_words(x_file): # function declaration
    """Create list to store single time words from the file"""
    onceWordsList = [] # list of words, needs to be empty
    #use for loop to read file
    for words in x_file:
        words = words.lower() # make words lowercase
        # if count of words is 1
        if x_file.count(words) == 1:
            onceWordsList.append(words) # add the words to the file
    return onceWordsList # return the list
# main function
words_list = [] # empty list to store the words
fname = input("Enter the file name: ") # ask user for file name
try:
    text_file = open(fname, "r") # open text file in read mode
except FileNotFoundError: # print file error, if it occurs
    print("The file",fname,"doesn't exist.")
else:
    # use for loop over the text file
    for line in text_file:
        line = line.strip() # strips off extra spaces
        if len(line) != 0: # if line is empty
            line = line.split() # split the words
            # use for loop over the words
            for words in line:
                words_list.append(words) # add the words to the words list
    text_file.close() # close the text file
    # print the result
    print("\nWords that occurred in list only once in the file:\n")
    print(list_to_once_words(words_list))