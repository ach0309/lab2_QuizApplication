package me.ac.lab2_020821.model;


import me.ac.lab2_020821.R;

public class AllQuestions {

    private int questionIndex;

    private Question[] allQuestions = {
            new Question(R.string.q_ready, true),
            new Question(R.string.q_22, false),
            new Question(R.string.q_23, true),
            new Question(R.string.q_add, false)

    };

    public AllQuestions(){
        questionIndex=0;
    }

    public Question getQuestion(int index){
        index = index % allQuestions.length;
        return allQuestions[index];
    }


}
