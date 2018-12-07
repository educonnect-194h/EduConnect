package edu.stanford.cs147.educonnectapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import static edu.stanford.cs147.educonnectapp.R.*;

public class TeacherSubmissionActivity extends AppCompatActivity {

    EditText description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_teacher_submission);
        description = findViewById(R.id.teacherDescriptionEt);


        Spinner spinner = findViewById(R.id.conjunction_spinner2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.text_options_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void onTeacherSubmitClick(View v){
        // Description text needs to be passed to "Submitted Activity"
        String descriptionText = description.getText().toString().trim();
        Intent passDescription = new Intent(this, SubmittedActivity.class);
        passDescription.putExtra("descriptionText", descriptionText);
        startActivity(passDescription);

        Intent myIntent = new Intent(getBaseContext(), TeacherSubmittedActivity.class);
        startActivity(myIntent);
    }

    public void onEmojiClick(View v){
        ImageButton emojiClicked = findViewById(v.getId());
        emojiClicked.setBackgroundResource(R.drawable.edit_text_background);
    }
}
