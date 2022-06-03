package com.example.uiucclapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.uiucclapp.RecyclerClickListener;
import com.example.uiucclapp.R;
import com.example.uiucclapp.adaptors.RecyclerViewAdaptor;
import com.example.uiucclapp.classes.Post;
import com.example.uiucclapp.fragments.childfragments.Post_Fragment;

import java.util.ArrayList;
import java.util.List;


public class home_fragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdaptor adapter;
    List<Post> data,dummy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);


        recyclerView = view.findViewById(R.id.recyclerview);
        data = new ArrayList<Post>();
        dummy = new ArrayList<Post>();

        data.add(new Post("UIU CODERS COMBAT","UIU AUDITORIUM","20/12/20"));
        data.add(new Post("UIU CODERS COMBAT","UIU AUDITORIUM","20/12/20"));
        data.add(new Post("UIU CODERS COMBAT","UIU AUDITORIUM","20/12/20"));
        data.add(new Post("UIU CODERS COMBAT","UIU AUDITORIUM","20/12/20"));
        data.add(new Post("UIU CODERS COMBAT","UIU AUDITORIUM","20/12/20"));
        data.add(new Post("UIU CODERS COMBAT","UIU AUDITORIUM","20/12/20"));
        // recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new RecyclerViewAdaptor(this,data);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new RecyclerClickListener() {
            @Override
            public void onClick(int position, View view) {
                        Fragment fragment = new Post_Fragment();
                        adapter = new RecyclerViewAdaptor(home_fragment.this, dummy);
                        recyclerView.setAdapter(adapter);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commit();
                        Toast.makeText( getContext(), "Position : "+position +" " ,Toast.LENGTH_SHORT ).show();

                    }

            }
        );


        return view;

    }
}