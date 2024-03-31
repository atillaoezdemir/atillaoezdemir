package de.thws.lektion15;

public class MultipleChoiceQuestion extends QuizQuestion{
    private String[] choices;
    private int correctIndex;
    public MultipleChoiceQuestion(String questionText, String[] choices, int correctIndex){
        super(questionText);
        this.choices = choices;
        this.correctIndex = correctIndex;
    }
    public boolean checkAnswer(String answer){ // a  b 1  c 2  d  3
        int userAnswer = answer.toUpperCase().charAt(0) - 'A';
        return userAnswer == correctIndex;
    }
    public void toAsk() {
        System.out.println(questionText);
        System.out.println("A) " + choices[0]);
        System.out.println("B) " + choices[1]);
        System.out.println("C) " + choices[2]);
        System.out.println("D) " + choices[3]);
    }
    }


