package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RosterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);
    }
    public void studentProfileClick(View v){
        Intent myIntent = new Intent(getBaseContext(),StudentHistoryActivity.class);
        startActivity(myIntent);
    }

}
