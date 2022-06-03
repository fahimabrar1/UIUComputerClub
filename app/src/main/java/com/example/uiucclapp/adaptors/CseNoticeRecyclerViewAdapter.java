package com.example.uiucclapp.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uiucclapp.R;
import com.example.uiucclapp.RecyclerClickListener;
import com.example.uiucclapp.classes.CseNotice;
import com.example.uiucclapp.fragments.childfragments.Notice_Fragment;

import java.util.List;

public class CseNoticeRecyclerViewAdapter extends RecyclerView.Adapter<CseNoticeRecyclerViewAdapter.MyViewHolder> {

    private static RecyclerClickListener setClickListener;
    private List<CseNotice> cseNotices;
    private Context context;
    private Notice_Fragment _notice_fragment;

    public CseNoticeRecyclerViewAdapter(List<CseNotice> cseNotices, Notice_Fragment _notice_fragment) {
        this.cseNotices = cseNotices;
        this._notice_fragment = _notice_fragment;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.cse_notice_sample,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.notifDate.setText(cseNotices.get(position).getNotifDate());
        holder.notifTime.setText(cseNotices.get(position).getNotifTime());
        holder.notifDay.setText(cseNotices.get(position).getNotifDay());
        holder.heading.setText(cseNotices.get(position).getHeading());
    }

    @Override
    public int getItemCount() {
        return cseNotices.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView notifDate;
        private TextView notifTime;
        private TextView notifDay;
        private TextView heading;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            notifDate = itemView.findViewById(R.id.dpt_notif_date);
            notifTime = itemView.findViewById(R.id.dpt_notif_time);
            notifDay = itemView.findViewById(R.id.dpt_notif_day);
            heading = itemView.findViewById(R.id.dpt_notif_heading);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

            setClickListener.onClick(getAdapterPosition(),view);
        }
    }

    public void setOnNoticeClick(RecyclerClickListener setClickListener){
        CseNoticeRecyclerViewAdapter.setClickListener = setClickListener;
    }

}
