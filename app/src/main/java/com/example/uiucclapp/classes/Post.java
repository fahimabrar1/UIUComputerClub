package com.example.uiucclapp.classes;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class Post {

    public int image;
    public String title;
    public String venue;
    public String date;

    public Post(int image, String title, String venue, String date) {
        this.image = image;
        this.title = title;
        this.venue = venue;
        this.date = date;
    }
    public Post( String title, String venue, String date) {
        this.title = title;
        this.venue = venue;
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getVenue() {
        return venue;
    }

    public String getDate() {
        return date;
    }
}
