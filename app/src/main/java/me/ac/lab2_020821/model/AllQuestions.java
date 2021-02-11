package me.ac.lab2_020821.model;


import me.ac.lab2_020821.R;

public class AllQuestions {


    private int questionIndex;

    private Question[] allQuestions = {
            new Question(R.string.q_ready, true),
            new Question(R.string.q_actFrag, true),
            new Question(R.string.q_pause, false),
            new Question(R.string.q_states, false),
            new Question(R.string.q_nav, true),
            new Question(R.string.q_model, true),
            new Question(R.string.q_stack, true),
            new Question(R.string.q_intent, false)

    };

    public AllQuestions(){
        questionIndex=0;
    }

    public Question getQuestion(int index){
        index = index % allQuestions.length;
        return allQuestions[index];
    }


}
