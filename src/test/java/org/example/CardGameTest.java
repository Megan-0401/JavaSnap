package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("When sorted in number order, should see first card in deck to be 2 of hearts")
    void sortDeckInNumberOrder_WhenCalled_ReturnsListStartingWith2OfHearts() {
        Card firstExpectedCard = new Card(CardSuit.HEART, "2", 2);
        testGame.setDeckOfCards(testGame.sortDeckInNumberOrder());
        Card firstAtualCard = testGame.getDeckOfCards().get(0);
        assertAll( "Testing fields are correct",
                () -> assertEquals(firstExpectedCard.getSuit(), firstAtualCard.getSuit()),
                () -> assertEquals(firstExpectedCard.getSymbol(), firstAtualCard.getSymbol()),
                () -> assertEquals(firstExpectedCard.getValue(), firstAtualCard.getValue())
        );
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
    void sortDeckIntoSuits() {
    }

    @Test
    void shuffleDeck() {
    }
}