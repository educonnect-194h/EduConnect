package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button studentLogin = findViewById(R.id.loginButtonStudent);
        studentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void onTeacherLoginClick(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherClassListAcitivty.class);
        startActivity(myIntent);
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
        Intent myIntent = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(myIntent);
    }

    public void backToDashboard(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherDashboardActivity.class);
        startActivity(myIntent);
    }

    public void onFeelingsClick(View v) {
        Intent myIntent = new Intent(getBaseContext(), SubmissionActivity.class);
        startActivity(myIntent);
    }

    public void onTeacherFeelingsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherSubmissionActivity.class);
        startActivity(myIntent);
    }

    public void onStudentSubmitClick(View v){
        Intent myIntent = new Intent(getBaseContext(), SubmittedActivity.class);
        startActivity(myIntent);
    }

    public void onTeacherSubmitClick(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherSubmittedActivity.class);
        startActivity(myIntent);
    }

    public void onClassResultsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), ClassResultsActivity.class);
        startActivity(myIntent);
    }

    public void onRedFlagsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), RedFlagsActivity.class);
        startActivity(myIntent);
    }

    public void onBackToDashClick(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherDashboardActivity.class);
        startActivity(myIntent);
    }

    public void login() {
        EditText username= findViewById(R.id.usernameField);
        EditText password= findViewById(R.id.passwordField);
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(user.equals("jailenem") && pass.equals("ilovejailene"))
        {
            setContentView(R.layout.activity_class_list);
        }else if(true){
            setContentView(R.layout.activity_class_list);
        } else{
            setContentView(R.layout.activity_class_list);
        }
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

}
