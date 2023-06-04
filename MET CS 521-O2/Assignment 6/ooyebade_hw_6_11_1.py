# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/24/2021
Homework Problem #6.11.1
Write a program that has a class called 'Sentence' which has a constructor that
takes a sentence string as an input, and contains the provided class methods. 
"""

class Sentence:
    # constructor that takes sentence string as input
    def __init__(self, sentence = ""):
        self.__sentence = sentence
    # provided class method    
    def get_all_words(self):
        # return all the words in the sentence as a list
        return self.__sentence.split()
    # class method with the 'index' argument
    def get_word(self, index):
        # return only the word at a particular index in the sentence
        return self.__sentence.split()[index]
    # class method with the 'index' and 'new_word' argument
    def set_word(self, index, new_word):
        # update word at the index in sentence with new_word
        word = self.__sentence.split()
        word[index] = new_word
        self.__sentence = ' '.join(word)
    def __str__(self):
        # return the sentence as a string using the built-in method
        return str(self.__sentence)
    
if __name__ == "__main__":
    # create instance of Sentence
    s = "Hello, this is the sample test case."
    sentence = Sentence(s)
    # use assert to check for errors
    # testing that get_all_words correctly returns that sentence as a list
    assert sentence.get_all_words() == ["Hello,","this","is","the","sample","test","case."]
    # testing that get_word(#) correctly returns the # word in the sentence
    assert "Hello," == sentence.get_word(0) and "is" == sentence.get_word(2) and "test" == sentence.get_word(5)
    # testing that set_word() actually changes a word in the sentence object
    # print word before replacing
    print("Word before replacing:", sentence)
    sentence.set_word(4, "new-fast")
    assert str(sentence) == "Hello, this is the new-fast test case."
    print("Word after replacing:", sentence)