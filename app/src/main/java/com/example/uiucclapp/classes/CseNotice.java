package com.example.uiucclapp.classes;

public class CseNotice {

    private String notifDate;
    private String notifTime;
    private String notifDay;
    private String heading;
    private String des;


    public CseNotice(String notifDate, String notifTime, String notifDay, String heading,String des) {
        this.notifDate = notifDate;
        this.notifTime = notifTime;
        this.notifDay = notifDay;
        this.heading = heading;
        this.des = des;
    }

    public String getNotifDate() {
        return notifDate;
    }

    public String getNotifTime() {
        return notifTime;
    }

    public String getNotifDay() {
        return notifDay;
    }

    public String getHeading() {
        return heading;
    }

    public String getDes() {
        return des;
    }
}
