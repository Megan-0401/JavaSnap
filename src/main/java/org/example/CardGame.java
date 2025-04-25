package org.example;

import java.util.*;

public class CardGame {
    private ArrayList<Card> deckOfCards = new ArrayList<>();

    public CardGame() {
        this.deckOfCards = generateDeck();
    }

    private ArrayList<Card> generateDeck(){
        List<String> suitList = Arrays.asList("♠", "♥", "♦", "♣");
        List<String> symbolList = Arrays.asList("2","3","4","5","6","7","8","9","10","J","Q","K","A");
        List<Integer> valueList = Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,14);
        ArrayList<Card> newDeckOfCards = new ArrayList<>();

        for (String suit : suitList){
            for(int i = 0; i < symbolList.size(); i++){
                newDeckOfCards.add(new Card(suit, symbolList.get(i), valueList.get(i)));
            }
        }
        return newDeckOfCards;
    }

    public void getDeck(){
        for(Card card : this.deckOfCards){
            System.out.println(card.toString());
        }
    }

    public Card dealCard(){
        return this.deckOfCards.get(0);
    }

    public ArrayList<Card> sortDeckInNumberOrder(){
        ArrayList<Card> sortedDeck = generateDeck();
        sortedDeck.sort(new sortByValue());
        this.deckOfCards = sortedDeck;
        return this.deckOfCards;
    }
}

class sortByValue implements Comparator<Card> {
    public int compare(Card a, Card b){
        return a.getValue() - b.getValue();
    }

}
