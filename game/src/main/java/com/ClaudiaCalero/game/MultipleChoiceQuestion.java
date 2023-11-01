package com.ClaudiaCalero.game;

import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<String> options; // Almacena las opciones de respuesta

    // Constructor que inicializa la pregunta con su texto, respuesta correcta, pista y opciones
    public MultipleChoiceQuestion(String questionText, String correctAnswer, String hint, List<String> options) {
        super(questionText, correctAnswer, hint);
        this.options = options;
    }

    // Métodos para obtener y establecer las opciones de respuesta
    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    // Método para mostrar la pregunta y sus opciones
    @Override
    public void displayQuestion() {
        System.out.println("Multiple choice question:");
        System.out.println("Question: " + getQuestionText());

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

    // Método para verificar si la respuesta proporcionada por el usuario es correcta
    @Override
    public boolean isCorrect(String userAnswer) {
        char correctOption = getCorrectAnswer().charAt(0);
        char userOption = userAnswer.toUpperCase().charAt(0);
        return correctOption == userOption;
    }

    // Método para obtener el texto de la pregunta
    public String getQuestionText() {
        return super.getQuestionText();
    }
}
