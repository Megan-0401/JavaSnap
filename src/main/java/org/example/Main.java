package org.example;


public class Main
{
    public static void main( String[] args )
    {
        //testing Card class
        Card myCard = new Card("♥", "2", 2);
        System.out.println("Testing toString");
        System.out.println(myCard.toString());
        System.out.println();

        //testing CardGame class
        CardGame newCardGame = new CardGame();
        System.out.println("Testing getDeck");
        newCardGame.getDeck();

        System.out.println("Testing dealCard");
        System.out.println(newCardGame.dealCard().toString());

        System.out.println("Testing sortDeckInNumberOrder");
        newCardGame.sortDeckInNumberOrder();
        newCardGame.getDeck();
    }
}
