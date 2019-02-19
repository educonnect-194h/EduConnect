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
    SeekBar seekBar;
    ScrollView SubmissionScrollView;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String conjunctionText;
    int[] emojiList = new int[]{R.drawable.angry, R.drawable.sick, R.drawable.sad,
            R.drawable.sleepy, R.drawable.neutral, R.drawable.sunglasses, R.drawable.grinning,
            R.drawable.feisty};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_teacher_submission);
        description = findViewById(R.id.teacherDescriptionEt);
        radioGroup = findViewById(R.id.radioGroup);

        TextView header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));
        seekBar = findViewById(R.id.teacherEmojiBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int curr_i;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                curr_i = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Drawable d = getResources().getDrawable(emojiList[curr_i]);
                ImageView today = findViewById(id.today_emoji);
                today.setImageDrawable(d);

                Bitmap bitmap = ((BitmapDrawable) d).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();

                String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);

                SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).edit();
                editor.putString("emojiId", encodedImage);
                editor.apply();
            }
        });

        header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));
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
