# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/7/2021
Homework Problem #4.9.4
Using the provided my_dict, write a program to print all the keys of key and 
value
"""

# provided my_dict
my_dict = {'a':15, 'c':18, 'b':20}
# print the keys
print("Keys:", end=" ")
for k in my_dict: # pass all key of my_dict set through keys
    print(k, end=" ")
# print the values
print("\nValues:", end=" ")
for v in my_dict: # pass all value of my_dict set trhough values
    print(my_dict[v], end=" ")    
# print all the keys and values pairs
print("\nKey value pairs:", end=" ")
print(my_dict)
# print all keys and values pairs in ascending order of key
print("Key value pairs ordered by key: ", sorted(my_dict.items(), 
                                                 key=lambda kv: kv[0]))
# print all keys and values pairs in ascending order of value
print("Key value pairs ordered by value: ", my_dict)