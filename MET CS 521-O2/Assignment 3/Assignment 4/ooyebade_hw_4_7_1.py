# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/6/2021
Homework Problem #4.7.1
Using List Comprehension, find the sum of the even and odd integers in list L.
"""

# given list of integers
list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
# the sum of even with list comprehension
even = sum([x for x in list if x % 2 == 0])
# the sum of odd with list comprehension
odd = sum([x for x in list if x % 2 != 0])
print("Evaluating the numbers in:", list)
print("Even:", even) # print even result
print("Odd:", odd) # print odd result