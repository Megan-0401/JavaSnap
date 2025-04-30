package org.example;

import java.util.*;
import static org.example.CardSort.*;

public class CardGame {
    private ArrayList<Card> deckOfCards = new ArrayList<>();

    public CardGame() {
        this.deckOfCards = generateDeck();
    }

    private ArrayList<Card> generateDeck(){
        List<CardSuit> suitList = Arrays.asList(CardSuit.HEART, CardSuit.CLUB, CardSuit.DIAMOND, CardSuit.SPADE);
        List<String> symbolList = Arrays.asList("2","3","4","5","6","7","8","9","10","J","Q","K","A");
        List<Integer> valueList = Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,14);
        ArrayList<Card> newDeckOfCards = new ArrayList<>();

        for (CardSuit suit : suitList){
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
        //System.out.println(deckOfCards.size());
    }

    public Card dealCard(){
        return this.deckOfCards.get(0);
    }

    public ArrayList<Card> sortDeckInNumberOrder(){
        this.deckOfCards.sort(Comparator.comparingInt(Card::getValue));
        return this.deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits(){
        this.deckOfCards.sort(CardSort::sortDeckBySuit);
        return this.deckOfCards;
    }

    public ArrayList<Card> shuffleDeck(){
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }
}
