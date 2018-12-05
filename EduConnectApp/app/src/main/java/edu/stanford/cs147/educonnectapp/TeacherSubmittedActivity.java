package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TeacherSubmittedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_submitted);
    }

    public void onBackToDashClick(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherDashboardActivity.class);
        myIntent.putExtra("Submitted", true);
        startActivity(myIntent);
    }
}
