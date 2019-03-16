package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import static edu.stanford.cs147.educonnectapp.SubmissionActivity.PREFERENCES_NAME;

public class TeacherEmojiSelection extends AppCompatActivity {
    Boolean emojiAlreadySelected = false;
    ImageButton oldSelectedEmoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_emoji_selection);

        TextView header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));
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

        Bitmap bitmap = ((BitmapDrawable) emojiClicked.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();

        String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);

        SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).edit();
        editor.putString("emojiId", encodedImage);
        editor.apply();

    }

    public void onNextButtonTeacherClick(View v){
        if (emojiAlreadySelected) {
            Intent nextPage = new Intent(getBaseContext(), TeacherSubmissionActivity.class);
            TextView header = findViewById(R.id.header);
            nextPage.putExtra("header", header.getText());
            startActivity(nextPage);
        } else {
            Toast.makeText(this, "Please select an emoji.", Toast.LENGTH_SHORT).show();
        }
    }
}
