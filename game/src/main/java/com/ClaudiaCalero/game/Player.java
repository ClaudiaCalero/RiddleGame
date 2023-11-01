package com.ClaudiaCalero.game;

public class Player {
    private String playerName; // Almacena el nombre del jugador
    private int score; // Almacena la puntuación del jugador

    // Constructor para inicializar el jugador con un nombre y una puntuación
    public Player(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    // Constructor para inicializar el jugador solo con un nombre (puntuación se establece en 0)
    public Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
    }

    // Método para obtener el nombre del jugador
    public String getPlayerName() {
        return playerName;
    }

    // Método para establecer el nombre del jugador
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    // Método para obtener la puntuación del jugador
    public int getScore() {
        return score;
    }

    // Método para establecer la puntuación del jugador
    public void setScore(int score) {
        this.score = score;
    }

    // Método para aumentar la puntuación del jugador
    public void increaseScore() {
        score++;
    }
}