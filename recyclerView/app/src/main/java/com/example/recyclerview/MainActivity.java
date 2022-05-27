package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.FoodAdapter;
import com.example.recyclerview.interfaces.OnFoodItemClickListener;
import com.example.recyclerview.models.Food;

import java.util.ArrayList;


/*
*  RecyclerView
*
*  -- 장점
*  -- ListView 개선판
*  -- ViewHolder 포함 (findviewById)
*  -- 유연하다
*  -- LayoutManager, Adapter 클래스
*
* */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FoodAdapter foodAdapter = new FoodAdapter(Food.getSampleData(), this, new OnFoodItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                // 여기가 호출되어 진다
                Log.d("TAG", "넘겨 받은 positon : " + position);
                Intent intent = new Intent(getApplication(), DetailActivity.class);
                intent.putExtra("obj", Food.getSampleData().get(position));
                startActivity(intent);
            }
        });



        // 통신 JSON
        ArrayList<Food> listSample = Food.getSampleData();
        // 리싸이클러뷰를 사용하기 위해서
        // 1. Adapter 클래스를 직접 생성해야 한다.
        // 2. LayoutManager 생성해서 Adapter 클래스와 연결해야 한다.

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setAdapter(new FoodAdapter(Food.getSampleData(), this));
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.hasFixedSize(); // 성능개선
    }
}