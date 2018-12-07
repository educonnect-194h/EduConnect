package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;

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

            TextView results = findViewById(R.id.resultsText);
            results.setTextColor(getResources().getColor(R.color.colorPrimary));
            results.setTypeface(null, Typeface.BOLD);
            classResultsBtn.setClickable(true);
            classResultsBtn.setColorFilter(getResources().getColor(R.color.colorPrimary));
            ImageView resultsArrow = findViewById(R.id.resultsArrow);
            resultsArrow.setVisibility(View.VISIBLE);

            TextView messages = findViewById(R.id.messagesText);
            messages.setTextColor(getResources().getColor(R.color.colorPrimary));
            messages.setTypeface(null, Typeface.BOLD);
            messagesBtn.setClickable(true);
            messagesBtn.setColorFilter(getResources().getColor(R.color.colorPrimary));
            ImageView messagesArrow = findViewById(R.id.messagesArrow);
            messagesArrow.setVisibility(View.VISIBLE);

            TextView roster = findViewById(R.id.rosterText);
            roster.setTextColor(getResources().getColor(R.color.colorPrimary));
            roster.setTypeface(null, Typeface.BOLD);
            rosterBtn.setClickable(true);
            rosterBtn.setColorFilter(getResources().getColor(R.color.colorPrimary));
            ImageView rosterArrow = findViewById(R.id.rosterArrow);
            rosterArrow.setVisibility(View.VISIBLE);

            TextView available = findViewById(R.id.availableNote);
            available.setVisibility(View.INVISIBLE);
        }

        TextView header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));
    }

    public void onTeacherFeelingsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherSubmissionActivity.class);
        startActivity(myIntent);
    }

    public void onClassResultsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), ClassResultsActivity.class);
        myIntent.putExtra("current", true);
        startActivity(myIntent);
    }

    public void backToClasses(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherClassListAcitivty.class);
        startActivity(myIntent);
    }
}
