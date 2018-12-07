package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TeacherClassListAcitivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_class_list);
    }

    // student period one click
    public void onTeacherPeriodOneClick(View v){
        TextView periodOneText = findViewById(R.id.periodOneTeacherText);

        Intent intent = new Intent(getApplicationContext(), TeacherDashboardActivity.class);
        intent.putExtra("header", "P1: " + periodOneText.getText());
        startActivity(intent);
    }

    // student period two click
    public void onTeacherPeriodTwoClick(View v){
        TextView periodTwoText = findViewById(R.id.periodTwoTeacherText);

        Intent intent = new Intent(getApplicationContext(), TeacherDashboardActivity.class);
        intent.putExtra("header", "P2: " + periodTwoText.getText());
        startActivity(intent);
    }

    // student period three click
    public void onTeacherPeriodThreeClick(View v){
        TextView periodThreeText = findViewById(R.id.periodThreeTeacherText);

        Intent intent = new Intent(getApplicationContext(), TeacherDashboardActivity.class);
        intent.putExtra("header", "P3: " + periodThreeText.getText());
        startActivity(intent);
    }

    // student period four click
    public void onTeacherPeriodFourClick(View v){
        TextView periodFourText = findViewById(R.id.periodFourTeacherText);

        Intent intent = new Intent(getApplicationContext(), TeacherDashboardActivity.class);
        intent.putExtra("header", "P4: " + periodFourText.getText());
        startActivity(intent);
    }

    // student period five click
    public void onTeacherPeriodFiveClick(View v){
        TextView periodFiveText = findViewById(R.id.periodFiveTeacherText);

        Intent intent = new Intent(getApplicationContext(), TeacherDashboardActivity.class);
        intent.putExtra("header", "P5: " + periodFiveText.getText());
        startActivity(intent);
    }

    // student period six click
    public void onTeacherPeriodSixClick(View v){
        TextView periodSixText = findViewById(R.id.periodSixTeacherText);

        Intent intent = new Intent(getApplicationContext(), TeacherDashboardActivity.class);
        intent.putExtra("header", "P6: " + periodSixText.getText());
        startActivity(intent);
    }

    public void logout(View v){
        System.out.println("TeacherClassListActivity");
        Intent myIntent = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(myIntent);
    }
}
