package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends AppCompatActivity {

    private static final String TAG = "Activity1";
    public static final String KEY_NAME = "key_name";

    private EditText nameEditText;
    private Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        initData();
        addEventListener();
    }

    private void initData(){
        nameEditText = findViewById(R.id.nameEditTextView);
        okBtn = findViewById(R.id.okBtn);
    }

    private void addEventListener(){
        okBtn.setOnClickListener(view -> {
            // 1. 현재 nameEditText 뷰 컴포넌트의 값을 가져온다. (방어적 코드)
            // 2. 화면 전환 로직 (intent)
            // 내가 누군지 알리는 this -> 뒤로 갈때도 알아야함
            // Context가 모든 정보를 담고 있음
            String name = nameEditText.getText().toString();
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra(KEY_NAME, name);
            startActivity(intent);

        });
    }

}