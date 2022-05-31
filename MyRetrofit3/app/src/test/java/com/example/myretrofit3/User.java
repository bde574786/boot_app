package com.example.myretrofit3;

public class User {

    private String name;
    private double height;
    private double weight;

    private User() {

    }

    public static class MyBuilder {
        private String name;
        private double height;
        private double weight;

        public MyBuilder setName(String name) {
            this.name = name;
            return this;
        }


        public MyBuilder setHeight(double height) {
            this.height = height;
            return this;

        }


        public MyBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public User build(){
            User user = new User();
            user.name = name;
            user.height = height;
            user.weight = weight;
            return user;
        }


    }


    public static void main(String[] args) {
        User user1 = new MyBuilder().setName("홍길동").build();
        User user2 = new MyBuilder().setWeight(123.123).build();
        User user3 = new MyBuilder().setName("이순신").setWeight(1.2).setHeight(123.12).build();
    }

}
