package com.ClaudiaCalero.game;

public abstract class Question {
    private String questionText; // La pregunta en sí
    private String correctAnswer; // La respuesta correcta
    public String hint; // La pista que puede ayudar al jugador

    // Constructor
    public Question(String questionText, String correctAnswer, String hint) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
    }

    // Métodos para obtener el texto de la pregunta
    public String getQuestionText() {
        return questionText;
    }

    // Métodos para establecer el texto de la pregunta
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    // Métodos para obtener la respuesta correcta
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    // Métodos para establecer la respuesta correcta
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    // Métodos para obtener la pista
    public String getHint() {
        return hint;
    }

    // Métodos para establecer la pista
    public void setHint(String hint) {
        this.hint = hint;
    }

    // Métodos abstractos para mostrar la pregunta y verificar la respuesta
    public abstract void displayQuestion();
    public abstract boolean isCorrect(String userAnswer);
}
