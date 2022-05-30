package com.example.myretroifit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myretroifit.repository.models.RetrofitService;
import com.example.myretroifit.repository.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// 모델 분리
// 비즈니스 로직을 처리하는 부분을 분리
public class MainActivity extends AppCompatActivity {

    TextView textView;
    Retrofit retrofit;
    RetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.temp);

        // 객체 초기화
        // baseUrl 사용 시 반드시 마지막에 / 를 해주어야 한다.
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 초기화 된 레트로핏 object와 비즈니스 로직인 인터페이스를 연결
        service = retrofit.create(RetrofitService.class);

        service.getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                Log.d("TAG", response.isSuccessful() + " <------ ");
                Log.d("TAG", response.message() + " <------ ");
                if(response.isSuccessful()) {

                    // Gson(타입 변환 코드) XX
                    Todo todo = response.body().get(0);
                    Log.d("TAG", "userId : " + todo.userId);

                    textView.setText(todo.completed + "");

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
                Log.d("TAG", "실패 : " + t.getMessage());
            }
        });


    }
}