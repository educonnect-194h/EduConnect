package edu.stanford.cs147.educonnectapp;

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
        System.out.println("cool shiz");

        studentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        mTextMessage = (TextView) findViewById(R.id.message);
    }

    public void login() {
        System.out.println("made it!");
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(user.equals("jailenem") && pass.equals("ilovejailene"))
        {
            setContentView(R.layout.activity_class_list);
        }else {
            Toast.makeText(this, "Username and password do not match. Please try again.", Toast.LENGTH_LONG).show();
        }
    }

}
