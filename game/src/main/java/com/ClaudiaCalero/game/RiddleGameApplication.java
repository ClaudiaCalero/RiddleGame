package com.ClaudiaCalero.game;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RiddleGameApplication {

	public static void main(String[] args) {
		// Cargamos las preguntas desde un archivo en GitHub
		List<Question> questions = loadQuestionsFromGitHub("https://raw.githubusercontent.com/ClaudiaCalero/RiddleGame/master/RIDDLES.txt");

		// Verificamos si se cargaron preguntas
		if (questions.isEmpty()) {
			System.out.println("There's no riddles available. The game cannot start.");
			return;
		}

		// Creamos una instancia del juego y lo iniciamos
		Game game = new Game(questions);
		game.start();
	}

	// Función para cargar preguntas desde un archivo en GitHub
	public static List<Question> loadQuestionsFromGitHub(String githubFileURL) {
		// Lista que contendrá las preguntas cargadas
		List<Question> questions = new ArrayList<>();

		try {
			// Crear una URL para acceder al archivo en GitHub
			URL questionsURL = new URL(githubFileURL);
			// Abrir una secuencia de entrada desde la URL
			InputStream inputStream = questionsURL.openStream();
			// Crear un lector para leer el contenido del archivo
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			// Variables para mantener el estado de la pregunta actual
			String line;
			String questionType = null;
			String questionText = null;
			String correctAnswer = null;
			String hint = null;
			List<String> options = new ArrayList<>();

			do {
				// Leer una línea del archivo
				line = reader.readLine();

				// Verificar si la línea no está vacía
				if (line != null && !line.trim().isEmpty()) {
					if (line.equals("RIDDLE") || line.equals("MULTIPLE_CHOICE")) {
						questionType = line;
					} else if (questionText == null) {
						questionText = line;
					} else if (correctAnswer == null) {
						correctAnswer = line;
					} else if (questionType != null && questionType.equals("RIDDLE")) {
						hint = line;
					} else if (questionType != null && questionType.equals("MULTIPLE_CHOICE")) {
						if (line.startsWith("A)") || line.startsWith("B)") || line.startsWith("C)") || line.startsWith("D)")) {
							// Es una opción de respuesta
							options.add(line);
						}
					}

					// Cuando se han recopilado todos los componentes de una pregunta
					if (questionType != null && questionText != null && correctAnswer != null) {
						if (questionType.equals("RIDDLE")) {
							// Agregamos una pregunta de acertijo a la lista
							questions.add(new Riddle(questionText, correctAnswer, hint));
						} else if (questionType.equals("MULTIPLE_CHOICE")) {
							// Agregamos una pregunta de opción múltiple a la lista
							questions.add(new MultipleChoiceQuestion(questionText, correctAnswer, hint, options));
						}

						// Reiniciar variables para la próxima pregunta
						questionType = null;
						questionText = null;
						correctAnswer = null;
						hint = null;
						options.clear();
					}
				}
			} while (line != null); // Continuar hasta que no haya más líneas en el archivo
		} catch (IOException e) {
			e.printStackTrace(); // Manejar errores de lectura o conexión
		}

		return questions; // Devolver la lista de preguntas cargadas
	}
}