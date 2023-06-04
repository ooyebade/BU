# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 3/31/2021
Homework Problem #3.4.2
Create a constant with an odd length string and print the entire string,
its length, and a middle character
"""

# declare the constant of an odd string 
odd_str = "A man a plan a canal Panama"
# place the string length into a variable
length_str = len(odd_str)
# print requirements if string length is odd
if len(odd_str) % 2 != 0:
    # print the length of the entire string
    print("My " + str(length_str) + "-character string is: " + odd_str + "")
    # print the middle character
    print("The middle character is: " + odd_str[len(odd_str)//2] + "")
    # print the 1st half of the string
    print("The 1st half of the string is: " + odd_str[:len(odd_str)//2] + "")
    # print the 2nd half of the srting
    print("The 2nd half of the sting is: " + odd_str[len(odd_str)//2:] + "")