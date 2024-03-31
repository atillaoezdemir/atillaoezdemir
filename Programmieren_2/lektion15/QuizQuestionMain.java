package de.thws.lektion15;

import java.util.Scanner;

public class QuizQuestionMain {
    public static void main(String[] args) {
        QuizQuestion[] quiz = new QuizQuestion[5];
        quiz[0] = new TextQuestion("Was ist die Hauptstadt von Deutschland?" , "Berlin");
        quiz[1] = new MultipleChoiceQuestion("Wie viele Protonen hat ein Wasserstoff-Atom?", new String[]{"4", "2", "1", "0"}, 2);
        quiz[2] = new TextQuestion("Was ist die Hauptstadt von Tuerkei?", "Ankara");
        quiz[3] = new MultipleChoiceQuestion("Welches ist das größte Land der Welt?", new String[]{"Russland", "Kanada", "China", "USA"}, 0);
        quiz[4] = new TextQuestion("Wer ist CEO von Tesla?", "Elon Musk");

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < quiz.length; i++) {
            System.out.println("Frage " + (i + 1) + ": ");
            quiz[i].toAsk();
            System.out.print("Antwort: ");
            String answer = scanner.nextLine();
            if (quiz[i].checkAnswer(answer)) {
                System.out.println("Richtig!");
            } else {
                System.out.println("Falsch!");
            }
            System.out.println();

            }
        scanner.close();
        }
    }