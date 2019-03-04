package edu.stanford.cs147.educonnectapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import static edu.stanford.cs147.educonnectapp.R.*;


public class TeacherSubmissionActivity extends AppCompatActivity {
    public static final String PREFERENCES_NAME = "SharedPrefsFile";
    EditText description;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String conjunctionText;
    ImageView teacherEmoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_teacher_submission);
        description = findViewById(R.id.teacherDescriptionEt);
        radioGroup = findViewById(R.id.radioGroup);

        TextView header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));

        header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));

        SharedPreferences prefs = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        String previouslyEncodedImage = prefs.getString("emojiId", "");

        if( !previouslyEncodedImage.equalsIgnoreCase("") ){
            teacherEmoji = findViewById(id.todayTeacherEmoji);
            byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            teacherEmoji.setImageBitmap(bitmap);
        }
    }

    public void checkButton(View v){
        //get id of checked radio button
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        conjunctionText = radioButton.getText().toString();
    }

    public void onTeacherSubmitClick(View v){
        // Description text needs to be passed to "Submitted Activity"
        String descriptionText = description.getText().toString().trim();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).edit();
        editor.putString("teacherDescriptionText", descriptionText);
        editor.putString("teacherConjunction", conjunctionText);
        editor.apply();
        Intent nextPage = new Intent(getApplicationContext(), TeacherSubmittedActivity.class);
        TextView header = findViewById(R.id.header);
        nextPage.putExtra("header", header.getText());
        startActivity(nextPage);
    }
}
