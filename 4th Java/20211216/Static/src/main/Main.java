package main;

import cls.MyClass;
import cls.YouClass;

public class Main {

    public static void main(String[] args) {

        /*
            static - 정적임  <==>  dynamic

            변수나 메서드에 저장할 수 있다.
        */

        MyClass cls = new MyClass();

        cls.func();
        cls.func();
        cls.func();

//        MyClass mycls = new MyClass();
//        mycls.func();
//        mycls.func();

        // static변수는 한공간만 쓰기 때문에 1씩 계속 늘어남

        // mycls.staticNumber = 11; 잘못된 접근

        MyClass.staticNumber = 14;

        // static 메서드
        YouClass yc = new YouClass();
        yc.memberMethod();      // 멤버 메서드(인스턴스 메서드)를 호출
        YouClass.staticMethod();    // static 메서드(class 메서드)를 호출, 인스턴스 없이 호출 가능

        // YouClass.swap(); 대충 이런식으로 인스턴스 없이 바로 호출

    }
}
