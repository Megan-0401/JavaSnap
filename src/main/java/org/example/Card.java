package org.example;

public class Card {
    private final CardSuit suit;
    private final String symbol;
    private final int value;

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
        return String.format("%s of %s", getSymbol(), getSuit().getSymbol());
    }
}
