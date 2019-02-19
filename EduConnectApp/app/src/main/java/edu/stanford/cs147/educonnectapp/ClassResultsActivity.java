package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;


import java.util.Calendar;

public class ClassResultsActivity extends AppCompatActivity {

    private String[] months = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_results);

        Intent intent = this.getIntent();
        boolean current = true;

        if (intent.getExtras() != null) {
            current = intent.getExtras().getBoolean("current");
        }

        if(!current) {
            TextView header = findViewById(R.id.title);
            TextView date = findViewById(R.id.date);
            header.setText(getIntent().getStringExtra("header"));
            date.setText(getIntent().getStringExtra("date"));
            RelativeLayout flaggedStudents = findViewById(R.id.flaggedStudents);
            flaggedStudents.setVisibility(View.GONE);
        }else{
            TextView header = findViewById(R.id.header);
            String today = months[Calendar.getInstance().get(Calendar.MONTH)] + " " + Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + ", " + Calendar.getInstance().get(Calendar.YEAR);
            TextView date = findViewById(R.id.date);
            header.setText(getIntent().getStringExtra("header"));
            date.setText(today);
        }

        TextView header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));
    }

    public void onRedFlagsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), RedFlagsActivity.class);
        //TextView header = findViewById(R.id.header);
        //header.setText(getIntent().getStringExtra("header"));
        startActivity(myIntent);
    }

    public void goToCalendar(View v){
        Intent myIntent = new Intent(getBaseContext(), PastDataActivity.class);
        startActivity(myIntent);
    }

    public void onMoreDetailsClick(View v){
        TextView date = findViewById(R.id.date);
        Intent myIntent = new Intent(getBaseContext(), DataBreakdownActivity.class);
        myIntent.putExtra("date", date.getText());
        startActivity(myIntent);
    }
}
