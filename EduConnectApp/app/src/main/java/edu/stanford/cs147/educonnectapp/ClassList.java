package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClassList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
    }

    public void onPeriodOneClick(View v){
        Intent myIntent = new Intent(getBaseContext(), StudentDashboardActivity.class);
        startActivity(myIntent);
    }

    public void logoutStudent(View v){
        System.out.println("ClassList.java");
        Intent myIntent = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(myIntent);
    }
}
