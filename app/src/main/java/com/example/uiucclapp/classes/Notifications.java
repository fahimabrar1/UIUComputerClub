package com.example.uiucclapp.classes;

public class Notifications {
    private String Event_Name;
    private String Event_Venue;
    private String Event_Date;
    private String Event_Time;
    private String Notif_Time;
    private String Notif_Day;
    private String Notif_Date;

    public Notifications(String event_Name, String event_Venue, String event_Date, String event_Time,String Notif_Time,String Notif_Day,String Notif_Date) {
        this.Event_Name = event_Name;
        this.Event_Venue = event_Venue;
        this.Event_Date = event_Date;
        this.Event_Time = event_Time;
        this.Notif_Day = Notif_Day;
        this.Notif_Date = Notif_Date;
        this.Notif_Time = Notif_Time;
    }

    public String getEvent_Name() {
        return Event_Name;
    }

    public String getEvent_Venue() {
        return Event_Venue;
    }

    public String getEvent_Date() {
        return Event_Date;
    }

    public String getEvent_Time() {
        return Event_Time;
    }

    public String getNotif_Time() {
        return Notif_Time;
    }

    public String getNotif_Day() {
        return Notif_Day;
    }

    public String getNotif_Date() {
        return Notif_Date;
    }
}
