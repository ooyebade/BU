# -*- coding: utf-8 -*-

"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 03.25.2021
Homework Problem #2.2.6
Calculate leap year from 1899 to 2021 using a 'for loop' and 'while loop'.
"""

for year in range(1899, 2021): # iterate between 1899 and 2021
    if (year % 4 == 0) and (year % 100 == 0) or (year % 400 != 0): # determine the factors
        print(year, end = ",") 
        
i_year = 1899 # initialize the year 1899
while (i_year < 2021): # iterate 2021
    if (i_year % 4 == 0) and (i_year % 100 == 0) or (i_year % 400 != 0): # conditions remains the same
        print(i_year, end = ",")
    i_year += 1 # increment the loop 