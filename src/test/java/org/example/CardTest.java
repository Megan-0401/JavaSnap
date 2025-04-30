package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    @DisplayName("Returns correctly formatted string of a single card")
    void testToString() {
        Card queenOfHearts = new Card(CardSuit.HEART, "Q", 12);
        assertEquals("Suit: ♥ Symbol: Q Value: 12", queenOfHearts.toString());
    }
}