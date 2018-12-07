package edu.stanford.cs147.educonnectapp;

import java.io.Serializable;

public class BaseMessage implements Serializable {
    String message;
    String senderName;
    long sentAt;

    public BaseMessage(String n, String m, long time) {
        message = m;
        senderName = n;
        sentAt = time;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderName() {
        return senderName;
    }

    public long getSentAt() {
        return sentAt;
    }

    public void setMessage(String m) {
        message = m;
    }

    public void setSenderName(String n) {
        senderName = n;
    }

    public void setSentAt(long time) {
        sentAt = time;
    }
}
