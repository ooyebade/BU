# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/2/2021
Homework Problem #3.4.4
Prompt user to enter a three-digit whole number so the digits are ascending
and without duplicates. Keeping prompting till user gets it. 
"""

# begin the infinite while loop
while True:
    # ask user for an input
    num_x = input("Please enter a 3-digit number: ")
    # check if number is an integer
    if not num_x.isdigit():
        print("Error: This is not an integer. Please re-enter.")
    # check if user input 3-digits
    elif len(num_x) != 3:
        print("Error: You did not enter a 3-digit number.")
    # check for duplication
    elif len(set(list(num_x))) != len(list(num_x)):
        print("Your number contains duplication.")
    # check to see if numbers are in ascending order
    elif sorted(list(num_x)) != list(num_x):
        print("Error: The digits are not in ascending order.")
    else:
        print("Number Accepted!")
        break