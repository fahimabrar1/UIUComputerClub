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

public class Post_Fragment extends Fragment {

    TextView eventName;
    TextView eventDate;
    TextView eventVenue;
    TextView eventDes;
    TextView evenTime;
    String eventNameText;
    String eventDateText;
    String eventVenueText;
    String eventDesText;
    String evenTimeText;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getAllView(view);

        Bundle bundle = this.getArguments();

        if(bundle != null)
        {
            eventVenueText = bundle.getString("eventVenue");
            eventDesText = bundle.getString("eventDes");
            eventNameText = bundle.getString("eventName");
            eventDateText = bundle.getString("eventDate");
            evenTimeText = bundle.getString("evenTime");

        }

        eventVenue.setText(eventVenueText);
        eventDes.setText(eventDesText);
        eventName.setText(eventNameText);
        eventDate.setText(eventDateText);
        evenTime.setText(evenTimeText);
    }

    private void getAllView(View view) {
         eventName = view.findViewById(R.id.eventName);
         eventDate = view.findViewById(R.id.eventDate);
         eventVenue = view.findViewById(R.id.eventVenue);
         eventDes = view.findViewById(R.id.eventDes);
         evenTime = view.findViewById(R.id.evenTime);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post,container,false);


        return view;
    }

}
