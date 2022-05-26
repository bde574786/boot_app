package com.example.recyclerviewex.models;

import java.util.ArrayList;

public class Movie {

    private String thumbnail;
    private String title;
    private String releasedDate;
    private String rating;


    public Movie(String thumbnail, String title, String releasedDate, String rating) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.releasedDate = releasedDate;
        this.rating = rating;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    public static ArrayList<Movie> getSampleData(){
        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie("https://movie-phinf.pstatic.net/20220516_144/1652665409592Chvey_JPEG/movie_image.jpg?type=m203_290_2", "범죄도시2", "개봉일 : 2022.05.18", "평점 : 9.06"));
        movies.add(new Movie("https://movie-phinf.pstatic.net/20220504_33/165164173504831gKe_JPEG/movie_image.jpg?type=m203_290_2", "닥터 스트레인지: 대혼돈의 멀티버스 ", "개봉일 : 2022.05.04", "평점 : 7.06"));
        movies.add(new Movie("https://movie-phinf.pstatic.net/20220510_209/1652173423913czGcU_JPEG/movie_image.jpg?type=m203_290_2", "그대가 조국", "개봉일 : 2022.05.25", "평점 : 9.92"));
        movies.add(new Movie("https://movie-phinf.pstatic.net/20220506_169/16518204621480DxEQ_JPEG/movie_image.jpg?type=m203_290_2", "안녕하세요", "개봉일 : 2022.05.25", "평점 : 9.25"));
        movies.add(new Movie("https://movie-phinf.pstatic.net/20220509_134/16520885165360Jv1q_JPEG/movie_image.jpg", "파리의 몬스터", "2022.05.26", "평점 : 10.0"));
        movies.add(new Movie("https://movie-phinf.pstatic.net/20220516_144/1652665409592Chvey_JPEG/movie_image.jpg?type=m203_290_2", "범죄도시2", "개봉일 : 2022.05.18", "평점 : 9.06"));
        movies.add(new Movie("https://movie-phinf.pstatic.net/20220426_287/1650950769337jn9SY_JPEG/movie_image.jpg?type=m203_290_2", "오마주 ", "개봉일 : 2022.05.26", "평점 : 0.0"));
        movies.add(new Movie("https://movie-phinf.pstatic.net/20220405_291/1649125342962iXOg2_JPEG/movie_image.jpg?type=m203_290_2", "배드 가이즈", "개봉일 : 2022.05.04", "평점 : 8.68"));
        movies.add(new Movie("https://movie-phinf.pstatic.net/20220509_134/16520885165360Jv1q_JPEG/movie_image.jpg?type=m203_290_2", "몬스터 싱어: 매직 인 파리", "개봉일 : 2022.05.26", "평점 : 9.11"));
        movies.add(new Movie("https://movie-phinf.pstatic.net/20220513_102/1652406334336LQPmU_JPEG/movie_image.jpg?type=m203_290_2", "피는 물보다 진하다", "2022.05.25", "평점 : 8.45"));


        return movies;
    }


}



