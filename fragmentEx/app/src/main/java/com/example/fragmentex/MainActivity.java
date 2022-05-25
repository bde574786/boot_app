package com.example.fragmentex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    LinearLayout linearLayout3;
    LinearLayout linearLayout4;
    LinearLayout linearLayout5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout1 = findViewById(R.id.linearLayout1);
        LinearLayout linearLayout2 = findViewById(R.id.linearLayout2);
        LinearLayout linearLayout3 = findViewById(R.id.linearLayout3);
        LinearLayout linearLayout4 = findViewById(R.id.linearLayout4);
        LinearLayout linearLayout6 = findViewById(R.id.linearLayout5);




        linearLayout1.setOnClickListener(view -> {
            Log.d("TAG", "홈");
        });

        linearLayout2.setOnClickListener(view -> {
            Log.d("TAG", "동네생활");
        });

        linearLayout3.setOnClickListener(view -> {
            Log.d("TAG", "내 근처");
        });

        linearLayout4.setOnClickListener(view -> {
            Log.d("TAG", "채팅");
        });

        linearLayout5.setOnClickListener(view -> {
            Log.d("TAG", "나의 정보");
        });


    }
}