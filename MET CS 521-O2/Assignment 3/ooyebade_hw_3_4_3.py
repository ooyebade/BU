# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 3/31/2021
Homework Problem #3.4.3
Prompt user for a sentence and calculate the numbers for uppercase, lowercase
letters, digits and punctuation. 
"""

# ask users for an input
x_sentence = input("Please enter a sentence: ")
# list of punctuation to check 
punc_list = ['!' , "," , "\"" ,";" , "\"", "." ,"-", "?", "$", "&"]
# intialize the each characters with 0
uppercase_let = 0
lowercase_let = 0
digits = 0
punc = 0
# calculate each characters
for char in x_sentence:
    if char.isupper():
        uppercase_let += 1
    if char.islower():
        lowercase_let += 1
    if char.isnumeric():
        digits += 1
    if char in punc_list:
        punc += 1

# display the data
print("# Upper # Lower # Digitals # Punct.")
print("-------- -------- -------  --------")
print("   {}       {}       {}          {}""".format(uppercase_let, 
                                                     lowercase_let, 
                                                     digits, punc))
        