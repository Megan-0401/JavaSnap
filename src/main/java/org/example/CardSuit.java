package org.example;

public enum CardSuit {
    HEART("♥"), CLUB("♣"), DIAMOND("♦"), SPADE("♠");

    private final String symbol;

    CardSuit(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
