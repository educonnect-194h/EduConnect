package edu.stanford.cs147.educonnectapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.io.ByteArrayOutputStream;

import static edu.stanford.cs147.educonnectapp.R.*;


public class SubmissionActivity extends AppCompatActivity {
    public static final String PREFERENCES_NAME = "SharedPrefsFile";
    EditText description;
    Boolean emojiAlreadySelected = false;
    ImageButton oldSelectedEmoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_submission);
        description = findViewById(R.id.descriptionEt);


        Spinner spinner = findViewById(id.conjunction_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.text_options_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void onSubmitClick(View v){
        // Description text needs to be passed to "StudentDetailedResultsActivity"
        String descriptionText = description.getText().toString().trim();
        SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).edit();
        editor.putString("studentDescriptionText", descriptionText);
        editor.apply();
        Intent nextPage = new Intent(getBaseContext(), SubmittedActivity.class);
        startActivity(nextPage);
    }

    public void onEmojiClick(View v){
        ImageButton emojiClicked = findViewById(v.getId());
        if (!emojiAlreadySelected) {
            emojiClicked.setBackgroundResource(drawable.emoji_button_background);
            oldSelectedEmoji = emojiClicked;
        }
        else {
            oldSelectedEmoji.setBackgroundResource(0);
            emojiClicked.setBackgroundResource(drawable.emoji_button_background);
            oldSelectedEmoji = emojiClicked;
        }
        emojiAlreadySelected = true;

        Bitmap bitmap = ((BitmapDrawable) emojiClicked.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();

        String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);

        SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).edit();
        editor.putString("studentEmojiId", encodedImage);
        editor.apply();

    }
}
