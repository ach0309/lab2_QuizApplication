package me.ac.lab2_020821.controller;

import me.ac.lab2_020821.model.AllQuestions;

public class Score {
    public final int CORRECT_ANSWER = 10;
    public final int SKIP_QUESTION = -5;
    public final int WRONG_ANSWER = 0;
    public int score;

    public Score() {score=0; }


    public void correctAnswer() { score += CORRECT_ANSWER; }
    public void wrongAnswer() {
        if (score <= 0){
            score =0;
        } else{
            score += WRONG_ANSWER;
        }

    }
    public void skipQuestion() {
        if (score <= 0){
            score =0;
        } else{
            score += SKIP_QUESTION;
        }

    }
    public int getScore() {return score; }

}
