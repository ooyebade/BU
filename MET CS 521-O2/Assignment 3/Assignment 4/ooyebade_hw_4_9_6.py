# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/9/2021
Homework Problem #4.9.6
Create a program that ask users for a number, validate the number, re-prompt on
error, convert the number to words using dictionary and print out the converted
numbers as words.
"""

#stored dict
dic_num = {"-": "Negative", ".": "Point", "0": "Zero", "1": "One", "2": "Two", 
           "3": "Three", "4": "Four", "5": "Five", "6": "Six", "7": "Seven", 
           "8": "eight", "9": "Nine"}
while (True):
    n = -1
    num = input("Enter a number: ") # users input number
    for char in str(num):
        if char == ',': # if users enter commas
            n = 2
            print("Please try again without the comma.")
    if n == 2:
        continue    
    for char in str(num):
        # validate that a number was entered
        if (char.isnumeric()) or (char == ".") or (char == "-"): 
            n = 0
        else: 
            n = 1
    if n == 0:
        print("As Text:", end = " ")
        for char in str(num):
            print(dic_num[char], end = " ")
    else:
        print("This is not a valid number") # user did not enter a valid num