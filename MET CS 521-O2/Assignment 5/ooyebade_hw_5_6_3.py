# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/16/2021
Homework Problem #5.6.3
Write a program that asks users to input three numbers in one request. In one
line, print the formula applied and result of the calculation.
"""

# ask users for three numbers
n1, n2, n3 = input("Enter 3 numbers with delimeter (','): ").split(",")
try:
    div = int(n1) / int(n2) # divide the first two numbers
    sum = div + float(n3) # add result with the third number
    print("Result {n1/n2}+n3 =", sum) # print result
except ZeroDivisionError as error: # check ZeroDivisionError
    print("Error. Try again: Second number value can't be zero", error)
except ValueError: # check ValueError
    print("Try again! Please enter three numbers.")    