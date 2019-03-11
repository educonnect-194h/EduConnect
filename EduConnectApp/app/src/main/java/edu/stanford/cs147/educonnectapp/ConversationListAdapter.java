package edu.stanford.cs147.educonnectapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ConversationListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayList<ConversationPreview> mConversationList;
    private final ClickListener mListener;
    private Activity mActivity;

    public ConversationListAdapter(Context context, ClickListener listener, ArrayList<ConversationPreview> conversationList, Activity activity) {
        mContext = context;
        mListener = listener;
        mConversationList = conversationList;
        mActivity = activity;

//        ConversationPreview convoPreview = new ConversationPreview("Jailene Miranda",
//                "Hi, I'm feeling really sad today because my kitten died. Can we chat after class?",
//                12);
//        mConversationList.add(convoPreview);
    }

    @Override
    public int getItemCount() {
        return mConversationList.size();
    }

    // Inflates the appropriate layout according to the ViewType.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conversation_preview, parent, false);

        return new ConversationPreviewHolder(view, mListener);
    }

    // Passes the message object to a ViewHolder so that the contents can be bound to UI.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ConversationPreview convoPreview = mConversationList.get(position);

        ((ConversationPreviewHolder) holder).bind(convoPreview);
    }

    private class ConversationPreviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private WeakReference<ClickListener> listenerWeakReference;

        TextView messageText, timeText, nameText;

        ConversationPreviewHolder(View itemView, ClickListener mListener) {
            super(itemView);

            nameText = itemView.findViewById(R.id.tvName);
            messageText = itemView.findViewById(R.id.tvLastMessage);
            timeText = itemView.findViewById(R.id.tvTime);

            listenerWeakReference = new WeakReference<>(mListener);
            itemView.setOnClickListener(this);
        }

        void bind(ConversationPreview convoPreview) {
            messageText.setText(convoPreview.getLastMessage());

            // TODO: Format the stored timestamp into a readable String using method.
            // timeText.setText(Utils.formatDateTime(message.getCreatedAt()));
            timeText.setText("11:21am");

            nameText.setText(convoPreview.getSenderName());
        }

        @Override
        public void onClick(View view) {
            TeacherMessagesListActivity activity = (TeacherMessagesListActivity) itemView.getContext();
            activity.openConversation(mConversationList.get(getAdapterPosition()));

            listenerWeakReference.get().onPositionClicked(getAdapterPosition());
        }
    }
}
