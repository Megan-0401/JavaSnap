package org.example;


public class Main
{
    public static void main( String[] args )
    {
        //testing Card class
        Card myCard = new Card("♥", "2", 2);
        System.out.println("Testing Card class:");
        System.out.println(myCard.toString());
        System.out.println();

        //testing CardGame class
        CardGame newCardGame = new CardGame();
        System.out.println("Testing CardGame class");
        newCardGame.getDeck();
    }
}
