package main;

import cls.ChildOneClass;
import cls.ParentClass;

public class Main {

    public static void main(String[] args) {

        /*
        ChildOneClass child = new ChildOneClass();
        child.Method();     // OverRiding된 Method
        */

        ParentClass pc = new ChildOneClass();
        // ?????
        // ChildOneClass가 ParentClass 인스턴스로 생성됨


        pc.Method();        // ChildOneClass의 Method가 호출되네?
                            // 원래 parent가 가지고 있던거 말고 오버라이딩된 메서드가 호출되는거


        pc.func();
        // pc.function();   // 이거는 안됨



        ChildOneClass coc = (ChildOneClass) pc; // Cast 변환을 하면 가능, 부모클래스의 인스턴스를 자식 클래스로 바꿔줌


        coc.function();     // 이거는 또 된다
    }
}
