package com.example.bottomnavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.bottomnavi.utils.FragmentType;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        addBottomNavigationListener();
        replaceFragment(FragmentType.HOME);

    }

    private void replaceFragment(FragmentType type) {
        Fragment fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(type == FragmentType.HOME) {
            fragment = new FragmentHome();
        } else if(type == FragmentType.TV){
            fragment = new FragmentTv();
        } else{
            fragment = new FragmentCalendar();
        }

        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();

    }


    private void addBottomNavigationListener(){
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_home:
                    Log.d("TAG", "home");
                    replaceFragment(FragmentType.HOME);
                    break;
                case R.id.page_tv:
                    Log.d("TAG", "tv");
                    replaceFragment(FragmentType.TV);
                    break;
                case R.id.page_calendar:
                    Log.d("TAG", "calendar");
                    replaceFragment(FragmentType.CAL);
                    break;
            }
            return true;
        });

    }




}