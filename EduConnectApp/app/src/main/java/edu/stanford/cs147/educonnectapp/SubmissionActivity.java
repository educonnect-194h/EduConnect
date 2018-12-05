package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SubmissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
    }

    public void onFeelingsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), SubmissionActivity.class);
        startActivity(myIntent);
    }
}
