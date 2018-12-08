package edu.stanford.cs147.educonnectapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DataBreakdownActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_breakdown);

        TextView date = findViewById(R.id.date);
        date.setText(getIntent().getStringExtra("date"));
    }
}
