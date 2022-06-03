package com.example.uiucclapp.fragments.childfragments;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uiucclapp.Database.SqlDb;
import com.example.uiucclapp.R;
import com.example.uiucclapp.RecyclerClickListener;
import com.example.uiucclapp.adaptors.CseNoticeRecyclerViewAdapter;
import com.example.uiucclapp.classes.CseNotice;

import java.util.ArrayList;

public class Notice_Fragment extends Fragment {

    private RecyclerView recyclerView;
    private CseNoticeRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<CseNotice> cseNotices,dummy;
    SqlDb db;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new SqlDb(view.getContext());
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        cseNotices = new ArrayList<CseNotice>();

        loadData(view);
    }




    void loadData(View view){
        SQLiteDatabase myDB;
        try {
            myDB = db.openDB();

        }catch(SQLException sqle){

            throw sqle;
        }
        Cursor c = myDB.rawQuery("SELECT * FROM dpt_notifications",null);


        c.moveToFirst();

        while(! c.isAfterLast())
        {

            String notifDate = c.getString(1);
            String notifTime = c.getString(2);
            String notifDay = c.getString(3);
            String heading=c.getString(4);
            String des=c.getString(5);



            cseNotices.add(new CseNotice(notifDate,notifTime,notifDay,heading,des));

            c.moveToNext();
        }

        // specify an adapter (see also next example)
        adapter = new CseNoticeRecyclerViewAdapter(cseNotices, this);
        recyclerView.setAdapter(adapter);

        adapter.setOnNoticeClick(new RecyclerClickListener() {
            @Override
            public void onClick(int position, View view) {
//                Toast.makeText( Notice_Fragment.this.getContext(), "Notice Position : "+position +" " ,Toast.LENGTH_SHORT ).show();


                Bundle arguments = new Bundle();
                arguments.putString("heading", cseNotices.get(position).getHeading());
                arguments.putString("des", cseNotices.get(position).getDes());

                Child_Notice_Fragment cnf = new Child_Notice_Fragment();
                cnf.setArguments(arguments);
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment,cnf).commit();

            }
        });
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.notice_layout,container,false);
        recyclerView = view.findViewById(R.id.notice_recyclerview);


        return view;


    }




}
