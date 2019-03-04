package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;


import static edu.stanford.cs147.educonnectapp.R.*;


public class SubmissionActivity extends AppCompatActivity {
    public static final String PREFERENCES_NAME = "SharedPrefsFile";
    EditText description;
    ScrollView SubmissionScrollView;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String conjunctionText;
    ImageView studentEmoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_submission);
        description = findViewById(R.id.descriptionEt);
        radioGroup = findViewById(R.id.radioGroup);
        SubmissionScrollView = findViewById(id.SubmissionScrollView);

        TextView header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));

        SharedPreferences prefs = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        String previouslyEncodedImage = prefs.getString("studentEmojiId", "");

        if( !previouslyEncodedImage.equalsIgnoreCase("") ){
            studentEmoji = findViewById(R.id.todayStudentEmoji);
            byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            studentEmoji.setImageBitmap(bitmap);
        }
    }

    public void checkButton(View v){
        //get id of checked radio button
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        conjunctionText = radioButton.getText().toString();
    }
    private void focusOnView(){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                SubmissionScrollView.scrollTo(0, description.getBottom());
            }
        });
    }

    public void onSubmitClick(View v){
        // Description text needs to be passed to "StudentDetailedResultsActivity"
        String descriptionText = description.getText().toString().trim();
        SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).edit();
        editor.putString("studentDescriptionText", descriptionText);
      //  editor.putString("studentConjunction", conjunctionText);
        editor.apply();
        Intent nextPage = new Intent(getBaseContext(), SubmittedActivity.class);
        TextView header = findViewById(R.id.header);
        nextPage.putExtra("header", header.getText());
        startActivity(nextPage);
    }
}
