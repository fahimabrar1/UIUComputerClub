package com.example.uiucclapp.Services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;

import com.example.uiucclapp.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class PushNotification extends FirebaseMessagingService{
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {



        // Check if message contains a data payload.
        if (message.getData().size() > 0) {

            String  eDate = message.getData().get("eDate");
            String  etimefrom = message.getData().get("etimefrom");
            String  etimeto = message.getData().get("etimeto");
            String  evenue = message.getData().get("evenue");

            Log.d("Notif", "eDate: " + eDate);
            Log.d("Notif", "etimefrom: " + etimefrom);
            Log.d("Notif", "etimeto: " + etimeto);
            Log.d("Notif", "evenue: " + evenue);
            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use WorkManager.
                scheduleJob();
            } else {
                // Handle message within 10 seconds
                handleNow();
            }

        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
        String title = message.getNotification().getTitle();
        String text = message.getNotification().getBody();
        final String CHANNEL_ID = "NOTI";
        NotificationChannel channel  = null;

            channel = new NotificationChannel(
                    CHANNEL_ID,
                    "noti",
                    NotificationManager.IMPORTANCE_HIGH
            );

        getSystemService(NotificationManager.class).createNotificationChannel(channel);
        Notification.Builder notification = new Notification.Builder(this,CHANNEL_ID)
                .setContentText(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.ccl_logo)
                .setAutoCancel(true);
            NotificationManagerCompat.from(this).notify(1,notification.build());


        }
        super.onMessageReceived(message);
    }

    private void scheduleJob() {
    }

    private void handleNow() {
    }
}
