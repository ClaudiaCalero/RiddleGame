package com.ClaudiaCalero.game;

import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Question> questions; // Almacena la lista de preguntas del juego
    private Scanner scanner; // Se utiliza para capturar la entrada del jugador

    // Constructor que inicializa el juego con una lista de preguntas
    public Game(List<Question> questions) {
        this.questions = questions;
        this.scanner = new Scanner(System.in);
    }

    // Métodos para obtener y establecer la lista de preguntas
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    // Métodos para obtener y establecer el scanner
    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    // Método para iniciar el juego
    public void start() {
        System.out.println("Welcome to Riddle Game!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        for (Question question : questions) {
            System.out.println("------------------------------");
            question.displayQuestion();

            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (question.isCorrect(userAnswer)) {
                System.out.println("Hurray!");
                player.increaseScore();
            } else {
                System.out.println("Wrong answer. The correct answer is: " + question.getCorrectAnswer());
                break;
            }
        }

        System.out.println("------------------------------");
        System.out.println("Game Over, " + player.getPlayerName() + ".");
        System.out.println("Score: " + player.getScore() + " of " + questions.size());
    }
}
