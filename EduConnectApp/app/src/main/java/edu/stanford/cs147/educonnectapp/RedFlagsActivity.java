package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RedFlagsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_flags);

        TextView header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));
    }

    public void onSeeStudentHistoryClick(View v){
        Intent intent = new Intent(getApplicationContext(), StudentHistoryActivity.class);
        startActivity(intent);
    }

    public void onMessageStudentClick(View v) {
        TextView name = findViewById(R.id.tvStudentName);

        Intent i = new Intent(this, TeacherIndividualMessageActivity.class);
        i.putExtra("senderName", name.getText());
        i.putExtra("message", "Sending a red flag message......");

        startActivity(i);
    }
}
