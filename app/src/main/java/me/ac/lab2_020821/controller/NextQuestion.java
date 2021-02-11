package me.ac.lab2_020821.controller;

import me.ac.lab2_020821.model.AllQuestions;

public class NextQuestion {
    public static int index =0;
    public int getCurrentQuestion() {return index; }
    public int getNextQuestionIndex() {
        index ++;
        return index;
    }

}
