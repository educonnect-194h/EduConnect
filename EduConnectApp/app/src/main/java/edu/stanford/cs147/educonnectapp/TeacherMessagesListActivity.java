package edu.stanford.cs147.educonnectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class TeacherMessagesListActivity extends AppCompatActivity {

    private RecyclerView mConversationRecycler;
    private ConversationListAdapter mConversationAdapter;
    ArrayList<ConversationPreview> convoList;
    ArrayList<BaseMessage> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_messages_list);

        convoList = new ArrayList<>();
        ConversationPreview convo1 = new ConversationPreview("Jailene Miranda", "Hi Ms. Reyes, I just wanted to let you know that I'm going to be quiet and down today in class because a family member passed away.", 12);
        ConversationPreview convo2 = new ConversationPreview("Sanura N'Jaka", "I'm having a really hard time understanding this topic, math sucks.", 12);
        convoList.add(convo1);
        convoList.add(convo2);

        mConversationRecycler = findViewById(R.id.messagesRv);
        mConversationAdapter = new ConversationListAdapter(this, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {

            }

            @Override
            public void onLongClicked(int position) {

            }
        }, convoList, TeacherMessagesListActivity.this);

        mConversationRecycler.setLayoutManager(new LinearLayoutManager(this));
        mConversationRecycler.setAdapter(mConversationAdapter);
    }

    public void openConversation(ConversationPreview convo) {
        Intent i = new Intent(this, TeacherIndividualMessageActivity.class);
        i.putExtra("senderName", convo.getSenderName());
        i.putExtra("message", convo.getLastMessage());
  //      i.putExtra("messagesArray", messages);

  //      startActivityForResult(i, 1);
        startActivity(i);
    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//       // if (requestCode == 1) {
//            if(resultCode == RESULT_OK) {
//                Toast.makeText(getApplicationContext(), "codes correct", Toast.LENGTH_SHORT).show();
//                messages = (ArrayList<BaseMessage>) data.getExtras().getSerializable("messagesArray");
//
//                if (messages == null || messages.size() == 0) {
//                    Toast.makeText(getApplicationContext(), "whyyyyyyy", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getApplicationContext(), messages.get(0).getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//       // }
//
//        Toast.makeText(getApplicationContext(), "here.", Toast.LENGTH_SHORT).show();
//    }
}
