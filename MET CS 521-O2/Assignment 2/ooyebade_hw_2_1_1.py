# -*- coding: utf-8 -*-

"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 03.23.2021
Homework Problem #2.1.1
Input a number and then add 2, multiply by 3, 
subtract by 6 and divide by 3 to get the same number inputed.
"""

# Ask the user to enter a number
num_str = input("Enter your number: ")
# Store the given number into a variable
num_int = int(num_str)
# With the given number, add 2, multiply by 3
# subtract by 6 and divide by 3
calculated_num = (((num_int + 2) * 3) - 6) / 3
# Checking the inputed number with the calculated number using the IF statement
if (num_int == calculated_num):
    # If it equals, then print this result
    print("The value of the inputed number and calculated number matches")