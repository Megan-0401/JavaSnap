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
    void sortDeckInNumberOrder() {
    }

    @Test
    void sortDeckIntoSuits() {
    }

    @Test
    void shuffleDeck() {
    }
}