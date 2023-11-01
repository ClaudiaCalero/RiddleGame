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
			System.out.println("No hay preguntas disponibles. El juego no puede comenzar.");
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

			String line = "";

			do {
				try {
					line = reader.readLine();

					if (line != null && !line.trim().isEmpty()) {
						String questionType = line;
						String questionText = reader.readLine();
						String correctAnswer = reader.readLine();
						String hint = (questionType.equals("RIDDLE")) ? reader.readLine() : null;
						List<String> options = new ArrayList<>();

						if (questionType.equals("MULTIPLE_CHOICE")) {
							String optionLine;
							while ((optionLine = reader.readLine()) != null && !optionLine.isEmpty()) {
								options.add(optionLine);
							}
						}

						if ("RIDDLE".equals(questionType)) {
							questions.add(new Riddle(questionText, correctAnswer, hint));
						} else if ("MULTIPLE_CHOICE".equals(questionType)) {
							questions.add(new MultipleChoiceQuestion(questionText, correctAnswer, hint, options));
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (line != null);

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return questions;
	}
}