# -*- coding: utf-8 -*-

"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 03.25.2021
Homework Problem #2.1.5
Perform BMI calculation by prompting user for weight and height.
"""

# Prompt users for weight in Kg and height in meters
weight, height = input("Enter weight in kilograms and height in meters: ").split()
# Convert weight and height into float
BMI = float(weight) / float(height) ** 2
# Display user BMI results
print("BMI for weight and height is", BMI)
