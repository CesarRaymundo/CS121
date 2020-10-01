* Author: Cesar Raymundo 
* Class: CS121 Section #002
* Semester: Fall 2019

## Overview

The program will allow a user to play a game of TicTacToe against a computer on a GUI. 
The GUI also provides the move history from both of the players, the winner of the game,
and the option to start a new game.

## Compiling and Running

Instructions to Compile:

All project files should be in the same directory, which will Project5.
From the directory, start by typing "javac TicTacToeGUI.java" and hit enter.
Then, type "java TicTacToeGUI" hit enter again.
The file should be compiled and running, then for the complete functionality, play as a
game of Tic-Tac-Toe where you have the first move and are (X).

 
## Reflection (Project Development and Testing)
The issue I had with this project was the gameOver() method in the TicTacToe class. Once the choose() method was functionally working and had all other 
methods working, I noticed that I kept failing the unit tester that was provided for us. I wasn't sure why it was doing this at first when I 
was looking back at my code, but when I kept looking at the tester info and testing the GUI, I found my issue. The issue was inside my gameOver() method.
I had a nested to loop for each possibility X or O could win and also a tie, but I did not write it write. I had my nested if statements return true
after the first move instead of the last move for each possibility. After I changed the placement of when to return true or false for gameOver(), my program 
was functionally working and was passing all of the tests.

Parts I found challenging for this project was doing the gameOver() method. I knew I needed to access the 2D array, but I wasn't sure how to start it. After 
looking at a couple of notes and going back to a previous activity, I figured out how to check when I player gets 3 in a row. Now the next part was trying to 
figure out all the possibilities of where a player can win or get a tie and knowing where it is indexed in the 2D array. Another challenging part of the projcet 
was the choose method. I wasn't sure where to start for the local variables within the method. After listening to my instructor explaining that the method
should be able to switch turns between players and store the point where they clicked on the box, so it does not get picked again, I was able to put some of it 
together. I needed more help, so I went to the tutoring lab where they explained the rest to me where you store the point within an array and keep counting to the moves
that have reached 9.

I made sure my program ran by using the unit tester that was given to us for TicTacToeGame class. My program can handle bad input,
if a person tries to click twice on the same box, it will not count that as their turn and switch to the computer for their turn.
 
## Sources used
For this project, I used the textbook and our class notes. 