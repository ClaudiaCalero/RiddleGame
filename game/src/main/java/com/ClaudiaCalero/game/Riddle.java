package com.ClaudiaCalero.game;

public class Riddle extends Question {
    public Riddle(String questionText, String correctAnswer, String hint) {
        super(questionText, correctAnswer, hint);
    }

    @Override
    public void displayQuestion() {
        System.out.println("Riddle:");
        System.out.println(getQuestionText());

        String hint = getHint();
        if (hint != null) {
            System.out.println("Hint: " + hint);
        }
    }

    @Override
    public boolean isCorrect(String userAnswer) {
        return getCorrectAnswer().equalsIgnoreCase(userAnswer);
    }

    public String getQuestionText() {
        return "Question: " + super.getQuestionText();
    }
}

