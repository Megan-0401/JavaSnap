package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CardGameTest {
    CardGame testGame = new CardGame();

    @BeforeEach
    public void setUp(){
        testGame = new CardGame();
    }

    @Test
    @DisplayName("Should return a deck with 52 cards")
    void generateDeck_WhenCalled_Return52Cards() {
        assertEquals(52, testGame.getDeckOfCards().size());
    }

    @Test
    @DisplayName("When sorted in number order, should see first four cards in deck to have a value of 2")
    void sortDeckInNumberOrder_WhenCalled_FirstFourCardsInDeckReturnValueOfTwo() {
        int expectedValue = 2;
        testGame.setDeckOfCards(testGame.sortDeckInNumberOrder());
        for(int i = 0; i < 4; i++){
            int actualValue = testGame.getDeckOfCards().get(i).getValue();
            assertEquals(expectedValue, actualValue);
            System.out.printf("Card %d value: %d\n", i, actualValue);
        }
    }

    @Test
    @DisplayName("When sorted in number order, should see last card in deck to be Ace of spades")
    void sortDeckInNumberOrder_WhenCalled_ReturnsListEndingWithAOfSpades() {
        Card lastExpectedCard = new Card(CardSuit.SPADE, "A", 14);
        int deckLength = testGame.getDeckOfCards().size() - 1;
        testGame.setDeckOfCards(testGame.sortDeckInNumberOrder());
        Card lastActualCard = testGame.getDeckOfCards().get(deckLength);
        assertAll("Testing fields are correct",
                () -> assertEquals(lastExpectedCard.getSuit(), lastActualCard.getSuit()),
                () -> assertEquals(lastExpectedCard.getSymbol(), lastActualCard.getSymbol()),
                () -> assertEquals(lastExpectedCard.getValue(), lastActualCard.getValue())
        );
    }

    @Test
    @DisplayName("When sorted into suits, should see first 13 cards in deck to be heart suit")
    void sortDeckIntoSuits_WhenCalled_FirstThirteenCardsReturnHeartSuit() {
        CardSuit expectedSuit = CardSuit.HEART;
        testGame.setDeckOfCards(testGame.sortDeckIntoSuits());
        CardSuit firstActualCardSuit = testGame.getDeckOfCards().get(0).getSuit();
        CardSuit thirteenthActualCard = testGame.getDeckOfCards().get(12).getSuit();
        assertAll("Testing suits are correct",
                () -> assertEquals(expectedSuit, firstActualCardSuit),
                () -> assertEquals(expectedSuit, thirteenthActualCard)
        );
        System.out.printf("1st card: %s, 13th card: %s\n", firstActualCardSuit.getSymbol(), thirteenthActualCard.getSymbol());
    }
}