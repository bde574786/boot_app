package com.example.tablayout_page;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.tablayout_page.adapter.MyPageAdapter;
import com.google.android.material.tabs.TabLayout;


/*
 *  pager
 * - 화면 (종이 넘기듯이 화면을 넘겨주는 역할)
 * - Adapter
 *
 * TabLayout
 *
 * - tab 을 담당하는 역할
 *
 *  - 보통 같이 작성을 하지만 따로따로 만들어도 상관없다.
 *
 * 리스너
 * pager와 TabLayout을 연결해주기 위해 필요하다.
 *
 * */


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    public static final int TAB_COUNT = 3;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyPageAdapter myPagerAdapter;
    private String tabName[] = {"ONE", "TWO", "THREE"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();

        // 1탭에서 2번 탭 진행했을때 1번탭 사라질 때 뭔가 해야 할 일이 있다면
        // 새로운 탭이 선택 되었을 때 onTabSelected에서 코드를 작성하면 된다.
    }

    private void initData() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        for (String name : tabName) {
            tabLayout.addTab(tabLayout.newTab().setText(name));
        }

        myPagerAdapter = new MyPageAdapter(getSupportFragmentManager(), TAB_COUNT);

    }

    private void addEventListener() {

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition(); // 0, 1, 2
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
            }
        });

        viewPager.setAdapter(myPagerAdapter);

        // 뷰 페이지와 Tab 연동
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

}
