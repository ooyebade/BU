# -*- coding: utf-8 -*-

"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 03.25.2021
Homework Problem #2.1.4
Prompt users for a number then convert the input into an integer and 
if user is even print 0, if user is odd print 1.
"""

num = input("Enter a number: ") # Read user number
num = int(num) # Convert input to integer
print(1 if num % 2 == 1 else 0) # Divide given input by 2