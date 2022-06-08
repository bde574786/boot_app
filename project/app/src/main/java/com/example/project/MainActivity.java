package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import com.example.project.adapter.Adapter;
import com.example.project.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

//    private ActivityMainBinding binding;

    public static final int TAB_COUNT = 4;
    private static final String TAB_NAME[] = {"전체 메뉴 보기", "카테고리 별 보기", "가까운 가게 보기", "정보 수정"};
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        addTab();
        addEventListener();
        chain();
    }

    // 초기화
    private void init() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout  = findViewById(R.id.tabLayout);
    }

    // 탭 추가
    private void addTab() {
        for (String name : TAB_NAME) {
            tabLayout.addTab(tabLayout.newTab().setText(name));
        }
        adapter = new Adapter(getSupportFragmentManager(), TAB_COUNT);
    }

    // 이벤트 리스너
    private void addEventListener() {

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    // 뷰 페이저, 탭 레이아웃 연동
    private void chain() {
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

}