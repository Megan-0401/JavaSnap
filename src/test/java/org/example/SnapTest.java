package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SnapTest {
    Snap snapGame = new Snap();
    Card testCard = new Card(CardSuit.HEART, "4", 4);

    @BeforeEach
    public void setUp(){
        snapGame = new Snap();
    }

    @Test
    @DisplayName("Should add two players to the playerList when game is created")
    void createPlayers_WhenGameInitialised_PlayerListCountShouldReturnTwo() {
        int playerCount = 2;
        snapGame.createPlayers();
        assertEquals(playerCount, snapGame.getPlayerList().size());
    }

    @Test
    @DisplayName("Should return true if both current and previous card have the same symbol")
    void checkForSnap_CurrentAndPreviousCardHaveSameSymbol_ReturnTrue() {
        snapGame.setPreviousCard(testCard);
        snapGame.setCurrentCard(new Card(CardSuit.DIAMOND, "4", 4));
        assertTrue(snapGame.checkForSnap());
    }

    @Test
    @DisplayName("Should return false if both current and previous card have different symbols")
    void checkForSnap_CurrentAndPreviousCardHaveDifferentSymbol_ReturnFalse() {
        snapGame.setPreviousCard(testCard);
        snapGame.setCurrentCard(new Card(CardSuit.DIAMOND, "K", 13));
        assertFalse(snapGame.checkForSnap());
    }

    @DisplayName("Should return currentPlayer as Player Two if Player One played their turn")
    @Test
    void switchTurn_PlayerOneHadTurn_currentPlayerShouldBePlayerTwo() {
        snapGame.createPlayers();
        snapGame.setCurrentPlayer(snapGame.getPlayerList().get(0));
        Player playerTwo = snapGame.getPlayerList().get(1);
        snapGame.switchTurn();
        assertEquals(playerTwo, snapGame.getCurrentPlayer());
    }
}