package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class SubmissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

//        Spinner spinner = findViewById(R.id.spinner_options);
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.text_options_array, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
    }

    public void onStudentSubmitClick(View v){
        Intent myIntent = new Intent(getBaseContext(), SubmittedActivity.class);
        startActivity(myIntent);
    }

    public void onEmojiClick(View v){
        ImageButton emojiClicked = findViewById(v.getId());
        emojiClicked.setBackgroundResource(R.drawable.edit_text_background);

    }
    
}
