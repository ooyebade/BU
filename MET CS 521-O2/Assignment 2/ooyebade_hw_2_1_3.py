# -*- coding: utf-8 -*-

"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 03.25.2021
Homework Problem #2.1.3
Prompt users to enter a value and using a formula, print the
calculated input 
"""

# Ask user to enter an integer value
n = int(input("Please enter an integer: "))
# Convert int to string to print formula
s = str(n)
# Calculation
calc = (n+n*n+n*n*n+n*n*n*n)
# Print formula
print(f"{s}+{s}*{s}+{s}*{s}*{s}+{s}*{s}*{s}*{s}")
# Print calculations
print("Calculation: "+"{:,}".format(calc))
