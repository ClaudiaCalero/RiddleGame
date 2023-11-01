package com.ClaudiaCalero.game;

public class Riddle extends Question {
    // Constructor
    public Riddle(String questionText, String correctAnswer, String hint) {
        super(questionText, correctAnswer, hint);
    }

    // Método para mostrar la pregunta en la consola
    @Override
    public void displayQuestion() {
        // Imprime "Riddle:" para indicar que es una pregunta de acertijo
        System.out.println("Riddle:");
        // Imprime el texto de la pregunta
        System.out.println(getQuestionText());

        // Verifica si hay una pista y la imprime
        String hint = getHint();
        if (hint != null) {
            System.out.println("Hint: " + hint);
        }
    }

    // Método para verificar si la respuesta del usuario es correcta
    @Override
    public boolean isCorrect(String userAnswer) {
        // Compara la respuesta del usuario (ignorando mayúsculas/minúsculas) con la respuesta correcta
        return getCorrectAnswer().equalsIgnoreCase(userAnswer);
    }

    // Método para obtener el texto de la pregunta, incluyendo "Question:" al principio
    public String getQuestionText() {
        return ("Question: " + super.getQuestionText());
    }
}

