package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.ImageView;


public class TeacherSubmittedActivity extends AppCompatActivity {
    TextView teacherResponse;
    ImageView teacherEmoji;
    TextView teacherConjunction;
    public static final String PREFERENCES_NAME = "SharedPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_submitted);

        TextView header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));

        teacherResponse = findViewById(R.id.teacherResponse);
        SharedPreferences prefs = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("teacherDescriptionText", "I'm excited to play this game I made for the class today!");
        teacherResponse.setText(restoredText);
        String restoredConjunction = prefs.getString("teacherConjunction", "but...");
        teacherConjunction = findViewById(R.id.teacherSpinner);
        teacherConjunction.setText(restoredConjunction);


        String previouslyEncodedImage = prefs.getString("emojiId", "");

        if( !previouslyEncodedImage.equalsIgnoreCase("") ){
            teacherEmoji = findViewById(R.id.teacherEmoji);
            byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            teacherEmoji.setImageBitmap(bitmap);
        }

    }

    public void onFinalSubmit(View v){
        TextView header = findViewById(R.id.header);
        Intent myIntent = new Intent(getApplicationContext(), TeacherConfirmedSubmission.class);
        myIntent.putExtra("header", header.getText());
        myIntent.putExtra("Submitted", true);
        startActivity(myIntent);
    }

    public void onEditResponse(View v){
        this.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK));
        this.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK));
    }
}
