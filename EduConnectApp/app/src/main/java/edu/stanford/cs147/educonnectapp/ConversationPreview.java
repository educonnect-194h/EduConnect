package edu.stanford.cs147.educonnectapp;

public class ConversationPreview {

    String senderName;
    String lastMessage;
    long timeSent;

    public ConversationPreview(String n, String m, long t) {
        senderName = n;
        lastMessage = m;
        timeSent = t;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public long getTimeSent() {
        return timeSent;
    }

    public void setSenderName(String n) {
        senderName = n;
    }

    public void setLastMessage(String m) {
        lastMessage = m;
    }

    public void setTimeSent(long t) {
        timeSent = t;
    }
}
