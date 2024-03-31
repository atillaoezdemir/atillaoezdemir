package de.thws.lektion15;

abstract class QuizQuestion {
    protected String questionText;
    public QuizQuestion(String questionText){
        this.questionText = questionText;
    }
    abstract boolean checkAnswer(String answer);

    abstract void toAsk();
}
