package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StudentHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_history);
    }

    public void onGraphButtonClick(View v){
        Intent myIntent = new Intent(getBaseContext(), StudentDetailedResultsActivity.class);
        startActivity(myIntent);
    }
}