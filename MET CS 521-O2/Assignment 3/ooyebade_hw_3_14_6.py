# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/4/2021
Homework Problem #3.14.6
Read the student file line by line and store the records in lists or tuples. 
Print the created array. 
"""

try:
# open the text file in read mode
    student_file = open("student.txt", "r")
    studentArray = [] # list to store student list
    for line in student_file: # reading the file line by line
        record_list = line.strip().split(",")
        studentArray.append(record_list) # add list into list called studentArray
        print(studentArray, "\n\n") # print list result
    student_file.close()
# if file does not exist, exception handling
except FileExistsError:
    print("File does not exist")
    quit()