package me.ac.lab2_020821.controller;

public class NextQuestion {
    public static int index =0;
    public int getCurrentQuestion() {return index; }
    public int getNextQuestionIndex() {
        index ++;
        return index;
        //maybe do a random generator
    }

}
