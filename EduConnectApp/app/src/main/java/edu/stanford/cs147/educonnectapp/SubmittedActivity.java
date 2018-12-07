package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SubmittedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitted);
        // PUT THIS IN DetailedSRResults.java IN ONCREATE:
        //Intent intent = getIntent();
        //String descriptionText = intent.getExtras().getString("descriptionText");
    }

    public void onBackToDashClick(View v){
        Intent myIntent = new Intent(getBaseContext(), StudentDashboardActivity.class);
        myIntent.putExtra("Submitted", true);
        startActivity(myIntent);
    }
}
