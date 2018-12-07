package edu.stanford.cs147.educonnectapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class LoginActivity extends AppCompatActivity {
    public static final String PREFERENCES_NAME = "SharedPrefsFile";
    Button studentLogin;
    EditText username;
    EditText password;
    EditText description;
    Boolean emojiAlreadySelected = false;
    ImageButton oldSelectedEmoji;
    TextView textEncode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        studentLogin = (Button) findViewById(R.id.loginButtonStudent);
        username= (EditText) findViewById(R.id.usernameField);
        password= (EditText) findViewById(R.id.passwordField);
        studentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        description = findViewById(R.id.descriptionEt);
    }

    public void onTeacherLoginClick(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherClassListAcitivty.class);
        startActivity(myIntent);
    }

    // student period one click
    public void onPeriodOneClick(View v){
        Intent myIntent = new Intent(getBaseContext(), StudentDashboardActivity.class);
        startActivity(myIntent);
    }

    public void logoutStudent(View v){
        System.out.println("ClassList.java");
        Intent myIntent = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(myIntent);
    }

    public void onBackClick(View v){
        Intent myIntent = new Intent(getBaseContext(), ClassList.class);
        startActivity(myIntent);
    }

    public void onFeelingsClick(View v) {
        Intent myIntent = new Intent(getBaseContext(), SubmissionActivity.class);
        startActivity(myIntent);
    }

    public void onTeacherFeelingsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherSubmissionActivity.class);
        startActivity(myIntent);
    }

    public void onTeacherPeriodOneClick(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherDashboardActivity.class);
        startActivity(myIntent);
    }

    public void onStudentSubmitClick(View v){
        Intent myIntent = new Intent(getBaseContext(), SubmittedActivity.class);
        startActivity(myIntent);
    }

    public void onTeacherSubmitClick(View v){
        // Description text needs to be passed to "Submitted Activity"
        String descriptionText = description.getText().toString().trim();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).edit();
        editor.putString("teacherDescriptionText", descriptionText);
        editor.apply();
        Intent nextPage = new Intent(getBaseContext(), TeacherSubmittedActivity.class);
        startActivity(nextPage);
    }

    public void onClassResultsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), ClassResultsActivity.class);
        startActivity(myIntent);
    }

    public void onMessagesClick(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherMessagesListActivity.class);
        startActivity(myIntent);
    }

    public void onRedFlagsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), RedFlagsActivity.class);
        startActivity(myIntent);
    }

    public void onBackToDashClick(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherDashboardActivity.class);
        startActivity(myIntent);
    }

    public void studentMessagesClick(View v){
        Intent myIntent = new Intent(getBaseContext(), StudentMessagesActivity.class);
        startActivity(myIntent);
    }



    public void login() {
        System.out.println("made it!");
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(user.equals("jailenem") && pass.equals("ilovejailene"))
        {
            setContentView(R.layout.activity_class_list);
        }else if(true){
            setContentView(R.layout.activity_student_history);
        } else{
            setContentView(R.layout.activity_class_list);
        }
    }

    public void onEmojiClick(View v){
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

    public void onTeacherEmojiClick(View v){
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
