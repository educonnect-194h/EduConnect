package edu.stanford.cs147.educonnectapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SubmittedActivity extends AppCompatActivity {
    TextView teacherResponse;
    ImageView teacherEmoji;
    public static final String PREFERENCES_NAME = "SharedPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitted);
        teacherResponse = findViewById(R.id.teacherResponse);
        SharedPreferences prefs = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("teacherDescriptionText", "No teacher response yet");
        teacherResponse.setText(restoredText);

        String previouslyEncodedImage = prefs.getString("emojiId", "");

        if( !previouslyEncodedImage.equalsIgnoreCase("") ){
            teacherEmoji = findViewById(R.id.teacherEmoji);
            byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            teacherEmoji.setImageBitmap(bitmap);
        }
    }

    public void onBackToDashClick(View v){
        Intent myIntent = new Intent(getBaseContext(), StudentDashboardActivity.class);
        myIntent.putExtra("Submitted", true);
        startActivity(myIntent);
    }
}
