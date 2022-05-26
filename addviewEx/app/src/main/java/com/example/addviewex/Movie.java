package com.example.addviewex;

import android.util.Log;

import java.util.ArrayList;

public class Movie {

    String url;
    String name;
    String releasedDate;
    String rating;


    public Movie(String url, String name, String releasedDate, String rating) {
        this.url = url;
        this.name = name;
        this.releasedDate = releasedDate;
        this.rating = rating;
    }

    public static ArrayList<Movie> getMovieInfo(){
        ArrayList<Movie> list = new ArrayList<>();

        list.add(new Movie("https://movie-phinf.pstatic.net/20220516_144/1652665409592Chvey_JPEG/movie_image.jpg?type=m203_290_2", "범죄도시2", "개봉일 : 2022.05.18", "평점 : 9.06"));
        list.add(new Movie("https://movie-phinf.pstatic.net/20220504_33/165164173504831gKe_JPEG/movie_image.jpg?type=m203_290_2", "닥터 스트레인지: 대혼돈의 멀티버스 ", "개봉일 : 2022.05.04", "평점 : 7.06"));
        list.add(new Movie("https://movie-phinf.pstatic.net/20220510_209/1652173423913czGcU_JPEG/movie_image.jpg?type=m203_290_2", "그대가 조국", "개봉일 : 2022.05.25", "평점 : 9.92"));
        list.add(new Movie("https://movie-phinf.pstatic.net/20220506_169/16518204621480DxEQ_JPEG/movie_image.jpg?type=m203_290_2", "안녕하세요", "개봉일 : 2022.05.25", "평점 : 9.25"));
        list.add(new Movie("https://movie-phinf.pstatic.net/20220509_134/16520885165360Jv1q_JPEG/movie_image.jpg", "파리의 몬스터", "2022.05.26", "10.0"));
//        list.add(new Movie("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA1MjNfMTM1%2FMDAxNjUzMjkwMjI5OTcz.gol6BAXg5r0hbQotvr6dtXsqduYAmj5WeYS10V30dLMg.AmemBsWonHmc_QP-al0-DLVl2OV_7e9c3_noy6WrDZEg.PNG.haha2829%2Fimage.png&type=a340", "범죄도시2", "2022.05.18", "9.06"));
//        list.add(new Movie("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA1MjNfMTM1%2FMDAxNjUzMjkwMjI5OTcz.gol6BAXg5r0hbQotvr6dtXsqduYAmj5WeYS10V30dLMg.AmemBsWonHmc_QP-al0-DLVl2OV_7e9c3_noy6WrDZEg.PNG.haha2829%2Fimage.png&type=a340", "범죄도시2", "2022.05.18", "9.06"));
//        list.add(new Movie("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA1MjNfMTM1%2FMDAxNjUzMjkwMjI5OTcz.gol6BAXg5r0hbQotvr6dtXsqduYAmj5WeYS10V30dLMg.AmemBsWonHmc_QP-al0-DLVl2OV_7e9c3_noy6WrDZEg.PNG.haha2829%2Fimage.png&type=a340", "범죄도시2", "2022.05.18", "9.06"));


        return list;
    }



}
