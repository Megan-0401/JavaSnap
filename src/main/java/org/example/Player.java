package org.example;

public class Player {
    private final int playerId;
    private final String playerName;
    private int wins;

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

    public void addWin() {
        this.wins++;
    }

    public void printWins(){
        String plural = "s";
        if(this.wins == 1){
            plural = "";
        }
        System.out.printf("Player %s: %d win%s\n", this.playerName, this.wins, plural);
    }
}
