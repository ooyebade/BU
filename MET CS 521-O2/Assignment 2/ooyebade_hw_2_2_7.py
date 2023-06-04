# -*- coding: utf-8 -*-

"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 03.25.2021
Homework Problem #2.2.7
Rewrite the 'for loop' as a 'while loop'
"""

X = 10        
i = 1 # initialize counter
while (i <= X + 1): # iterate X
    if X % i == 0: # condition remains zero
        print(i)
    i += 1 # increment the loop
