package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;


import java.util.Calendar;

public class ClassResultsActivity extends AppCompatActivity {

    private String[] months = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_results);

        Intent intent = this.getIntent();
        boolean current = true;

        if (intent.getExtras() != null) {
            current = intent.getExtras().getBoolean("current");
        }

        if(!current) {
            TextView header = findViewById(R.id.title);
            TextView date = findViewById(R.id.date);
            header.setText(getIntent().getStringExtra("header"));
            date.setText(getIntent().getStringExtra("date"));
            RelativeLayout flaggedStudents = findViewById(R.id.flaggedStudents);
            flaggedStudents.setVisibility(View.GONE);
        }else{
            TextView header = findViewById(R.id.header);
            String today = months[Calendar.getInstance().get(Calendar.MONTH)] + " " + Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + ", " + Calendar.getInstance().get(Calendar.YEAR);
            TextView date = findViewById(R.id.date);
            header.setText(getIntent().getStringExtra("header"));
            date.setText(today);
        }

        TextView header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));
    }

    public void onRedFlagsClick(View v){
        Intent myIntent = new Intent(getBaseContext(), RedFlagsActivity.class);
        TextView header = findViewById(R.id.header);
        header.setText(getIntent().getStringExtra("header"));
        startActivity(myIntent);
    }

    public void goToCalendar(View v){
        Intent myIntent = new Intent(getBaseContext(), PastDataActivity.class);
        startActivity(myIntent);
    }

    public void onMoreDetailsClick(View v){
        TextView date = findViewById(R.id.date);
        Intent myIntent = new Intent(getBaseContext(), DataBreakdownActivity.class);
        myIntent.putExtra("date", date.getText());
        startActivity(myIntent);
    }

    public void onPieClick(View v){
        Button pieButton = findViewById(R.id.pieChartButton);
        Button histogramButton = findViewById(R.id.histogramButton);
        Button boxPlotButton = findViewById(R.id.boxPlotButton);

        pieButton.setBackgroundResource(R.drawable.data_option_chosen);
        histogramButton.setBackgroundResource(R.drawable.data_option);
        boxPlotButton.setBackgroundResource(R.drawable.data_option);

        ImageView pieChart = findViewById(R.id.piechart);
        ImageView histogram = findViewById(R.id.histogram);
        ImageView boxPlot = findViewById(R.id.boxplot);

        pieChart.setVisibility(View.VISIBLE);
        histogram.setVisibility(View.GONE);
        boxPlot.setVisibility(View.GONE);

    }

    public void onHistogramClick(View v){
        Button pieButton = findViewById(R.id.pieChartButton);
        Button histogramButton = findViewById(R.id.histogramButton);
        Button boxPlotButton = findViewById(R.id.boxPlotButton);

        pieButton.setBackgroundResource(R.drawable.data_option);
        histogramButton.setBackgroundResource(R.drawable.data_option_chosen);
        boxPlotButton.setBackgroundResource(R.drawable.data_option);

        ImageView pieChart = findViewById(R.id.piechart);
        ImageView histogram = findViewById(R.id.histogram);
        ImageView boxPlot = findViewById(R.id.boxplot);

        pieChart.setVisibility(View.GONE);
        histogram.setVisibility(View.VISIBLE);
        boxPlot.setVisibility(View.GONE);
    }

    public void onBoxPlotClick(View v){
        Button pieButton = findViewById(R.id.pieChartButton);
        Button histogramButton = findViewById(R.id.histogramButton);
        Button boxPlotButton = findViewById(R.id.boxPlotButton);

        pieButton.setBackgroundResource(R.drawable.data_option);
        histogramButton.setBackgroundResource(R.drawable.data_option);
        boxPlotButton.setBackgroundResource(R.drawable.data_option_chosen);

        ImageView pieChart = findViewById(R.id.piechart);
        ImageView histogram = findViewById(R.id.histogram);
        ImageView boxPlot = findViewById(R.id.boxplot);

        pieChart.setVisibility(View.GONE);
        histogram.setVisibility(View.GONE);
        boxPlot.setVisibility(View.VISIBLE);
    }
}
