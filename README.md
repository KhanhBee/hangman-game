# Hangman Game

This is a Hangman game project written in Java as the final project of the CMSC150 class by Khanh Chu. The game randomly selects a word from a list of words, and the player must guess the letters of the word before running out of attempts.


## Getting started

Download all the three files "Hangman.java", "WordChoose.java", and "words.txt". After that, enter into the terminal like below to begin the game. 

```
javac Hangman.java
javac WordChoose.java
java Hangman
```


## How to play

The computer will choose randomly from a word bank in the "words.txt" file. You just have to guess the letters that are in the word.

With every incorrect guesses, the computer will draw one more part of the stickman's body on the hanger. You can only make 6 incorrect guesses before the game is over.

You win when you correctly guess every letter before the computer manage to complete the drawing.
