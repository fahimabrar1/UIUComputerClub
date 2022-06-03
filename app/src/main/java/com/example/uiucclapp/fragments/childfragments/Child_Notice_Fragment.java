package com.example.uiucclapp.fragments.childfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.uiucclapp.R;

public class Child_Notice_Fragment extends Fragment {

    private TextView NoticeDescription;
    private TextView NoticeHeading;
    String heading,des;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();

        if(bundle != null)
        {
            heading = bundle.getString("heading");
            des = bundle.getString("des");
        }

        NoticeHeading = (TextView)view.findViewById(R.id.notice_display_headline);
        NoticeDescription = (TextView)view.findViewById(R.id.notice_display_detials);
        NoticeHeading.setText(heading);
        NoticeDescription.setText(des);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notice_viewer_layout,container,false);
        return view;
    }


}
