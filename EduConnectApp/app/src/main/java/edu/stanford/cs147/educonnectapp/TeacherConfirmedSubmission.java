package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TeacherConfirmedSubmission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_confirmed_submission);

        TextView header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));

    }

    public void onBackToDashClick(View v){
        TextView header = findViewById(R.id.header);

        Intent myIntent = new Intent(getApplicationContext(), TeacherDashboardActivity.class);
        myIntent.putExtra("header", header.getText());
        myIntent.putExtra("Submitted", true);
        startActivity(myIntent);
    }
}
