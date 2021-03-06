package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.viewpager2.adapter.ImageSliderAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 sliderImageviewPager;
    private ArrayList<String> images = new ArrayList<>();
    private LinearLayout layoutIndicatorsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images.add("https://cdn.pixabay.com/photo/2021/08/25/18/43/flower-6574241__480.jpg");
        images.add("https://cdn.pixabay.com/photo/2020/10/18/20/43/dinosaur-5666127__340.png");
        images.add("https://cdn.pixabay.com/photo/2022/04/25/05/43/blackbird-7155106__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2022/05/21/16/00/butterfly-7211806__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2022/05/21/11/46/frog-7211336__340.png");


        layoutIndicatorsContainer = findViewById(R.id.layoutIndicators);


        sliderImageviewPager = findViewById(R.id.sliderViewPager2);
        // view -> default (1)
        sliderImageviewPager.setOffscreenPageLimit(2);
        sliderImageviewPager.setAdapter(new ImageSliderAdapter(this, images));
        sliderImageviewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });

        setupIndicators(images.size());

    } // end of onCreate

    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        // LayoutParams
        // 뷰가 어떻게 배치 될 지 정의하는 속성
        // xml 파일에서 layout_ 붙는 속성들을 말한다.
        // LayoutParams 객체를 통해서 다룰 수 있다.

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);

            layoutIndicatorsContainer.addView(indicators[i]);
        }


    } // end of setupIndicators

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicatorsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicatorsContainer.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_inactive));
            }
        }
    }


}