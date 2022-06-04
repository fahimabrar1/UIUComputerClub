package com.example.uiucclapp.fragments;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.uiucclapp.Database.SqlDb;
import com.example.uiucclapp.RecyclerClickListener;
import com.example.uiucclapp.R;
import com.example.uiucclapp.adaptors.CseNoticeRecyclerViewAdapter;
import com.example.uiucclapp.adaptors.RecyclerViewAdaptor;
import com.example.uiucclapp.classes.CseNotice;
import com.example.uiucclapp.classes.Post;
import com.example.uiucclapp.fragments.childfragments.Child_Notice_Fragment;
import com.example.uiucclapp.fragments.childfragments.Post_Fragment;

import java.util.ArrayList;
import java.util.List;


public class home_fragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdaptor adapter;
    List<Post> data;
    SqlDb db;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview);

        db = new SqlDb(view.getContext());
        data = new ArrayList<Post>();
        loadData(view);

//
//        dummy = new ArrayList<Post>();
//
//        data.add(new Post("UIU CODERS COMBAT","UIU AUDITORIUM","20/12/20"));
//        data.add(new Post("UIU CODERS COMBAT","UIU AUDITORIUM","20/12/20"));
//        data.add(new Post("UIU CODERS COMBAT","UIU AUDITORIUM","20/12/20"));
//        data.add(new Post("UIU CODERS COMBAT","UIU AUDITORIUM","20/12/20"));
//        data.add(new Post("UIU CODERS COMBAT","UIU AUDITORIUM","20/12/20"));
//        data.add(new Post("UIU CODERS COMBAT","UIU AUDITORIUM","20/12/20"));
//        // recyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        layoutManager = new LinearLayoutManager(view.getContext());
//        recyclerView.setLayoutManager(layoutManager);
//
//        // specify an adapter (see also next example)
//        adapter = new RecyclerViewAdaptor(this,data);
//        recyclerView.setAdapter(adapter);
//
//        adapter.setOnItemClickListener(new RecyclerClickListener() {
//            @Override
//            public void onClick(int position, View view) {
//                Fragment fragment = new Post_Fragment();
//                adapter = new RecyclerViewAdaptor(home_fragment.this, dummy);
//                recyclerView.setAdapter(adapter);
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commit();
//                Toast.makeText( getContext(), "Position : "+position +" " ,Toast.LENGTH_SHORT ).show();
//            }
//        });

    }


    void loadData(View view){
        SQLiteDatabase myDB;
        try {
            myDB = db.openDB();

        }catch(SQLException sqle){

            throw sqle;
        }
        Cursor c = myDB.rawQuery("SELECT * FROM event",null);


        c.moveToFirst();

        while(! c.isAfterLast())
        {

            String eventName = c.getString(1);
            String eventDate = c.getString(2);
            String eventVenue=c.getString(4);
            String eventDes=c.getString(5);
            String evenTime = c.getString(6) +" - "+c.getString(7);



            data.add(new Post(eventName,eventDate,eventVenue,eventDes,evenTime));

            c.moveToNext();
        }

        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdaptor(this,data);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerClickListener() {
            @Override
            public void onClick(int position, View view) {

//                Toast.makeText( Notice_Fragment.this.getContext(), "Notice Position : "+position +" " ,Toast.LENGTH_SHORT ).show();


                Bundle arguments = new Bundle();
                arguments.putString("eventName", data.get(position).getEventName());
                arguments.putString("eventDate", data.get(position).getEventDate());
                arguments.putString("eventVenue", data.get(position).getEventVenue());
                arguments.putString("eventDes", data.get(position).getEventDes());
                arguments.putString("evenTime", data.get(position).getEvenTime());

                Post_Fragment Post_Fragment = new Post_Fragment();
                Post_Fragment.setArguments(arguments);
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment,Post_Fragment).commit();

            }
        });

//        adapter.setOnNoticeClick(new RecyclerClickListener() {
//            @Override
//            public void onClick(int position, View view) {
////                Toast.makeText( Notice_Fragment.this.getContext(), "Notice Position : "+position +" " ,Toast.LENGTH_SHORT ).show();
//
//
//                Bundle arguments = new Bundle();
//                arguments.putString("heading", data.get(position).getEventName());
//                arguments.putString("des", data.get(position).getEventDes());
//
//                Child_Notice_Fragment cnf = new Child_Notice_Fragment();
//                cnf.setArguments(arguments);
//                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment,cnf).commit();
//
//            }
//        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);




        return view;

    }
}