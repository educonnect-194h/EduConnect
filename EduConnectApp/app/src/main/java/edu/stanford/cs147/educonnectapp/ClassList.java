package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ClassList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
    }

    // student period one click
    public void onPeriodOneClick(View v){
        TextView periodOneText = findViewById(R.id.periodOneText);

        Intent intent = new Intent(getApplicationContext(), StudentDashboardActivity.class);
        intent.putExtra("header", "P1: " + periodOneText.getText());
        startActivity(intent);
    }

    // student period two click
    public void onPeriodTwoClick(View v){
        TextView periodTwoText = findViewById(R.id.periodTwoText);

        Intent intent = new Intent(getApplicationContext(), StudentDashboardActivity.class);
        intent.putExtra("header", "P2: " + periodTwoText.getText());
        startActivity(intent);
    }

    // student period three click
    public void onPeriodThreeClick(View v){
        TextView periodThreeText = findViewById(R.id.periodThreeText);

        Intent intent = new Intent(getApplicationContext(), StudentDashboardActivity.class);
        intent.putExtra("header", "P3: " + periodThreeText.getText());
        startActivity(intent);
    }

    // student period four click
    public void onPeriodFourClick(View v){
        TextView periodFourText = findViewById(R.id.periodFourText);

        Intent intent = new Intent(getApplicationContext(), StudentDashboardActivity.class);
        intent.putExtra("header", "P4: " + periodFourText.getText());
        startActivity(intent);
    }

    // student period five click
    public void onPeriodFiveClick(View v){
        TextView periodFiveText = findViewById(R.id.periodFiveText);

        Intent intent = new Intent(getApplicationContext(), StudentDashboardActivity.class);
        intent.putExtra("header", "P5: " + periodFiveText.getText());
        startActivity(intent);
    }

    // student period six click
    public void onPeriodSixClick(View v){
        TextView periodSixText = findViewById(R.id.periodSixText);

        Intent intent = new Intent(getApplicationContext(), StudentDashboardActivity.class);
        intent.putExtra("header", "P6: " + periodSixText.getText());
        startActivity(intent);
    }


    public void logoutStudent(View v){
        System.out.println("ClassList.java");
        Intent myIntent = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(myIntent);
    }
}
