# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/9/2021
Homework Problem #4.9.5
Create 3 functions that prints appropriate descriptions of the provided 
function using docstring
"""

def letter_counts(string):
    """Functions should return a dictionary of the letters as keys and 
    frequency counts as values"""
    dic = {}
    for char in string: # each character in string
        if char != " ": # if char is not space
            if char in dic: # if char is in dic
                dic[char] += 1 # increase the count
            else:
                dic[char] = 1 # makes the count as 1
    return dic # return dictionary

def most_common_letter(string):
    """Functions return string of the most common letter"""
    dic = letter_counts(string) # re-call letter counts
    dic_value = max(dic.values()) # find the most occurring character
    return [k for k,v in dic.items() if v == dic_value],dic_value

def string_count_histogram(string):
    """Functions returns a list of the unique letters and print the letters
    as histogram"""
    dic = letter_counts(string) # re-call letter counts
    for k in sorted(dic): # print histogram and sort dictionary
        print(k * dic[k])
        
if __name__ == '__main__':
    input_val = "WWWAS IT A RAT I SAW" # string being analyzed 
    print("The string being analyzed is:" + str(input_val))
    # call function
    print("Dictionary of letter counts:", letter_counts(input_val))
    dic_value = most_common_letter(input_val)
    if len(dic_value[0]) == 1:
        print('Most frequent letter: "' + str(dic_value[0][0]) + 
              '" appears ' + str(dic_value[1]) + " times. ")
    else:
        print("Most frequent letter: " + str(dic_value[0]) + 
              " appears " + str(dic_value[1]) + " times. ")
    print("Histogram:"), string_count_histogram(input_val)