package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;


public class SubmissionActivity extends AppCompatActivity {
    EditText description;
    ImageButton oldSelectedEmoji;
    Boolean emojiAlreadySelected = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        Spinner conjunctionSpinner = findViewById(R.id.conjunction_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.text_options_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        conjunctionSpinner.setAdapter(adapter);
        conjunctionSpinner.setPrompt("Choose a conjunction...");
    }

    public void onStudentSubmitClick(View v){
        Intent myIntent = new Intent(getBaseContext(), SubmittedActivity.class);
        startActivity(myIntent);
    }

    public void onEmojiClick(View v){
//        Drawable emojiImage = emojiClicked.getDrawable();
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), emojiClicked.getId());
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//        byte[] b = baos.toByteArray();
//
//        Intent passEmojiClicked = new Intent(this, DetailedSRResults.class);
//        passEmojiClicked.putExtra("emojiImage", b);
//        startActivity(passEmojiClicked);

        ImageButton emojiClicked = findViewById(v.getId());
        if (!emojiAlreadySelected) {
            emojiClicked.setBackgroundResource(R.drawable.emoji_button_background);
            oldSelectedEmoji = emojiClicked;
        }
        else {
            oldSelectedEmoji.setBackgroundResource(0);
            emojiClicked.setBackgroundResource(R.drawable.emoji_button_background);
            oldSelectedEmoji = emojiClicked;
        }
        emojiAlreadySelected = true;

    }
    
}
