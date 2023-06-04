# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 3/31/2021
Homework Problem #3.2.1
Find the totals and the range from 2 - 130 in scope for odd and even numbers
Find the totals and a list of the numbers for square and cube
"""

# creates the list for the range of numbers
start = 2
end = 130

# list to keep track of numbers
odd = []
even = []
square = []
cube = []

# use for statement through range
for x in range(start, end+1):
    if x % 2 != 0: # check for odd numbers & add it to the odd list
        odd.append(x)
    if x % 2 == 0: # check for even numbers & add it to the even list
        even.append(x)
    if round(x ** (1/2)) ** 2 == x: # add int to the square list
        square.append(x)
    if round(x ** (1/3)) ** 3 == x: # add int to the cube list
        cube.append(x)

# print the output
print("Checking numbers from {} to {}".format(start,end))
print("Odd ({}) : {}...{}".format(len(odd),odd[0],odd[-1]))
print("Even ({}) : {}...{}".format(len(even),even[0],even[-1]))
print('Square (' + str(len(square)) + '): ', end = '')
print(square)
print('Cube (' + str(len(cube)) + '): ', end = '')
print(cube)