package de.thws.lektion15;

public class TextQuestion extends QuizQuestion{
    private String answer;
    public TextQuestion(String questionText, String answer){
        super(questionText);
        this.answer = answer;
    }
    public boolean checkAnswer(String answer){
        return this.answer.equalsIgnoreCase(answer);
    }
    public void toAsk() {
        System.out.println(questionText);
    }
}
