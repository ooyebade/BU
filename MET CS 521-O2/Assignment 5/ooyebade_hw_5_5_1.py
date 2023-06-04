# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/15/2021
Homework Problem #5.5.1
Display the total vowels and consonants in a string using the return from the
function vc_counter(). 
"""

def vc_counter(string): # function definition
    """Assign dictionary of the counts a value"""
    dictCount = {"total_vowels":0, "total_consonants":0} 
    # using the for loop, iterate over each character in the string
    for char in string:
        if char.isalpha():
            # check to see if character is vowel
            if char in ["a","e","i","o","u","A","E","I","O","U"]:
                # set up vowels count in dictionary
                dictCount["total_vowels"] += 1
            else:
                # set up consonants count in dictionary
                dictCount["total_consonants"] += 1
    return dictCount
# main program
def main():
    # ask user for sentence
    string = input("Enter an English sentence: ")
    # call function
    dictCount = vc_counter(string)
    # display total vowels
    print("Total # of vowels in sentence:", dictCount["total_vowels"])
    # display total consonants
    print("Total # of consonants in sentence:", dictCount["total_consonants"])
main()