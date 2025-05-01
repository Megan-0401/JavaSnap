package org.example;

public class CardSort {
    public static int sortDeckByValue(Card a, Card b){
        if(a.getValue() == b.getValue()){
            return a.getSuit().compareTo(b.getSuit());
        } else {
            return a.getValue() - b.getValue();
        }
    }

    public static int sortDeckBySuit(Card a, Card b){
        if(a.getSuit().equals(b.getSuit())){
            return a.getValue() - b.getValue();
        } else {
            return a.getSuit().compareTo(b.getSuit());
        }
    }
}
