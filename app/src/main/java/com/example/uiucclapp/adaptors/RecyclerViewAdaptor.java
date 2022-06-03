package com.example.uiucclapp.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uiucclapp.RecyclerClickListener;
import com.example.uiucclapp.R;
import com.example.uiucclapp.classes.Notifications;
import com.example.uiucclapp.classes.Post;
import com.example.uiucclapp.fragments.home_fragment;
import com.example.uiucclapp.home;

import java.util.List;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.MyViewHolder> {

    private static RecyclerClickListener onClickRecyclerClickListener;
    private Context context;
    private List<Post> data;
    private List<Notifications> notifications;
    private home_fragment home_fragment;

    public RecyclerViewAdaptor(Context context, List<Post> data){
        this.context = context;
        this.data = data;
    }

    public RecyclerViewAdaptor(home_fragment home_fragment, List<Post> data){
        this.home_fragment = home_fragment;
        this.data = data;
    }



    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.home_post_frame_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.venue.setText(data.get(position).getVenue());
        holder.date.setText(data.get(position).getDate());

        //holder.image.setImageResource(data.get(position).getImage());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
       // public ImageView image;
        public TextView title;
        public TextView venue;
        public TextView date;
        public View view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            //image = itemView.findViewById(R.id.post_image);
            title = itemView.findViewById(R.id.post_title);
            venue = itemView.findViewById(R.id.post_venue);
            date = itemView.findViewById(R.id.post_date);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickRecyclerClickListener.onClick(getAdapterPosition(),view);
        }
    }

   /* public interface onClickListener
    {
        void onClick(int position, View view);
    }*/

    public void setOnItemClickListener(RecyclerClickListener onClickRecyclerClickListener)
    {
        RecyclerViewAdaptor.onClickRecyclerClickListener = onClickRecyclerClickListener;
    }
}
