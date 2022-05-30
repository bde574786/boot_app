package com.example.myhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.myhttp.models.Todo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);

        button.setOnClickListener(view -> {
            new Thread(() -> {
                httpGetTest();
            }).start();
        });


//        try {
//            httpGetTest();
//        } catch (NetworkOnMainThreadException e) {
//            Toast.makeText(this, "에러 발생", Toast.LENGTH_SHORT).show();
//        }
    }

    private void httpGetTest() {
        // https://jsonplaceholder.typicode.com/todos/1
        String urlString = "https://jsonplaceholder.typicode.com/todos";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // 참고
            // connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // 통신 성공
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(),
                        "UTF-8"));

                // 1. 한 라인(한 줄)
//                        reader.readLine();

//                String line = null;
//                StringBuffer sb = new StringBuffer();
//
//                while ((line = reader.readLine()) != null) {
//                    sb.append(line + "\n");
//                }
//
//                Log.d("TAG", sb.toString());

                // Dto 만들어야 해

                // 문자열 --> 하나의 OBJECT로 변환하는 방법
//                Todo todo1 = new Gson().fromJson(reader, Todo.class);
//                Log.d("TAG", todo1.title);


                // 문자열 --> 배열 타입으로 변환 하는 방법
//                Todo[] todos = new Gson().fromJson(reader, Todo[].class);
//                Log.d("TAG", todos.toString());


                // ArrayList 타입으로 변환하는 방법
                // 1.
                Type todoListType = new TypeToken<ArrayList<Todo>>() {
                }.getType();
                // 2.
                ArrayList<Todo> todoList = new Gson().fromJson(reader, todoListType);

                for (Todo t : todoList) {
                    Log.d("TAG", t.userId + " : userId");
                    Log.d("TAG", t.title + " : title");
                }

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}