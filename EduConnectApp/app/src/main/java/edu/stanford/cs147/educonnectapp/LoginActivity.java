package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Button studentLogin;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        studentLogin = (Button) findViewById(R.id.loginButtonStudent);
        username= (EditText) findViewById(R.id.usernameField);
        password= (EditText) findViewById(R.id.passwordField);
        studentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        mTextMessage = (TextView) findViewById(R.id.message);
    }

    public void onPeriodOneClick(View v){
        Intent myIntent = new Intent(getBaseContext(), StudentDashboardActivity.class);
        startActivity(myIntent);
    }

    public void onBackClick(View v){
        Intent myIntent = new Intent(getBaseContext(), ClassList.class);
        startActivity(myIntent);
    }

    public void onFeelingsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), SubmissionActivity.class);
        startActivity(myIntent);
    }

    public void login() {
        System.out.println("made it!");
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(user.equals("jailenem") && pass.equals("ilovejailene"))
        {
            setContentView(R.layout.activity_class_list);
        }else {
            setContentView(R.layout.activity_class_list);
        }
    }

}
