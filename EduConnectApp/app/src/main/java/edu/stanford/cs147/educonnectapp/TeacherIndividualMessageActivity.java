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

public class TeacherIndividualMessageActivity extends AppCompatActivity {

    private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;
    ArrayList<BaseMessage> messages;
    String message;
    TextView mSenderName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_individual_message);

        Intent i = getIntent();
        String name = i.getExtras().getString("senderName");

        mSenderName = findViewById(R.id.tvName);
        mSenderName.setText(name);

        message = i.getExtras().getString("message");

        messages = new ArrayList<>();

        if (!message.equals("Sending a red flag message......")) {
//        if (i.getExtras().get("messagesArray") != null) {
//            Toast.makeText(getApplicationContext(), "array not null?", Toast.LENGTH_SHORT).show();
//            messages = (ArrayList<BaseMessage>) i.getExtras().getSerializable("messagesArray");
//        } else {
            //     Toast.makeText(getApplicationContext(), "array null ugh", Toast.LENGTH_SHORT).show();

            BaseMessage baseMessage = new BaseMessage(name, message, 12);
            messages.add(baseMessage);
            //      }
        }

        mMessageRecycler = findViewById(R.id.reyclerview_message_list);
        mMessageAdapter = new MessageListAdapter(this, messages);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageRecycler.setAdapter(mMessageAdapter);
    }

    public void sendTeacherResponse(View v) {
        EditText responseEt = findViewById(R.id.edittext_chatbox);
        String responseString = responseEt.getText().toString();
        responseEt.setText("");

        BaseMessage responseBm = new BaseMessage("Ms. Miranda", responseString, 12);
        messages.add(responseBm);

        mMessageAdapter.notifyItemInserted(messages.size() - 1);
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//
//        Intent intent = new Intent();
//        intent.putExtra("messagesArray", messages);
//        setResult(RESULT_OK, intent);
//       // finish();
//    }
}
