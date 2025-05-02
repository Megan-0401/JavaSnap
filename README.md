<!-- _class: lead -->

# Java Project - Snap

---

## Overview

Your task is to model a card game using the Java language. We’ve broken this challenge down
into small parts, with the expectation that some of you will keep things simple and master the
basics, while some of you will push on into the stratosphere!

**Good Luck!**

---

## Stage 1 [x]

Using classes, ArrayLists and methods, create a deck of Cards. You should use the following
classes:

### CardGame [x]

- Contains an ArrayList\<Card\> for the deckOfCards that contains all 52 cards. This is created and populated when the game is constructed.
    - 13 cards of each suit
    - 4 cards of each symbol
    - 4 cards of each value
    - Each suit needs a card of one symbol and one value
    - ♠ (spade), ♥ (heart), ♦ (diamond), ♣ (club)

    - 3 array lists (Enum suit, String symbol, String value)
    - loop through each suit -> loop through each value -> add a new card to the deckOfCards with the suit, symbol and value

- Has a name which is also defined in the constructor.
- Has a getDeck method that lists out the cards in the deck.

### Card [x]

- Has a String suit. Use the unicode characters of heart, club, diamond and spade.
- Has a String symbol (2,3,4,5,6,7,8,9,10,J,Q,K,A)
- Has an int value (2,3,4,5,6,7,8,9,10,11,12,13,14)
- Has a toString method that describes the class

---

## Stage 2 [x]

Lets get some core functionality to our CardGame by implementing the following methods:

**Card dealCard()** [x]

Takes the card from the top of the deck and returns it.
- returns a Card (object)
- get Card from the first index of deckOfCards
- remove Card from deck

**ArrayList\<Card\> sortDeckInNumberOrder()** [x]

Sorts the deck in number order (e.g. 2222333344445555 etc) and stores the new shuffled deck back into the deckOfCards attribute.
- ~~create a class that implements the comparator interface~~
- create class that contains a static sortDeckByValue method
- if values are equal, sort by suit
- else, sort by value
- sort the deckOfCards using a method reference (cut down on code)

**ArrayList\<Card\> sortDeckIntoSuits()** [x]

Sorts the deck into suits (2,3,4,5,6,7,8,9,10,J,Q,K,A of hearts, then 2,3,4,5,6,7,8,9,10,J,Q,K,A of clubs etc.) and stores the new shuffled deck back into the deckOfCards attribute.
- ~~create a class that implements the comparator interface~~
- create class that contains a static sortDeckBySuit method
- if suits are equal, sort by value
- else, sort by suit
- sort the deckOfCards using a method reference (cut down on code)

**ArrayList\<Card\> shuffleDeck()** [x]

Shuffles the deck into a random order and stores the new shuffled deck back into the deckOfCards attribute.
- shuffle deckOfCards with the Collections interface method

---

### Stage 3 [x]

Create class for Snap that extends CardGame.

This class should use the methods defined
above, as well as some new ones, to enable the user to play the game snap according to the
following rules:

- By pressing enter in the command line, the user takes their turn. [x]
  - Method -> startSnap()
  - Prints "Welcome to snap!"
  - Call shuffleDeck() on deckOfCards
  - calls new Method -> getUserInput()
  - Create new Scanner
  - while deckOfCards is not empty, or snap has not occurred:
    - prints "Press enter key to show next card"
    - When Scanner reads enter input, call printCard()
    - Help used: https://stackoverflow.com/questions/18281543/java-using-scanner-enter-key-pressed
- Each turn, a new card is dealt from the deck. [x]
  - Method -> printCard()
  - calls dealCard() method, convert with toString()
  - print card to console
- The game continues until two cards in a row have the same symbol, at which point the “player” wins and the game ends. [x]
- new method -> EndGame()
- prints message "Snap! You win!"
- calls new method -> playAgain(), that asks user whether they'd like to play again
- if yes, call new method -> resetGame() that generates a new deck and calls startGame()
- if no, end program
  

### Stage 4 [ ]

Create a Player class and enable the snap game to be two player, with the users taking it in turns to go. If the snap occurs on the users turn, they win. [ ]
- Player Class [x]
  - fields -> player id and player name
  - getters -> playerId, playerName
- In Snap Class [x]
  - create field -> ArrayList<Player> playerList
  - create a method that constructs the two players and stores them into the playerList
  - create a method that swaps whose turn it is, using a global field and if statement
  - update getUserInput() and endGame() method to print the current player
  - create a method that deals the first card automatically (so player one doesn't waste a turn dealing first card)

Add a timer so that when there is a snap opportunity, the player has 2 seconds to submit the word “snap” in order to win. If they don’t type it in time, they lose. [ ]

---
