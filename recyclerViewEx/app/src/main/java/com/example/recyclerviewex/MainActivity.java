package com.example.recyclerviewex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerviewex.adapter.MovieAdapter;
import com.example.recyclerviewex.models.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Movie> movies = Movie.getSampleData();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new MovieAdapter(Movie.getSampleData(),this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}