Project #2: JukeboxHero

* Author: Cesar Raymundo 
* Class: CS121 Section #002
* Semester: Fall 2019

## Overview

The Jukebox Hero program will allow the user to open a music catalog file, 
then print stats about the catalog. Display the songs in the Catalog to the user, 
and search for songs within the catalog. 


## Compiling and Running

Instructions to Compile:

Start by typing "javac JukeboxHero.java" and hit enter.
Then, type "java JukeboxHero" hit enter again.
The file should be compiled and running, then it will ask the user for input to give an output.   

 
## Reflection (Project Development and Testing)

The first issue I had while doing this project was during the load catalog section while doing the try and catch
I wasn't able to get the program to catch FileNotFoundException. When I would put a filename that didn't exist,
the program wouldn't do anything. At first, I wasn't sure what went wrong, but after looking at the notes for file 
and parsing I realized what went wrong. I was comparing my code with the one given with the notes and realized that 
I did my brackets wrong within my code which caused to program just to stop running. After this, I was to get catch 
the error. Another issue I was having was with my search catalog. Every time I would search cheese within the music-
collection.csv file, it would print the whole list instead of the 2 songs containing "cheese". I looked over my code 
and after closely looking, I realized I had an unwanted semi-colon after the for each loop. I had "for("":"");{" when
the semi-colon shouldn't be there in the first place. That was giving my issue but after I removed that semi-colon
the search catalog worked.   

Parts I found challenging for this project was doing the analysis part of the program. I had a hard time finding an 
idea for how to have the console print out the stats about the file chosen. I knew that I had to use an ArrayList and the 
contains() method, but I couldn't have the console print out the proper analysis. With the help of a friend that is also
taking CS 121 in a different section. He showed me that in my code I wasn't using the if statements the right way to 
properly add the album and title name to the ArrayList I created. He taught me a simpler way to have. After he showed me
that way I was looking over it and it made sense why I would use that if statement to add strings in my ArrayList. 

I made sure my program ran by the test inputs given to us to use within the project 2 program. My program did not crash on 
any of these inputs and did the correct thing that it's supposed to on each of the cases. My program can handle bad input.
With what I have on my file, the console should prompt the user to do another input, because what the entered was an invalid
input.  My program can be idiot-proof, but it depends on the user. A person that is unfamiliar with the setup or doesn't know
what files work with this program can have issues with this. As of right now, they are none known issues on my program.
 
## Sources used
For this project, I did not use any outside sources. I used the textbook and our class notes.