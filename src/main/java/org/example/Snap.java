package org.example;

import java.util.Scanner;

public class Snap extends CardGame{
    private Scanner scanner = new Scanner(System.in);
    private Card currentCard;
    private Card previousCard;

    public Snap() {
    }

    public void printCard(String card, String prevCard){
        if(!prevCard.isEmpty()){
            System.out.println("PREVIOUS CARD: " + prevCard);
        }
        System.out.println("NEXT CARD: " + card);
    }

    public void startSnap(){
        System.out.println("Welcome to snap!");
        System.out.println("Match two cards with the same symbol in a row to win!");
        this.deckOfCards = shuffleDeck();
        getUserInput();
    }

    //resets snap status if user plays again
    private void resetGame(){
        System.out.println("Starting new game...");
        this.deckOfCards = generateDeck();
        this.previousCard = null;
        this.currentCard = null;
        startSnap();
    }

    public void dealNewCard(){
        String previousCardToString;
        if(this.previousCard == null){
            previousCardToString = "";
        } else{
            this.previousCard = this.currentCard;
            previousCardToString = this.previousCard.toString();
        }
        this.currentCard = dealCard();
        printCard(this.currentCard.toString(),previousCardToString);
    }

    public boolean checkForSnap() {
        if(!(this.previousCard == null)){
            if(this.currentCard.getValue() == this.previousCard.getValue()){
                return true;
            }
        }
        return false;
    }

    public void endGame(){
        System.out.println("Snap! You win!");
        playAgain();
    }

    public void playAgain(){
        //boolean inputIsValid = false;
        System.out.println("Would you like to play again? Y/N");
        String userInput = scanner.nextLine();
        while(true){
            if (userInput.equalsIgnoreCase("Y")){
                resetGame();
                break;

            } else if (userInput.equalsIgnoreCase("N")){
                System.out.println("Thanks for playing!");
                break;
            }
            System.out.println("Please enter either Y (y) or N (n).");
            userInput = scanner.nextLine();
        }

    }

    public void getUserInput(){
       while(true){
           if(this.deckOfCards.isEmpty()){
               System.out.println("No more cards!");
               playAgain();
               break;
           } else if(checkForSnap()){
               endGame();
               break;
           }
           System.out.println("Press enter key to show next card");
           String userInput = scanner.nextLine();
           boolean isInputValid = false;
           while(!isInputValid){
               if (userInput.isEmpty()) {
                   dealNewCard();
                   isInputValid = true;
               } else {
                   System.out.println("Only enter key is allowed.");
                   userInput = scanner.nextLine();
               }
           }
       }
    }
}
