package org.example;

public class Card {
    private CardSuit suit;
    private String symbol;
    private int value;

    public Card(CardSuit suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString(){
        return "Suit: " + this.suit.getSymbol() +
                " Symbol: " + this.symbol +
                " Value: " + this.value;
    }
}
