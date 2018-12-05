package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TeacherDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        // Make big buttons unclickable
        ImageButton rosterBtn = findViewById(R.id.rosterButton);
        rosterBtn.setClickable(false);

        ImageButton messagesBtn = findViewById(R.id.messagesButton2);
        messagesBtn.setClickable(false);

        ImageButton classResultsBtn = findViewById(R.id.classResultsBtn);
        classResultsBtn.setClickable(false);

        Intent intent = this.getIntent();
        boolean submitted = false;

        if (intent.getExtras() != null) {
            submitted = intent.getExtras().getBoolean("Submitted");
        }

        if (submitted) {
            // Make the "How are you feeling today" button grey and the big buttons green and clickable
            Button feelingsButton = findViewById(R.id.teacherFeelings);
            feelingsButton.setBackgroundResource(R.drawable.dashboard_button_unavailable);
            feelingsButton.setClickable(false);

            rosterBtn.setBackgroundResource(R.drawable.dashboard_button_available_trans);
            rosterBtn.setClickable(true);

            messagesBtn.setBackgroundResource(R.drawable.dashboard_button_available_trans);
            messagesBtn.setClickable(true);

            classResultsBtn.setBackgroundResource(R.drawable.dashboard_button_available_trans);
            classResultsBtn.setClickable(true);
        }
    }

    public void onTeacherFeelingsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherSubmissionActivity.class);
        startActivity(myIntent);
    }

    public void onClassResultsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), ClassResultsActivity.class);
        startActivity(myIntent);
    }
}
