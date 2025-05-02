package org.example;

public class Player {
    private final int playerId;
    private final String playerName;

    private static int id = 1;

    public Player(String playerName){
        this.playerId = generateId();
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    private int generateId(){
        return id++;
    }
}
