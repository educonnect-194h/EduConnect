package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClassListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list2);


    }
    public void onPeriodOneClick(View v){
        Intent myIntent = new Intent(getBaseContext(), StudentDashboardActivity.class);
        startActivity(myIntent);
    }


}
