package com.example.uiucclapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.uiucclapp.R;
import com.example.uiucclapp.fragments.childfragments.Notice_Fragment;
import com.example.uiucclapp.fragments.childfragments.Notification_fragment;
import com.google.android.material.tabs.TabLayout;


public class notifications_fragment extends Fragment {

    TabLayout tabLayout;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition())
                {
                    case 0:
                        fragment = new Notification_fragment();
                        break;
                    case 1:
                        fragment = new Notice_Fragment();
                        break;
                }

                getChildFragmentManager().beginTransaction().replace(R.id.displayNotificationsAndNotice,fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifications_fragment, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);


        return view;

    }
}