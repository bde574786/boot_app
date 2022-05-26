package com.example.recyclerviewex.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.recyclerviewex.R;
import com.example.recyclerviewex.models.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{

    ArrayList<Movie> list;
    Context context;

    public MovieAdapter(ArrayList<Movie> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.movie, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d("TAG", "position: " + position);
        Movie movie = list.get(position);

        Glide.with(context)
                .load(movie.getThumbnail())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.thumbnail);

        holder.title.setText(movie.getTitle());
        holder.releasedDate.setText(movie.getReleasedDate());
        holder.rating.setText(movie.getRating());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView thumbnail;
        TextView title;
        TextView releasedDate;
        TextView rating;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.thumbnailImageView);
            title = itemView.findViewById(R.id.title);
            releasedDate = itemView.findViewById(R.id.releasedDate);
            rating = itemView.findViewById(R.id.rating);


            itemView.setOnClickListener(view -> {




            });

        }





    }




}
