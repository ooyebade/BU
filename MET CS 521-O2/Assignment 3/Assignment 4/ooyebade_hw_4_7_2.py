# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/7/2021
Homework Problem #4.7.2
Generate a new list with the same number of elements as the original list so 
each integer in the new list is the sum of its nearest neighbors and itself from
the original list. 
"""

# original list initialized with its values
original_list = [10, 20, 30, 40, 50]
# create a empty new list
new_list = []
# use the for loop 
for x in range(len(original_list)):
    # first element
    if x == 0:
        # append the original list
        new_list.append(original_list[x] + original_list[x+1])
    # last element 
    elif x == len(original_list) - 1:
        new_list.append(original_list[x] + original_list[x-1])
    # all other elements
    else:
        new_list.append(original_list[x]+original_list[x+1]+original_list[x-1])
# print original result list
print("Input List:", original_list)
# print new result list
print("Result List:", new_list)     