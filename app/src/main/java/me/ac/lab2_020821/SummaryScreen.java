package me.ac.lab2_020821;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryScreen extends AppCompatActivity {

    private Button exitButton;
    private TextView finalScoreView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //take score value from MainActivity
        String summaryScore = getIntent().getStringExtra("key1");
        finalScoreView = findViewById(R.id.finalScoreView);
        finalScoreView.setText(summaryScore);

        exitButton=findViewById(R.id.exit_button);
        exitButton.setOnClickListener((view)-> {
            finish(); //exit the current activity (goes back to MainActivity)
            moveTaskToBack(true); //exits the app
        });


    }
}