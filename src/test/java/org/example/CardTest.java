package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    @DisplayName("Returns correctly formatted string of a single card")
    void testToString_GivenOneCard_ReturnCorrectStringFormat() {
        Card queenOfHearts = new Card(CardSuit.HEART, "Q", 12);
        assertEquals("Q of ♥", queenOfHearts.toString());
    }
}