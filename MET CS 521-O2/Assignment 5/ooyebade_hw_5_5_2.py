# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/15/2021
Homework Problem #5.5.2
Write a program that gets users date and time as a string and display various
forms of date and time using the function is_valid_datetime().
"""

def is_valid_datetime(date_time): # function definition
    """Split the date and time in the string"""
    dateTime = date_time.split()
    date = dateTime[0].split("/")
    time = dateTime[1].split(":")
    # check to see if date and time are valid
    # check to see if date is invalid
    if date[0] > "12" or date[0] < "1":
        return False
    elif date[1] > "31" or date[1] < "1":
        return False
    elif date[2] < "1":
        return False
    # check to see if time is invalid
    elif time[0] > "23" or time[0] < "0":
        return False
    elif time[1] > "59" or time[1] < "0":
        return False
    elif time[2] > "59" or time[2] < "0":
        return False
    else:
        return True
# main program
if __name__ == "__main__":
    # ask users for date and time
    date_time = input("Enter a date time (MM/DD/YYYY HR:MIN:SEC): ")
    # call the function and store the value
    dt = is_valid_datetime(date_time)
    # split the string
    dateTime = date_time.split()
    date = dateTime[0].split("/")
    time = dateTime[1].split(":")
    # print result if function is true
    if dt == True:
        # print date
        print("\nDD/MM/YYYY is {}/{}/{}".format(date[1],date[0],date[2]))
        # print time
        print("\nHR:MIN:SEC is {}:{}:{}".format(time[0],time[1],time[2]))
        # print month and year
        print("\nMM/YYYY is {}/{}".format(date[0],date[2]))
        if time[0] < "12":
            print("\nThe time is AM")
        else:
            print("\nThe time is PM")
    # else print an error message
    else:
        if date[0] > "12" or date[0] < "1":
            print("\nInvalid: There can be only 12 months in a year.")
        elif date[1] > "31" or date[1] < "1":
            print("\nInvalid: There can be only 31 days in a month.")
        elif date[2] < "1":
            print("Invalid: There's no negative year.")
        elif time[0] > "23" or time[0] < "0":
            print("\nInvalid: There is only 24hrs (0-23) in a day.")
        elif time[1] > "59" or time[1] < "0":
            print("\nInvalid: There is only 60mins (0-59) in a hour.")
        elif time[2] > "59" or time[2] < "0":
            print("\nInvalid: There is only 60sec (0-59) in a min.")