package me.ac.lab2_020821;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import me.ac.lab2_020821.controller.NextQuestion;
import me.ac.lab2_020821.controller.Score;
import me.ac.lab2_020821.model.AllQuestions;
import me.ac.lab2_020821.model.Question;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG_INDEX = "GAME_MAIN_ACTIVITY";

    private TextView questionView;
    private TextView scoreView;
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button doneButton;


    AllQuestions allQuestions = new AllQuestions();
    NextQuestion nextQuestion = new NextQuestion();
    Score score = new Score();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        scoreView = findViewById(R.id.scoreView);
        scoreView.setText(R.string.initial_score);

        questionView = findViewById(R.id.questionView);
        questionView.setText(R.string.q_ready);


        trueButton = findViewById(R.id.true_button);
        trueButton.setOnClickListener((View.OnClickListener) this);

        falseButton = findViewById(R.id.false_button);
        falseButton.setOnClickListener((View.OnClickListener) this);

        nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener((View.OnClickListener) this);

        //when doneButton is clicked, pass score to the SummaryScreen Activity
        doneButton = findViewById(R.id.done_button);
        doneButton.setOnClickListener((view)->{
            Intent intent = new Intent(MainActivity.this, SummaryScreen.class);
            intent.putExtra("key1", String.valueOf(score.getScore()));
            startActivity(intent);
        });

    }

    @Override
    public void onClick(View view) {
        int index = nextQuestion.getCurrentQuestion();
        Question question = null;

        try {
            question = allQuestions.getQuestion(index);
        } catch (Exception e) {
            Log.d(TAG_INDEX, "index out of bounds");
        }

        switch (view.getId()) {
            case R.id.true_button:
                if (question.isQuestionTrue()) {
                    score.correctAnswer();
                } else{
                    score.wrongAnswer();
                }
                break;

            case R.id.false_button:
                if (!question.isQuestionTrue()) {
                    score.correctAnswer();

                } else{
                    score.wrongAnswer();
                }
                break;

            case R.id.next_button:
                score.skipQuestion();
                break;

            default:
                break;
        }
        scoreView.setText(String.valueOf(score.getScore()));
        index = nextQuestion.getNextQuestionIndex();
        questionView.setText(allQuestions.getQuestion(index).getQuestionID());
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}