package com.example.quizapp.Model;

public class Quesstion {
    private int answerResId;
    private Boolean anserTrue;

   public Quesstion (int answerResId, Boolean anserTrue)
    {
        this.anserTrue=anserTrue;
        this.answerResId=answerResId;
    }

    public int getAnswerResId(){
       return answerResId;
    }

    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    public boolean getAnserTrue(){
       return anserTrue;
    }

    public void setAnserTrue(boolean anserTrue)
    {
        this.anserTrue=anserTrue;
    }
}
