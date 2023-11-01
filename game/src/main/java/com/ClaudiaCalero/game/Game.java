package com.ClaudiaCalero.game;

import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Question> questions;
    private Scanner scanner;

    public Game(List<Question> questions, Scanner scanner) {
        this.questions = questions;
        this.scanner = new Scanner(System.in);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Welcome to Riddle Game!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        for (Question question : questions) {
            System.out.println("------------------------------");
            System.out.println("New riddle:");

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
        System.out.println("Score: " + player.getScore() + " de " + questions.size());
    }
}

