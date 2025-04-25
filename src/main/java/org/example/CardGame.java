package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardGame {
    private List<Card> deckOfCards = new ArrayList<>();

    public CardGame() {
        generateDeck();
    }

    private void generateDeck(){
        List<String> suitList = Arrays.asList("♠", "♥", "♦", "♣");
        List<String> symbolList = Arrays.asList("2","3","4","5","6","7","8","9","10","J","Q","K","A");
        List<Integer> valueList = Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,14);

        for (String suit : suitList){
            for(int i = 0; i < symbolList.size(); i++){
                this.deckOfCards.add(new Card(suit, symbolList.get(i), valueList.get(i)));
            }
        }
    }

    public void getDeck(){
        for(Card card : deckOfCards){
            System.out.println(card.toString());
        }
    }
}
