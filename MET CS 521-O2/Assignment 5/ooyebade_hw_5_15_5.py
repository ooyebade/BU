# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/17/2021
Homework Problem #5.15.5
Write a program that calculate the amount of money in a savings account. 
"""

# first function definition
def calc_compound_interest(principal, int_rate, yrs):
    """ Calculate the amount in saving account given the principal, rate of
    interest and number of years"""
    amount = principal*((1 + int_rate)**yrs) # amount formula
    return amount # return the final amount in the saving account
# second function definition
def calc_compound_interest_recursive(principal, int_rate, yrs):
    """Calculate the principal after a year"""
    if yrs == 1:
        principal_after_1yr = principal*(1 + int_rate)
        return principal_after_1yr
    else:
        # calculated amount and duration decreased by 1 yr
        return calc_compound_interest_recursive(principal_after_1yr, 
                                                int_rate, yrs)
def equal_amounts(amount, amount_1):
    # checks if the two amounts are equal when rounded to 4 decimal places
    # convert to int
    amount = int(amount*1000)
    amount_1 = int(amount_1*1000)
    return amount == amount_1
# main program
if __name__ == "__main__":
    while True:
        try:
            # get the principal, rate of interest and number of years from users
            principal = float(input("Please enter principal amount: "))
            int_rate = float(input("Please enter interest rate (decimal): "))
            yrs = float(input("Please enter numbers of years: "))
            # stop program if invalid
            if yrs == 0:
                break
            # calculate final amount
            non_recursive_method_principal = calc_compound_interest(principal, 
                                                                int_rate, yrs)
            recursive_method_principal = calc_compound_interest_recursive(principal, 
                                                                int_rate, yrs)
            # print message
            print("Principal after " + str(yrs) + " (non-recursive): " +
                  "{:,.2f}".format(non_recursive_method_principal))
            print("Principal after " + str(yrs) + " (recursive): " +
              "{:,.2f}".format(recursive_method_principal))
            if equal_amounts(non_recursive_method_principal, recursive_method_principal):
                print("The two values are equal when rounded 4 decimal places")
        except (ValueError, NameError):
            print("Not Found")
            break