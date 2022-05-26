package com.example.myaddview;

import java.util.ArrayList;

public class Fruit {

    String imageUrl;
    String name;
    String price;
    String count;

    public Fruit(String imageUrl, String name, String price, String count){
        this.imageUrl = imageUrl;
        this.name = name;
        this.price= price;
        this.count = count;
    }

    // 샘플 데이터 만들어 보기
    public static ArrayList<Fruit> getFruits(){
        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Fruit("https://cdn.pixabay.com/photo/2010/12/13/10/05/berries-2277__480.jpg", "수박1", "10000", "1"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2018/05/08/20/19/pomegranate-3383814__340.jpg", "수박2", "20000", "2"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2016/01/05/13/58/apple-1122537__340.jpg", "수박3", "30000","3"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2016/01/02/01/59/oranges-1117628__340.jpg", "수박4", "40000","4"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2018/06/07/16/38/blueberries-3460423__340.jpg", "수박5", "50000","5"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2016/01/03/17/59/bananas-1119790__340.jpg", "수박6", "60000","6"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2016/10/07/14/11/tangerines-1721633__340.jpg", "수박7", "70000","7"));


        return list;

    }



}
