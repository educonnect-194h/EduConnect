package edu.stanford.cs147.educonnectapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import java.util.Calendar;


public class PastDataActivity extends AppCompatActivity {

    private String[] months = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
    private String today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_data);

        CalendarView calendar = findViewById(R.id.calendarView);
        calendar.setDate(Calendar.getInstance().getTimeInMillis(),false,true);

        today = months[Calendar.getInstance().get(Calendar.MONTH)] + " " + Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + ", " + Calendar.getInstance().get(Calendar.YEAR);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                String date = months[month] + " " + dayOfMonth + ", "+ year ;
                Intent intent = new Intent(getApplicationContext(), ClassResultsActivity.class);
                intent.putExtra("date", date);
                TextView title = findViewById(R.id.title);
                intent.putExtra("header", title.getText());
                if(date.equals(today)){
                    intent.putExtra("current", true);
                } else{
                    intent.putExtra("current", false);
                }
                startActivity(intent);
            }
        });
    }

    public void backToDashboard(View v){
        Intent myIntent = new Intent(getBaseContext(), TeacherDashboardActivity.class);
        myIntent.putExtra("Submitted", true);
        startActivity(myIntent);
    }
}
