package com.example.uiucclapp.fragments;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uiucclapp.Database.SqlDb;
import com.example.uiucclapp.R;
import com.example.uiucclapp.RecyclerClickListener;
import com.example.uiucclapp.adaptors.CseNoticeRecyclerViewAdapter;
import com.example.uiucclapp.classes.CseNotice;
import com.example.uiucclapp.fragments.childfragments.Child_Notice_Fragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class userprofile_fragment extends Fragment {

    private FirebaseAuth mAuth;
    private FirebaseUser user;
    String UserEmail;
    SqlDb db;

    ImageView image;
    TextView name;
    TextView ID;
    TextView Location;
    TextView email;
    TextView des;
    TextView member;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getallView(view);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        UserEmail = user.getEmail();
        Log.d("mmm",UserEmail);
        db = new SqlDb(view.getContext());
        loadData(view);
    }

    private void getallView(View view) {
        image = view.findViewById(R.id.user_image);
        name = view.findViewById(R.id.user_name);
        ID=view.findViewById(R.id.user_ID);
        Location=view.findViewById(R.id.user_Location);
        email=view.findViewById(R.id.user_email);
        des=view.findViewById(R.id.user_des);
        member=view.findViewById(R.id.user_member);

    }


    void loadData(View view){
        SQLiteDatabase myDB;
        try {
            myDB = db.openDB();

        }catch(SQLException sqle){

            throw sqle;
        }
        Cursor c = myDB.rawQuery("select * from user where email = \'"+UserEmail+"\'" , null);

        c.moveToFirst();


        byte[] blob = c.getBlob(1);
        String nameT = c.getString(2);
        String IDT = c.getString(3);
        String LocationT = c.getString(4);
        String emailT=c.getString(5);
        String membersicneT=c.getString(6);
        String desT=c.getString(7);
        Bitmap bm = BitmapFactory.decodeByteArray(blob, 0 ,blob.length);

        image.setImageBitmap(bm);
        name.setText(nameT);
        ID.setText(IDT);
        Location.setText(LocationT);
        email.setText(emailT);
        member.setText(membersicneT);
        des.setText(desT);





    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_userprofile_fragment, container, false);
    }
}