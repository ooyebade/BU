# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/22/2021
Rock, Paper, Scissors Final Project
"""

import unittest
from ooyebade_info_user import Info

class TestUser(unittest.TestCase):
    def setUp(self):
        self.info = Info()
        self.username = "Liz"
        self.__wins = 2
        self.__losses = 1
        self.__ties = 2
    
    def get_username_test(self):
        assert(self.username == True)
    def get_userWins_test(self): 
        assert(self.__wins == True)
    def set_userWins_test(self, win): 
        self.assertEqual(self.__wins, 2)
    def get_user_ties_test(self): 
        assert(self.__ties == True)
    def set_user_ties_test(self, tie):
        self.assertEqual(self.__ties, 1)
    def get_userLosses_test(self):
        assert(self.__losses == True)
    def set_userLosses_test(self, loss): 
        self.assertEqual(self.__losses, 2)
    
if __name__ == "__main__":
    unittest.main()
    print("Passed unit test")