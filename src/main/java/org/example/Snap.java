package org.example;

import java.util.Scanner;

public class Snap extends CardGame{
    private Scanner scanner = new Scanner(System.in);
    private Card currentCard;
    private Card previousCard;

    public Snap() {
    }

    public void printCard(String card){
        System.out.println("NEXT CARD: " + card);
    }

    public void startSnap(){
        System.out.println("Welcome to snap!");
        this.deckOfCards = shuffleDeck();
        //resets snap status if user plays again
        this.previousCard = null;
        getUserInput();
    }

    public void dealNewCard(){
        // swapping currentCard to previousCard
        this.previousCard = this.currentCard;
        Card currentCard = dealCard();
        this.currentCard = currentCard;
        printCard(currentCard.toString());
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
        System.out.println("Would you like to play again? Y/N");
        String userInput = scanner.nextLine();
        while(true){
            if (userInput.equalsIgnoreCase("Y")){
                System.out.println("Starting new game...");
                this.deckOfCards = generateDeck();
                startSnap();
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
