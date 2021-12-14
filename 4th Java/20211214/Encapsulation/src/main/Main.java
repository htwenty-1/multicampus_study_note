package main;

import mycls.MyClass;

public class Main {

    public static void main(String[] args) {

        MyClass cls = new MyClass();

        // 외부 패키지에 있다면 접근할 수 없음.
        // cls.number = 1;

        cls.setNumber(123);

        int num = cls.getNumber();
        System.out.println(num);
    }
}
