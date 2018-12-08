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
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import static edu.stanford.cs147.educonnectapp.R.*;


public class TeacherSubmissionActivity extends AppCompatActivity {
    public static final String PREFERENCES_NAME = "SharedPrefsFile";
    EditText description;
    Boolean emojiAlreadySelected = false;
    ImageButton oldSelectedEmoji;
    TextView textEncode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_teacher_submission);
        description = findViewById(R.id.teacherDescriptionEt);


        Spinner spinner = findViewById(R.id.conjunction_spinner2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.text_options_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void onTeacherSubmitClick(View v){
        // Description text needs to be passed to "Submitted Activity"
        String descriptionText = description.getText().toString().trim();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).edit();
        editor.putString("teacherDescriptionText", descriptionText);
        Spinner conjunction = findViewById(id.conjunction_spinner2);
        String conjunctionText = conjunction.getSelectedItem().toString();
        editor.putString("teacherConjunction", conjunctionText);
        editor.apply();
        Intent nextPage = new Intent(getBaseContext(), TeacherSubmittedActivity.class);
        startActivity(nextPage);
    }

    public void onTeacherEmojiClick(View v){
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
        Integer emojiClickedId = emojiClicked.getId();

        Bitmap bitmap = ((BitmapDrawable) emojiClicked.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();

        String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);

        SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).edit();
        editor.putString("emojiId", encodedImage);
        editor.apply();

        // Passing emoji to Student Submitted Activity (Your teacher feels...)
    }
}
