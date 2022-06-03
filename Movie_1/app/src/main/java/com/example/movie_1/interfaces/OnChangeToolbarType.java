package com.example.movie_1.interfaces;

// 콜백 메서드를 만들 때 인터페이스를 선언한다.
// 추상 메서드를 선언한다.(구분해야 될 부분이나 데이터를 전달해야 할 경우 매개변수를 만들어 준다)
// 호출자에 가서 멤버변수를 선언(interface)
// 필요한 곳에서 OnChangeToolbarType 속해 있는 추상 메서드를 호출하면 된다.
// Movie Flagment, Info Flagment < -- 호출자가 된다.
public interface OnChangeToolbarType {
    // 확장성 있게, 유지 보수 편하게 생각
    void onSetupType(String title);
    // 프래그먼트 --> 메서드 호출 movie fragment, info fragment ... 값만 던지면 됨
    // 메인 액티비티에서 --> 콜백 받음
}
