package edu.stanford.cs147.educonnectapp;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Base64;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class PastDataActivity extends AppCompatActivity {

    public static final String PREFERENCES_NAME = "SharedPrefsFile";

    private String[] months = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
    private String today;
    private int daySelected;

    ImageView emoji;
    TextView submissionText;
    TextView dateTv;

    private LinkedHashMap<Drawable, String> submissionHistory = new LinkedHashMap<Drawable, String>() {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_data);

        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sad, null), "I am very sad");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.angry, null), "I am very angry");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.anxious, null), "I am very anxious");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.feisty, null), "I am very excited");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.grinning, null), "I am very happy");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.neutral, null), "I am very neutral");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sick, null), "I am very sick");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sleepy, null), "I am very sleepy");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sunglasses, null), "I am very cool");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sad, null), "I am very sad");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.angry, null), "I am very angry");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.anxious, null), "I am very anxious");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.feisty, null), "I am very excited");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.grinning, null), "I am very happy");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.neutral, null), "I am very neutral");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sick, null), "I am very sick");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sleepy, null), "I am very sleepy");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sunglasses, null), "I am very cool");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sad, null), "I am very sad");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.angry, null), "I am very angry");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.anxious, null), "I am very anxious");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.feisty, null), "I am very excited");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.grinning, null), "I am very happy");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.neutral, null), "I am very neutral");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sick, null), "I am very sick");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sleepy, null), "I am very sleepy");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sunglasses, null), "I am very cool");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.sad, null), "I am very sad");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.angry, null), "I am very angry");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.anxious, null), "I am very anxious");
        submissionHistory.put(ResourcesCompat.getDrawable(getResources(), R.drawable.feisty, null), "I am very excited");

        CalendarView calendar = findViewById(R.id.calendarView);
        calendar.setDate(Calendar.getInstance().getTimeInMillis(),false,true);

        daySelected = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        today = months[Calendar.getInstance().get(Calendar.MONTH)] + " " + daySelected + ", " + Calendar.getInstance().get(Calendar.YEAR);

        dateTv = findViewById(R.id.showDateTv);
        dateTv.setText("Showing Submission for " + today);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                daySelected = dayOfMonth;
                emoji.setImageDrawable((new ArrayList<>(submissionHistory.keySet())).get(daySelected - 1));

                submissionText = findViewById(R.id.submissionTv);
                submissionText.setText((new ArrayList<>(submissionHistory.values())).get(daySelected - 1));

                String date = months[month] + " " + dayOfMonth + ", "+ year ;
                dateTv.setText("Showing Submission for " + date);

/*              Intent intent = new Intent(getApplicationContext(), ClassResultsActivity.class);
                intent.putExtra("date", date);
                TextView title = findViewById(R.id.title);
                intent.putExtra("header", title.getText());
                if(date.equals(today)){
                    intent.putExtra("current", true);
                } else{
                    intent.putExtra("current", false);
                }
                startActivity(intent);*/
            }
        });
/*
        SharedPreferences prefs = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        String previouslyEncodedImage = prefs.getString("studentEmojiId", "");
        ImageView emoji = findViewById(R.id.datedEmoji);
        byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
        emoji.setImageBitmap(bitmap);*/

        emoji = findViewById(R.id.datedEmoji);
        emoji.setImageDrawable((new ArrayList<>(submissionHistory.keySet())).get(daySelected - 1));

        submissionText = findViewById(R.id.submissionTv);
        submissionText.setText((new ArrayList<>(submissionHistory.values())).get(daySelected - 1));
    }

    public void backToDashboard(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherDashboardActivity.class);
        myIntent.putExtra("Submitted", true);
        startActivity(myIntent);
    }
}
