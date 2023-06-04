# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/7/2021
Homework Problem #4.9.3
Using zip, create a dictionary with the keys as the last names and the value 
as the first names.
"""

# first name list value
fn_list = ["Elizabeth", "Michelle", "David"]
# last name list value
ln_list = ["Oyebade", "Obama", "Black"]
# use zip() to convert lists to dictionary
dictionary = dict(zip(ln_list, fn_list))
# print result
print("First Name:", fn_list)
print("Last Name:", ln_list)
print("Name Dictionary:", dictionary)