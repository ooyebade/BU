# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade 
Class: CS 521 - Spring 2
Date: 4/22/2021
Rock, Paper, Scissors Final Project
"""

"The Info class method holds the information of the player"
class Info:
    # the __init__ method
    def __init__(self, username, win = 0, loss = 0, tie = 0):
        self.username = username
        self.__wins = win
        self.__losses = loss
        self.__ties = tie
    
    # the __repr__ method
    def __repr__(self):
        return f"username{self.username}"
        
    def get_username(self): # get username method
        return self.username # return the value
    def get_userWins(self): # get wins of users method
        return self.__wins # return wins value
    def set_userWins(self, win): # set the wins of user method
        self.__wins = win 
    def get_user_ties(self): # get users ties method
        return self.__ties # return the ties value
    def set_user_ties(self, tie): # set the ties of the users method
        self.__ties = tie
    def get_userLosses(self): # get losses of users method
        return self.__losses # return losses value
    def set_userLosses(self, loss): # set the losses of users method
        self.__losses = loss
    
    # get the rounds played method and return the current round #
    def get_round(self):
        """ Return the Wins, Losses, and Ties of the user"""
        return self.get_userWins() + self.get_user_ties() + self. get_userLosses()

import pickle
from operator import itemgetter

class User:
    def __init__(self):
        self.user_list = [] # store the name of each users
        self.__RPS_filename = "rps.txt"
        
    def loadUser(self):
        try:
            # read the list of users using pickle
            self.user_list = pickle.load(open(self.__RPS_filename, "rb"))
        except:
            None
    
    def saveUser(self):
        # write the list of user using pickle
        pickle.dump(self.user_list, open(self.__RPS_filename, "wb"))
                        
    def createUser(self, username):
        """Takes in the username and see if the user exist and 
        if the user exist, return false and if it doesn't, add
        it to the user_list method and return true"""
        for user in self.user_list:
            # if user already exist
            if user.get_username() == username:
                print("Try again! This user already exists.")
                return False
        # create the player objective
        newuser = Info(username, 0, 0, 0)
        # append the new user
        self.user_list.append(newuser)
        return True
    
    def readUser(self, username):
        """This method accepts a string and returns a boolean and the players
        objective"""
        user_found = None
        for user in self.user_list:
            # compare each user to the username
            if user.get_username() == username: 
                user_found = user
        # print error, if user does not exist
        if user_found is None:
            print("Try again! The user doesn't exist.")
            return False, user_found
        else:
            return True, user_found
        
    def updateUser(self, user):
        """Takes the names in the user list and update the wins, losses, and 
        ties of the user"""
        user_found = None
        for eachUsers in self.user_list:
            if eachUsers.get_username() == user.get_username():
                user_found = user
        if user_found is None:
            print("Try again! The user doesn't exist.")
        # update the current users stats in the user list to the new stats
        else:
            user_found.set_userWins(user.get_userWins())
            user_found.set_userLosses(user.get_userLosses())
            user_found.set_user_ties(user.get_user_ties())
        
    def display_highScores(self):
        """Takes the users in the list and creates a ranking of the wins % 
        based on the wins divided by each round"""
        temp_list = [] # create an empty list
        for user in self.user_list:
            # create a temporary list of tuples
            temp_list.append((user, user.get_userWins() / user.get_round()))
            # sort the list
            temp_list.sort(key = itemgetter(-1))
            # display the list
            print("Rank    Name    Win%    Wins    Ties    Losses")
            print("----    ----    ----    ----    ----    ------")
            for x in range(len(temp_list)):
                print("{0:2}{1:>10}{2:8.2f}{3:5}{4:5}{5:8}"
                      .format(x + 1, temp_list[x][0].get_username(), 
                               temp_list[x][1], temp_list[x][0].get_userWins(),
                               temp_list[x][0].get_user_ties(), 
                               temp_list[x][0].get_userLosses()))