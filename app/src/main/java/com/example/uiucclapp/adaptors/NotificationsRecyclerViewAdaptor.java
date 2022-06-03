package com.example.uiucclapp.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uiucclapp.R;
import com.example.uiucclapp.RecyclerClickListener;
import com.example.uiucclapp.classes.Notifications;
import com.example.uiucclapp.fragments.childfragments.Notification_fragment;

import java.util.List;

public class NotificationsRecyclerViewAdaptor extends RecyclerView.Adapter<NotificationsRecyclerViewAdaptor.MyViewHolder> {

    private static RecyclerClickListener setClickListener;
    private Context context;
    private List<Notifications> notifications;
    private Notification_fragment _notification_fragment;

    public NotificationsRecyclerViewAdaptor(List<Notifications> notifications, Notification_fragment _notification_fragment) {
        this.notifications = notifications;
        this._notification_fragment = _notification_fragment;
    }

    public NotificationsRecyclerViewAdaptor(Context context, List<Notifications> notifications) {
        this.context = context;
        this.notifications = notifications;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.ccl_notification_sample,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.event_name.setText(notifications.get(position).getEvent_Name());
        holder.event_venue.setText(notifications.get(position).getEvent_Venue());
        holder.event_date.setText(notifications.get(position).getEvent_Date());
        holder.event_time.setText(notifications.get(position).getEvent_Time());
        holder.notif_Date.setText(notifications.get(position).getNotif_Date());
        holder.notif_Day.setText(notifications.get(position).getNotif_Day());
        holder.notif_Time.setText(notifications.get(position).getNotif_Time());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        // public ImageView image;
        public TextView event_name;
        public TextView event_venue;
        public TextView event_date;
        public TextView event_time;
        public TextView notif_Date;
        public TextView notif_Day;
        public TextView notif_Time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //image = itemView.findViewById(R.id.post_image);
            event_name = itemView.findViewById(R.id.ccl_notification_event_name);
            event_venue = itemView.findViewById(R.id.ccl_notification_event_venue);
            event_date = itemView.findViewById(R.id.ccl_notification_event_date);
            event_time = itemView.findViewById(R.id.ccl_notification_event_time);
            notif_Date = itemView.findViewById(R.id.notif_date);
            notif_Day = itemView.findViewById(R.id.notif_day);
            notif_Time = itemView.findViewById(R.id.notif_time);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            setClickListener.onClick(getAdapterPosition(),view);
        }
    }


    public void setOnNotificationClick(RecyclerClickListener setClickListener){
        NotificationsRecyclerViewAdaptor.setClickListener = setClickListener;
    }

}
