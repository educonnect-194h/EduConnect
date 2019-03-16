package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;

public class ClassResultsActivity extends AppCompatActivity {
    private BottomSheetBehavior mBottomSheetBehavior;

    private String[] months = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};

    PieChart pieChart;
    TextView bottomText;
    ImageView bigEmoji;

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

        final View bottomSheet = findViewById(R.id.bottom_sheet);
        bigEmoji = findViewById(R.id.bigEmoji);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        // PIE CHART CREATION
        pieChart = (PieChart) findViewById(R.id.animatedpiechart);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.getLegend().setEnabled(false);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setUsePercentValues(true);
        pieChart.setCenterText("Data\n Breakdown");
        pieChart.setCenterTextSize(20);
        pieChart.setCenterTextColor(R.color.colorPrimary);

        bottomText = findViewById(R.id.bottomSheetText);

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                if (e == null){
                    return;
                }
                pieChart.setDrawMarkers(true);
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                bottomText.setText("Students who feel ...");
                //e.
            }

            @Override
            public void onNothingSelected() {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                bottomText = findViewById(R.id.bottomSheetText);
                bottomText.setText("Click a section to view the student list!");
            }
        });
        pieChart.setTouchEnabled(true);

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(14, "Sick"));
        yValues.add(new PieEntry(38, "Confident"));
        yValues.add(new PieEntry(14, "Jubilant"));
        yValues.add(new PieEntry(34, "Sleepy"));

        PieDataSet dataSet = new PieDataSet(yValues, "Emojis");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(20f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);


    }


    public void goToCalendar(View v){
        Intent myIntent = new Intent(getBaseContext(), PastDataActivity.class);
        startActivity(myIntent);
    }

    public void onMessageStudentClick(View v) {
        TextView name = findViewById(R.id.tvStudentName);

        Intent i = new Intent(this, TeacherIndividualMessageActivity.class);
        i.putExtra("senderName", name.getText());
        i.putExtra("message", "Sending a red flag message......");

        startActivity(i);
    }

}
