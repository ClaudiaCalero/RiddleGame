package com.ClaudiaCalero.game;

public class Player {
    private String playerName;
    private int score;

    public Player(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore(){
        score++;
    }
}
