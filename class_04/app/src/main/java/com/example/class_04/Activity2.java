package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        // 값을 받는 방법 (부모 클래스에 존재하는 메서드 getIntent)
        // 값이 없다면 기본 값을 0으로 세팅
        // 만약 보내주는 값이 없다면 defaultVlaue 때문에 자동으로 numberTemp = 0이 되고 myStringTemp 는 null이 된다.
        // String(null), String은 dafaultValue 가 없다 -> null로 자동으로 처리
        // 방어적 코드
//        if(getIntent() != null){
//            int numberTemp = getIntent().getIntExtra("number", 0);
//            String myStringTemp = getIntent().getStringExtra("myString");
//            Log.d("TAG", "numberTemp :  " + numberTemp);
//            Log.d("TAG", "myStringTemp : " + myStringTemp);
//        }

        TextView textView = findViewById(R.id.nameTextView);


        if (getIntent() != null) {
            String getData = getIntent().getStringExtra(Activity1.KEY_NAME);
            textView.setText(getData);
        }


    }
}