package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        // Make big buttons unclickable
        ImageButton historyBtn = findViewById(R.id.historyButton);
        historyBtn.setClickable(false);
        ImageButton messagesBtn = findViewById(R.id.messagesButton);
        messagesBtn.setClickable(false);

        Intent intent = this.getIntent();
        boolean submitted = false;

        if (intent.getExtras() != null) {
            submitted = intent.getExtras().getBoolean("Submitted");
            TextView header = findViewById(R.id.header);
            header.setText(getIntent().getStringExtra("header"));

        }

        if (submitted) {
            // Make the "How are you feeling today" button grey and the big buttons green and clickable
            Button feelingsButton = findViewById(R.id.feelingsButton);
            feelingsButton.setBackgroundResource(R.drawable.dashboard_button_unavailable);
            feelingsButton.setClickable(false);

            TextView history = findViewById(R.id.historyText);
            history.setTextColor(getResources().getColor(R.color.colorPrimary));
            history.setTypeface(null, Typeface.BOLD);
            historyBtn.setClickable(true);
            historyBtn.setColorFilter(getResources().getColor(R.color.colorPrimary));
            ImageView historyArrow = findViewById(R.id.historyArrow);
            historyArrow.setVisibility(View.VISIBLE);

            TextView messages = findViewById(R.id.messagesText2);
            messages.setTextColor(getResources().getColor(R.color.colorPrimary));
            messages.setTypeface(null, Typeface.BOLD);
            messagesBtn.setClickable(true);
            messagesBtn.setColorFilter(getResources().getColor(R.color.colorPrimary));
            ImageView messagesArrow = findViewById(R.id.messagesArrow2);
            messagesArrow.setVisibility(View.VISIBLE);

            TextView available = findViewById(R.id.availableNote2);
            available.setVisibility(View.INVISIBLE);
        }

        TextView header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));
    }

    public void onFeelingsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), EmojiSelection.class);
        TextView header = findViewById(R.id.header);
        myIntent.putExtra("header", header.getText());
        startActivity(myIntent);
    }

    public void backToClasses(View v){
        Intent myIntent = new Intent(getBaseContext(), ClassList.class);
        startActivity(myIntent);
    }

    public void studentMessagesClick(View v){
        Intent myIntent = new Intent(getBaseContext(), StudentMessagesActivity.class);
        startActivity(myIntent);
    }

    public void goToCalendar(View v){
        Intent myIntent = new Intent(getBaseContext(), PastDataActivity.class);
        startActivity(myIntent);
    }
}
