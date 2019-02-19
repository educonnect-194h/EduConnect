package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.io.ByteArrayOutputStream;

import static edu.stanford.cs147.educonnectapp.R.*;


public class SubmissionActivity extends AppCompatActivity {
    public static final String PREFERENCES_NAME = "SharedPrefsFile";
    EditText description;
    Boolean emojiAlreadySelected = false;
    ImageButton oldSelectedEmoji;
    ScrollView SubmissionScrollView;
    SeekBar seekBar;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String conjunctionText;
    int[] emojiList = new int[]{R.drawable.angry, R.drawable.sick, R.drawable.sad,
        R.drawable.sleepy, R.drawable.neutral, R.drawable.sunglasses, R.drawable.grinning,
        R.drawable.feisty};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_submission);
        description = findViewById(R.id.descriptionEt);
        radioGroup = findViewById(R.id.radioGroup);
        SubmissionScrollView = findViewById(id.SubmissionScrollView);

//        Spinner spinner = findViewById(id.conjunction_spinner);
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.text_options_array, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
//        description.setOnTouchListener(new View.OnTouchListener()
//        {
//            @Override
//            public boolean onTouch(View arg0, MotionEvent arg1)
//            {
//                focusOnView();
//                return false;
//            }
//        });

        seekBar = findViewById(R.id.emojiBar);
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
                editor.putString("studentEmojiId", encodedImage);
                editor.apply();
            }
        });
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
        startActivity(nextPage);
    }
}
