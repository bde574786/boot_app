package com.example.movie_1.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.movie_1.R;
import com.example.movie_1.interfaces.OnMovieItemClicked;
import com.example.movie_1.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> list = new ArrayList<>();
    private OnMovieItemClicked onMovieItemClicked;

    public void setOnMovieItemClicked(OnMovieItemClicked onMovieItemClicked) {
        this.onMovieItemClicked = onMovieItemClicked;
    }

    // 통신 배우기 전 생성자에서 데이터를 전달 받아서 화면을 구성
    // 통신이기 때문에 화면을 그리는 시점보다 더 늦게 데이터가 도달할 수 있다.

    public void initItemList(List<Movie> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addItem(List<Movie> addList) {
        this.list.addAll(list.size(), addList);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_movie_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = list.get(position);
        holder.setItem(movie);
        holder.itemView.setOnClickListener(view -> {
            onMovieItemClicked.selectedItem(movie);

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // inner static class
    // 뷰 결합 X  (직접 해야 함) -> 단방향
    // (data binding 뷰 결합) -> 양방향
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // itemView에 선언한 데이터 타입들을 선언하고 생성 시점에 R.id.xxx 연결 해 주면 된다.
        private View itemView;
        private ImageView posterIv;
        private TextView titleTv;
        private TextView ratingTv;
        private RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            posterIv = itemView.findViewById(R.id.posterIv);
            titleTv = itemView.findViewById(R.id.titleTv);
            ratingTv = itemView.findViewById(R.id.ratingTv);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }


        public void setItem(Movie movie) {
            titleTv.setText(movie.getTitle());
            ratingTv.setText(String.valueOf(movie.getRating()));
            ratingBar.setRating((float) movie.getRating());

            Glide.with(posterIv.getContext())
                    .load(movie.getMediumCoverImage())
                    .placeholder(R.drawable.round_image)
                    .transform(new FitCenter(), new RoundedCorners(20))
                    .into(posterIv);

        }

    } // end of inner class

}
