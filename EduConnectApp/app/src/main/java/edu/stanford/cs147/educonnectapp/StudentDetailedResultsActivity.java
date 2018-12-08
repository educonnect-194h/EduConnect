package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentDetailedResultsActivity extends AppCompatActivity {
    TextView studentResponse;
    ImageView studentEmoji;
    public static final String PREFERENCES_NAME = "SharedPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detailed_results);
        studentResponse = findViewById(R.id.studentResponse);
        SharedPreferences prefs = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("studentDescriptionText", "No teacher response yet");
        studentResponse.setText(restoredText);

        String previouslyEncodedImage = prefs.getString("studentEmojiId", "");

        if( !previouslyEncodedImage.equalsIgnoreCase("") ){
            studentEmoji = findViewById(R.id.studentEmoji);
            byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            studentEmoji.setImageBitmap(bitmap);
        }
    }

    public void onBackToDashClick(View v){
        Intent myIntent = new Intent(getBaseContext(), StudentHistoryActivity.class);
        myIntent.putExtra("Submitted", true);
        startActivity(myIntent);
    }
}
