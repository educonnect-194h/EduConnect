package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentMessagesActivity extends AppCompatActivity {

    private RecyclerView mMessageRecycler;
    private StudentMessagesAdapter mMessageAdapter;
    ArrayList<BaseMessage> messages;
    TextView mSenderName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_messages);


        mSenderName = findViewById(R.id.tvName2);
        mSenderName.setText("Ms. Reyes");

        messages = new ArrayList<>();
        BaseMessage baseMessage1 = new BaseMessage("Jailene Miranda", "Hi, I'm feeling really sad today because my kitten died. Can we chat after class?", 12);
        BaseMessage baseMessage2 = new BaseMessage("Ms. Reyes", "Hi, Jailene! I'm sorry to hear that! Please come to my office after class.", 12);
        messages.add(baseMessage1);
        messages.add(baseMessage2);


        mMessageRecycler = findViewById(R.id.reyclerview_student_messages);
        mMessageAdapter = new StudentMessagesAdapter(this, messages);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageRecycler.setAdapter(mMessageAdapter);
    }

    public void sendStudentResponse(View v) {
        EditText responseEt = findViewById(R.id.edittext_chatbox2);
        String responseString = responseEt.getText().toString();
        responseEt.setText("");

        BaseMessage responseBm = new BaseMessage("Jailene Miranda", responseString, 12);
        messages.add(responseBm);

        mMessageAdapter.notifyItemInserted(messages.size() - 1);
    }
}
