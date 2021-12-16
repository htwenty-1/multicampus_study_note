package main;

import abstractCls.AbstractClass;
import cls.MyClass;
import cls.YouClass;

public class Main {

    public static void main(String[] args) {

        // 일반 객체처럼 생성할 수 없다.
        // AbstractClass ac = new AbstractClass();

        MyClass mycls = new MyClass();
        mycls.method();
        mycls.abstractMethod();

        AbstractClass ac = new MyClass();   // 부모 클래스의 인스턴스로 자식 클래스를 생성하는것도 가능

        ac.method();
        ac.abstractMethod();

        ((MyClass)ac).func();               // MyClass my = (MyClass)ac;    my.func(); cast변환

        YouClass you = new YouClass();
        you.abstractMethod();

        AbstractClass ac1 = new YouClass();


        // 잠깐씩 쓸거면 그냥 이렇게 해도...
        AbstractClass ac2 = new AbstractClass() {
            @Override
            public void abstractMethod() {
                System.out.println("AbstractClass abstractMethod(");
            }
        };

        ac2.abstractMethod();
        ac2.method();


    }
}
