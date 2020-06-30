package com.example.quizzz;

public class TrueFalse {
    private int questionID;
    private boolean correctAnswer;

    public TrueFalse(int questionID,boolean correctAnswer){
        this.questionID = questionID;
        this.correctAnswer = correctAnswer;
    }

    public int getQuestionID() {
        return questionID;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
