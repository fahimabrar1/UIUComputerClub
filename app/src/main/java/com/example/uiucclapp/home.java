package com.example.uiucclapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.uiucclapp.fragments.childfragments.Child_Notice_Fragment;
import com.example.uiucclapp.fragments.childfragments.Post_Fragment;
import com.example.uiucclapp.fragments.home_fragment;
import com.example.uiucclapp.fragments.notifications_fragment;
import com.example.uiucclapp.fragments.settings_fragment;
import com.example.uiucclapp.fragments.userprofile_fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class home extends AppCompatActivity{

    BottomNavigationView bottomNavigationView;
    NavController navController;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FindViewIDs();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new settings_fragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new userprofile_fragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new notifications_fragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new home_fragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home_fragment:
                        fragment = new home_fragment();

                        break;
                    case R.id.notifications_fragment:

                        fragment = new notifications_fragment();
                        break;
                    case R.id.userprofile_fragment:

                        fragment = new userprofile_fragment();
                        break;

                    case R.id.settings_fragment:

                        fragment = new settings_fragment();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commit();
                return true;
            }
        });
    }


    private void FindViewIDs() {

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

}