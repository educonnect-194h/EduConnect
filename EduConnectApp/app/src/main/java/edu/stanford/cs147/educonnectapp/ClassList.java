package edu.stanford.cs147.educonnectapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClassList extends AppCompatActivity {

    Button periodOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);

        periodOne = findViewById(R.id.periodOne);
        System.out.println("Yeahhhh");

        periodOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("yeet");
                loadDashboard();
            }
        });
    }

    private void loadDashboard(){
        System.out.println("okay now ladies");
        setContentView(R.layout.activity_class_list);
    }

    public void hi(View view){
        System.out.println("okay something works");
    }
}
