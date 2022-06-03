package com.example.movie_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.LongDef;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.movie_1.adapter.MovieAdapter;
import com.example.movie_1.databinding.FragmentMovieBinding;
import com.example.movie_1.interfaces.OnChangeToolbarType;
import com.example.movie_1.interfaces.OnMovieItemClicked;
import com.example.movie_1.models.Movie;
import com.example.movie_1.models.YtsData;
import com.example.movie_1.repository.MovieService;
import com.example.movie_1.utils.Define;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieFragment extends Fragment implements OnMovieItemClicked {

    // 안드로이드에서 만들어 준 클래스
    private FragmentMovieBinding binding;
    private static final String TAG = MovieFragment.class.getName();
    // 여기서 통신 요청을 할 예정
    private MovieService movieService;

    private MovieAdapter movieAdapter;
    private List<Movie> list = new ArrayList<>();

    private int currentPageNumber = 1;
    // 스크롤 시 중복 이벤트 발생 해결 방안
    private boolean preventDuplicateScrollEvent = true;
    private OnChangeToolbarType onChangeToolbarType;
    private static MovieFragment movieFragment;
    private boolean isFirstLoading = true;

    private MovieFragment(OnChangeToolbarType onChangeToolbarType) {
        this.onChangeToolbarType = onChangeToolbarType;
    }

    public static MovieFragment getInstance(OnChangeToolbarType onChangeToolbarType) {

        if (movieFragment == null) {
            movieFragment = new MovieFragment(onChangeToolbarType);
        }

        return movieFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieService = MovieService.retrofit.create(MovieService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // findViewByid 대체 (뷰 바인딩 활용)
//         inflater.inflate(R.layout.fragment_movie, container, false);
        binding = FragmentMovieBinding.inflate(inflater, container, false);
        // 리사이클러 뷰 만들어주기
        // 아직 없음  (입체적으로 생각)
        setupRecyclerView(list);
        if (isFirstLoading) {
            requestMoviesData(currentPageNumber);
        } else {
            setVisibilityProgressBar(View.GONE);
        }

        onChangeToolbarType.onSetupType(Define.PAGE_TITLE_MOVIE);
        // NULL POINTER EXCEPTION발생하므로 주소 연결(누가 내 메서드를 콜백 받을지 연결)
        // 연결방법 2가지 (1 생성자, 2 메서드)


        return binding.getRoot();
    }

    private void requestMoviesData(int requestPage) {

        int ITEM_LIMIT = 10;
        Log.d(TAG, "통신 요청");
        movieService.repoContributors("rating", ITEM_LIMIT, requestPage)
                .enqueue(new Callback<YtsData>() {
                    @Override
                    public void onResponse(Call<YtsData> call, Response<YtsData> response) {
                        if (response.isSuccessful()) {
                            // 통신을 통해서 데이터를 넘겨 받았으면 adapter에 데이터를 전달해서
                            // 화면을 갱신 처리
                            List<Movie> list = response.body().getData().getMovies();
                            // 어댑터에 메서드 호출
                            movieAdapter.addItem(list);

                            currentPageNumber++;
                            preventDuplicateScrollEvent = true;
                            isFirstLoading = false;
                            setVisibilityProgressBar(View.GONE);
                            // xml --> TEXT_VIEW = 네트워크가 불안정합니다. show

                        }
                    }

                    @Override
                    public void onFailure(Call<YtsData> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
    }


    // 통신해서 JSON 받은 다음에 매개변수로 데이터를 넘길 예정
    private void setupRecyclerView(List<Movie> movieList) {
        // 1. 어댑터
        movieAdapter = new MovieAdapter();
        movieAdapter.setOnMovieItemClicked(this);
        movieAdapter.initItemList(movieList);

        // 2. 매니저
        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        // 3. xml 파일에 선언한 recyclerView에 세팅
        binding.movieRecyclerView.setAdapter(movieAdapter);
        binding.movieRecyclerView.setLayoutManager(manager);
        binding.movieRecyclerView.hasFixedSize();

        // 이벤트 리스너
        binding.movieRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {

                if (preventDuplicateScrollEvent) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager) (binding.movieRecyclerView.getLayoutManager());
                    int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                    Log.d(TAG, "lastVisibleItemPosition :  " + lastVisibleItemPosition);

                    int itemTotalCount = binding.movieRecyclerView.getAdapter().getItemCount() - 1;

                    if (lastVisibleItemPosition == itemTotalCount) {
                        if (currentPageNumber != 1) {
                            preventDuplicateScrollEvent = false;
                            requestMoviesData(currentPageNumber);

                        }

                    }
                }

            }
        });
    }

    private void setVisibilityProgressBar(int visible) {
        binding.progressIndicator.setVisibility(visible);
    }


    @Override
    public void selectedItem(Movie movie) {
        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        // 직렬화란 --> object를 byte 단위로 변환해서 던진다.
        intent.putExtra(MovieDetailActivity.PARAM_NAME_1, movie);
        startActivity(intent);
    }
}