Project #3: LibraryOfBooks

* Author: Cesar Raymundo 
* Class: CS121 Section #002
* Semester: Fall 2019

## Overview

The LibraryOfBooks program will allow the user to add a book\s within the libray, 
then print info within the library. Ability to read the book in the library, 
and being able to delete a book at a certain index. 

## Compiling and Running

Instructions to Compile:

All project files should be in the same directory, which will Project 3.
From the directory, start by typing "javac LibraryOfBooks.java" and hit enter.
Then, type "java LibraryOfBooks" hit enter again.
The file should be compiled and running, then follow the prompts to read, delete, 
add, and print books from the library.   

 
## Reflection (Project Development and Testing)

The first issue I had while doing this project was while I was making my Book.java class. I finished writing up 
the code I was going to use the unit tester to see if I wrote all the class right, but for some reason my unit 
tester had errors within it and would let me run it. At first I wasn't sure, because I downloaded the file straight
from github. After further analysis, I saw that I forgot to make a constuctor for a book object, after seeing this
I went back to my book class and made a constuctor for a book object. I was able to run the test after that, but
my class would fail, I saw that it couldn't get the information about for the text files I had within my project 
3 file. I wasn't sure why it was doing this, but with talking with an LA I found out that I needed a file that was 
name etext that had all the text files I needed for the project. After I did this, I was able to pass my unti tester
and move on with the project.
 
Parts I found challenging for this project was doing the isValid() method within the book class and making the driver class
with methods to use for the main method. For the isValid() method, it would keep failing after each unit test. At first I wasn't
really sure why it was doing this since I refered back to one of my activities for reference and class notes. Everything seemed 
to make sense to me. I was using if-statements and returned a statement. Then after carefully looking over my code, I thought 
of doing a nested if-statement that checks that every attribute of the song have a value and then checks is the file exists. 
After writing that and using the tester again, my class passed and from there I was ready to move on. Another part I found 
challenging was making methods within my driver class. I do realize that this was not required to do for the project, but I 
did see that this was part of the extra credit for the last project, so I figured to try to do it this way. I was having trouble
making it all work within the main method. I made my scanner and library in the main method and had switch statement and the methods
I created in the each case. When I ran my driver class, I wasn't able to do any of my options in the console. I would write something
and the program would not do anyhting. After going into the tutor room, I realized that my methods needed the information of the scanner
and library passed down to them in order to work. After changing this, my program was able to take the input and do what it's suppose to.

I made sure my program ran by using the unit testers that were given to us. And for my driver class I made sure it worked by downloading 
the test file that was given to us as well. My program can handle bad input. With what I have, the console should prompt the user to do 
another input, because what the entered was an invalid input. My program can be idiot-proof, but it depends on the user. A person that 
is unfamiliar with the setup or doesn't know what files work with this program can have issues with this. As of right now, they are none 
known issues on my program.
 
## Sources used
For this project, I did not use any outside sources. I used the textbook and our class notes.