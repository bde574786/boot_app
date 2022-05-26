package com.example.addviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Movie> sample = Movie.getMovieInfo();

        LinearLayout container  = findViewById(R.id.container);
        LayoutInflater inflater = LayoutInflater.from(this);


        sample.forEach(movie -> {

            View itemView = inflater.inflate(R.layout.movie,container, false);

            ImageView movieImage = itemView.findViewById(R.id.movieImage);

            TextView movieName = itemView.findViewById(R.id.movieName);
            TextView movieReleasedDate = itemView.findViewById(R.id.movieReleasedDate);
            TextView movieRating = itemView.findViewById(R.id.movieRating);

            movieName.setText(movie.name);
            movieReleasedDate.setText(movie.releasedDate);
            movieRating.setText(movie.rating);

            Glide.with(this)
                    .load(movie.url)
                    .centerCrop()
                    .into(movieImage);

            container.addView(itemView);


        });




    }
}