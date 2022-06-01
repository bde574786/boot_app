package com.example.myretrofit3;

// this ( 키워드 충분한 이해)
public class Student {

    private String name;
    private int grade;

    // 1. 기본 생성자를 private으로 정의한다.
    private Student() {
    }

    // 2. 내부 클래스를 생성 (static (public, default, private) - 내부 정적 클래스)
    public static class MyBuilder {
        // 2-1. out class 멤버 변수를 한 번 더 정의한다. (단, private)
        private String name;
        private int grade;

        // 2-2. setter 메서드를 만들어준다. (하지만 리턴 타입은 자기 자신이다 --> this)
        public MyBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public MyBuilder setGrade(int grade) {
            this.grade = grade;
            return this;
        }

        // 3. 핵심 !!!
        // 리턴 타입을 out class 반환 하는 메서드를 만들어준다.
        public Student build() {
            Student student = new Student();
            student.name = name; //  out class 멤버, = , inner class 멤버
            student.grade = grade;
            return student;

        }


    }


    public static void main(String[] args) {
        Student student1 = new MyBuilder().setName("홍길동").build();
        Student student2 = new MyBuilder().setGrade(1).build();
        Student student3 = new MyBuilder().setName("이순신").setGrade(3).build();
    }

}
