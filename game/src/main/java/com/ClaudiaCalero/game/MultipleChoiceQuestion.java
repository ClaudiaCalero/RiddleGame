package com.ClaudiaCalero.game;

import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<String>options;

    public MultipleChoiceQuestion(String questionText, String correctAnswer, String hint) {
        super(questionText, correctAnswer, hint);
    }


    @Override
    public void displayQuestion() {
        System.out.println("Multiple choice question:");
        System.out.println(getQuestionText());

        char optionLetter = 'A';
        for (String option : options) {
            System.out.println(optionLetter + ") " + option);
            optionLetter++;
        }

        String hint = getHint();
        if (hint != null) {
            System.out.println("Hint: " + hint);
        }
    }

    @Override
    public boolean isCorrect(String userAnswer) {
        char correctOption = getCorrectAnswer().charAt(0);
        char userOption = userAnswer.toUpperCase().charAt(0);
        return correctOption == userOption;
    }

    public String getQuestionText() {
        return "QUestion: " + super.getQuestionText();
    }
}

