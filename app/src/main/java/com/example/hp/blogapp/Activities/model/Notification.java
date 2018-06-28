package com.example.hp.blogapp.Activities.model;

/**
 * Created by hp on 6/28/2018.
 */

public class Notification {

    public String message;
    public String date;
    public String from;

    public Notification(String message, String date, String from) {
        this.message = message;
        this.date = date;
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
