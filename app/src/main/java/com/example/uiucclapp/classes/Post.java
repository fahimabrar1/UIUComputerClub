package com.example.uiucclapp.classes;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class Post {


    String eventName;
    String eventDate;
    String eventVenue;
    String eventDes;
    String evenTime ;


    public Post(String eventName, String eventDate, String eventVenue, String eventDes, String evenTime) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.eventDes = eventDes;
        this.evenTime = evenTime;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public String getEventDes() {
        return eventDes;
    }

    public String getEvenTime() {
        return evenTime;
    }
}
