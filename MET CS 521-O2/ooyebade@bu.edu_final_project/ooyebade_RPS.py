# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/20/2021
Rock, Paper, Scissors Final Project 
"""

from ooyebade_info_user import User
from random import randint

user = User()
user.loadUser()

# definiton method to start game
def startGame(playerObj):
    gameChoice = "\n" "1. Rock\n" "2. Paper\n" "3. Scissors\n"
    #display the round
    print("Round " + str(playerObj.get_round() + 1) + "\n" + gameChoice)
    # prompt the user and read the options
    userChoice = int(input("What's your choice? "))
    # generate random choice for the computer
    computerChoice = int(randint(1,3))
    # define list of strings
    game = ["Rock", "Paper", "Scissors"]
    # hold the user winning status
    # if users and computer select the same choice
    if computerChoice == userChoice:
        playerObj.set_user_ties(playerObj.get_user_ties() + 1)
        print("Both user and computer picked " + game[userChoice - 1] + 
              ". So, It's a TIE...")
    elif (computerChoice > userChoice):
        playerObj.set_userLosses(playerObj.get_userLosses() + 1)
        print("Oops! You LOSE. You chose " + str(userChoice) + 
              " and computer chose " + str(computerChoice))
    else:
        playerObj.set_userWins(playerObj.get_userWins() + 1)
        print("Thank God! You WIN. You chose " + str(userChoice) + 
              " and computer chose " + str(computerChoice))

# definiton method to play the game
def playGame(userGame, userName, playerObj):
    """String holding the menu options after users start a new game"""
    while True:
        # print game menu
        print("Rock, Paper, Scissors Game Menu")
        print("-------------------------------")
        print("1. Play a round")
        print("2. View Stats")
        print("3. Exit")
        # prompt the user and read the options
        userChoice = int(input("What would you like to do??? "))
        # call the startGame function to begin the round
        if userChoice == 1:
            startGame(userGame)
        # display users stats
        elif userChoice == 2:
            print("Username: ", userName)
            print("Win   Losses   Ties")
            print("---   ------   ----")
            print("{0}   {1:6}    {2:6}".format(userGame.get_userWins(),
                                              userGame.get_userLosses(),
                                              userGame.get_user_ties()))
        else:
            # update the user info
            # and break the loop
            playerObj.updateUser(userGame)
            print()
            break
 
# main program 
if __name__ == "__main__":
    # deine player objective for the user class
    playerObj = User()
    # load the users from the file
    playerObj.loadUser()
    userName = ""
    while True:
        # Menu Options
        mainMenu_options = "Welcome to Rock, Paper, Scissors!\n" \
                            "---------------------------------\n" \
                            "1. Start a Game\n" \
                            "2. Load a Game\n" \
                            "3. Display High Score\n" \
                            "4. Exit\n"
        # display the menu above
        print(mainMenu_options)
        # prompt and read the menu options above
        options = int(input("What you wanna do??? "))
        # if users select option 1
        if options == 1:
            userName = input("Enter your name: ")
            # create user by calling a method
            playerObj.createUser(userName)
            # call a method to read user
            userGame = playerObj.readUser(userName) [1]
            # input age limit
            user_age = int(input("Enter your age: "))
            if user_age >= 15:
                print("You're eligible to play")
            else:
                print("Bye! Be GONE...\n")
                break
            print("Hi, " + userGame.get_username() + " Let's Play RPS!!!\n")
            playGame(userGame, userName, playerObj)
        # if users select option 2
        elif options == 2:
            # read the player name
            userName = input("What's your name? ")
            userGame = playerObj.readUser(userName) [1]
            if userGame is None:
                continue
            print("\nWelcome back. " + userGame.get_username() + 
                  " Let's Continue!\n")
            playGame(userGame, userName, playerObj)
        # if users select option 3
        elif options == 3:
            playerObj.display_highScores()
        # lastly, if users select option 4
        elif options == 4:
            # save and exit game
            playerObj.saveUser()
            break
        # print an error messgae if users select wrong options
        else:
            print("Please select appropriate option. Thank you!")