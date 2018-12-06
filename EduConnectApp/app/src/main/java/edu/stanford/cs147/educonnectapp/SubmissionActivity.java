package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.io.ByteArrayOutputStream;

public class SubmissionActivity extends AppCompatActivity {
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        description = findViewById(R.id.descriptionEt);

        Spinner spinner = findViewById(R.id.spinner_options);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.text_options_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void onStudentSubmitClick(View v){
        // Description text only needs to be passed to "Detailed Student Reports Results"
        // on Teacher side
        //UNCOMMENT THIS WHEN DETAILEDSRRESULTS IS CREATED
//        String descriptionText = description.getText().toString().trim();
//        Intent passDescription = new Intent(this, DetailedSRResults.class);
//        passDescription.putExtra("descriptionText", descriptionText);
//        startActivity(passDescription);
//        // PUT THIS IN DetailedSRResults.java IN ONCREATE:
//        Intent intent = getIntent();
//        String descriptionText = intent.getExtras().getString("descriptionText");
        Intent myIntent = new Intent(getBaseContext(), SubmittedActivity.class);
        startActivity(myIntent);
    }

    public void onEmojiClick(View v){
        ImageButton emojiClicked = findViewById(v.getId());
//        Drawable emojiImage = emojiClicked.getDrawable();
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), emojiClicked.getId());
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//        byte[] b = baos.toByteArray();
//
//        Intent passEmojiClicked = new Intent(this, DetailedSRResults.class);
//        passEmojiClicked.putExtra("emojiImage", b);
//        startActivity(passEmojiClicked);

        emojiClicked.setBackgroundResource(R.drawable.edit_text_background);

    }
    
}
