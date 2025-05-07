package org.example;

import java.util.*;

public class Snap extends CardGame{
    private Scanner scanner = new Scanner(System.in);
    private Card currentCard;
    private Card previousCard;
    private ArrayList<Player> playerList = new ArrayList<Player>();
    private Player currentPlayer;

    public Snap() {
    }

    public void createPlayers(){
        playerList.add(new Player("One"));
        playerList.add(new Player("Two"));
    }

    public void initialiseGame(){
        createPlayers();
        System.out.println("Welcome to snap!");
        System.out.println("If you get two cards with the same symbol in a row, type snap to win!");
        startSnap();
    }

    public void startSnap(){
        this.deckOfCards = shuffleDeck();
        currentPlayer = playerList.get(0);
        dealFirstCard();
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

    public void printCard(String card, String prevCard){
        System.out.println("PREVIOUS CARD: " + prevCard);
        System.out.println("NEXT CARD: " + card);
    }

    public void dealNewCard(){
        this.previousCard = this.currentCard;
        this.currentCard = dealCard();
        printCard(this.currentCard.toString(),this.previousCard.toString());
    }

    public void dealFirstCard(){
        this.currentCard = dealCard();
        System.out.println("FIRST CARD: " + this.currentCard.toString());
    }

    public boolean checkForSnap() {
        if(!(this.previousCard == null)){
            if(this.currentCard.getValue() == this.previousCard.getValue()){
                return true;
            }
        }
        return false;
    }

    public void snapOpportunity() {
        long startTime = System.currentTimeMillis();
        String userInput = scanner.nextLine();
        // check if user has given correct input
            if(userInput.equalsIgnoreCase("snap")){
                // end time and check if less than 2 seconds
                long endTime = System.currentTimeMillis();
                long timeTaken = (endTime - startTime) / 1000;
                if(timeTaken < 2) {
                    endGame();
                } else{
                    playerLose("Too slow!");
                }
            } else{
                playerLose("You didn't say snap!");
            }
    }

    public void playerLose(String message){
        System.out.println(message);
        switchTurn();
        endGame();
    }

    public void endGame(){
        System.out.printf("Player %s wins!\n", this.currentPlayer.getPlayerName());
        playAgain();
    }

    public void playAgain(){
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

    public void switchTurn(){
        if(this.currentPlayer.getPlayerId() == 1){
            this.currentPlayer = playerList.get(1);
        } else{
            this.currentPlayer = playerList.get(0);
        }
    }

    public void getUserInput(){
        while(true){
           if(this.deckOfCards.isEmpty()){
               System.out.println("No more cards!");
               playAgain();
               break;
           }
           System.out.printf("Player %s's turn:\n", this.currentPlayer.getPlayerName());
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
            if(checkForSnap()){
                snapOpportunity();
                break;
            }
           System.out.println("No match!\n");
           switchTurn();
       }
    }
}
