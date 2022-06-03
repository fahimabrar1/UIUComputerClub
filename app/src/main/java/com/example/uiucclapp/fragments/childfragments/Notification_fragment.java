package com.example.uiucclapp.fragments.childfragments;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uiucclapp.Database.SqlDb;
import com.example.uiucclapp.R;
import com.example.uiucclapp.RecyclerClickListener;
import com.example.uiucclapp.adaptors.NotificationsRecyclerViewAdaptor;
import com.example.uiucclapp.classes.Notifications;

import java.util.ArrayList;


public class Notification_fragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private NotificationsRecyclerViewAdaptor adapter;
    SqlDb db;
    ArrayList<Notifications> notifications;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new SqlDb(view.getContext());
        notifications = new ArrayList<Notifications>();

        loadData(view);

    }


    void loadData(View view){
        SQLiteDatabase myDB;
        try {
            myDB = db.openDB();

        }catch(SQLException sqle){

            throw sqle;
        }
        Cursor c = myDB.rawQuery("SELECT * FROM notifications",null);


        c.moveToFirst();

        while(! c.isAfterLast())
        {

            String notifDate = c.getString(1);
            String notifTime = c.getString(2);
            String notifDay = c.getString(3);
            String eventName=c.getString(4);
            String evenVenue = c.getString(5);
            String evenDate = c.getString(1);
            String evenTime = c.getString(6) +" - "+c.getString(7);


            notifications.add(new Notifications(eventName,evenVenue,evenDate,evenTime,notifTime,notifDay,notifDate));

            c.moveToNext();
        }

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL, true);

        recyclerView.setLayoutManager(layoutManager);
        // specify an adapter (see also next example)
        adapter = new NotificationsRecyclerViewAdaptor(notifications, this);
        recyclerView.setAdapter(adapter);

        adapter.setOnNotificationClick(new RecyclerClickListener() {
            @Override
            public void onClick(int position, View view) {
                Toast.makeText( getContext(), "Notification Position : "+position +" " ,Toast.LENGTH_SHORT ).show();

            }
        });
    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.notification_layout,container,false);
        recyclerView = view.findViewById(R.id.notification_recyclerview);

        return view;
    }
}
