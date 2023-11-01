package com.ClaudiaCalero.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class RiddleGameApplication {

	public static void main(String[] args) {
		List<Question> questions = loadQuestionsFromURL("https://raw.githubusercontent.com/ClaudiaCalero/RiddleGame/master/RIDDLES.txt");

		if (questions.isEmpty()) {
			System.out.println("There's no riddles available. The game cannot start.");
			return;
		}

		Game game = new Game(questions);
		game.start();
	}

	public static List<Question> loadQuestionsFromURL(String url) {
		List<Question> questions = new ArrayList<>();

		try {
			URL questionsURL = new URL(url);
			InputStream inputStream = questionsURL.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			String line;
			String questionType = null;
			String questionText = null;
			String correctAnswer = null;
			String hint = null;
			List<String> options = new ArrayList<>();

			do {
				line = reader.readLine();

				if (line != null && !line.trim().isEmpty()) {
					if (line.equals("RIDDLE") || line.equals("MULTIPLE_CHOICE")) {
						questionType = line;
					} else if (questionText == null) {
						questionText = line;
					} else if (correctAnswer == null) {
						correctAnswer = line;
					} else if (questionType != null && questionType.equals("RIDDLE")) {
						hint = line;
					} else if (questionType != null && questionType.equals("MULTIPLE_CHOICE") && !line.isEmpty()) {
						options.add(line);
					}

					if (questionType != null && questionText != null && correctAnswer != null) {
						if (questionType.equals("RIDDLE")) {
							questions.add(new Riddle(questionText, correctAnswer, hint));
						} else if (questionType.equals("MULTIPLE_CHOICE")) {
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
			} while (line != null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return questions;
	}
}