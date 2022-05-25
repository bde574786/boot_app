package com.example.myglide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageView1 = findViewById(R.id.gImageView1);
        ImageView imageView2 = findViewById(R.id.gImageView2);
        ImageView imageView3 = findViewById(R.id.gImageView3);
        ImageView imageView4 = findViewById(R.id.gImageView4);
        ImageView imageView5 = findViewById(R.id.gImageView5);
        ImageView imageView6 = findViewById(R.id.gImageView6);

        Glide.with(this).load("https://picsum.photos/200/300?grayscale").circleCrop().into(imageView1);
        Glide.with(this).load("https://picsum.photos/200/300/?blur").circleCrop().into(imageView2);
        Glide.with(this).load("https://picsum.photos/id/237/200/300").circleCrop().into(imageView3);
        Glide.with(this).load("https://picsum.photos/seed/picsum/200/300").circleCrop().into(imageView4);
        Glide.with(this).load("https://picsum.photos/200/300/?blur=2").circleCrop().into(imageView5);
        Glide.with(this).load("https://picsum.photos/200/300.webp").circleCrop().into(imageView6);


    }
}