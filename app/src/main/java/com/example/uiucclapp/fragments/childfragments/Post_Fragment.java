package com.example.uiucclapp.fragments.childfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.uiucclapp.R;
import com.example.uiucclapp.classes.Post;
import com.example.uiucclapp.fragments.home_fragment;
import com.example.uiucclapp.fragments.notifications_fragment;
import com.example.uiucclapp.fragments.settings_fragment;
import com.example.uiucclapp.fragments.userprofile_fragment;
import com.example.uiucclapp.home;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Post_Fragment extends Fragment {

    BottomNavigationView bottomNavigationView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post,container,false);


        return view;
    }

}
