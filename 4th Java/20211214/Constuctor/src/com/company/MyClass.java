package com.company;

public class MyClass {

    // member variable
    int number;
    String name;

    // constructor : 클래스명과 같아야해!!
    MyClass() {
        System.out.println("MyClass의 기본 생성자");
    }
    MyClass(int num) {
        System.out.println("MyClass(int num) 생성자");
    }
    MyClass(int num, String na) {
        this.number = num;  // 매개변수가 멤버변수에 접근할 때, 자기 객체 heap 영역의 주소
        this.name = na;
        System.out.println("MyClass(int num, String na) 생성자");
    }
    MyClass getThis () {
        return this;
    }

    // this가 붙어 있는건 멤버변수, 안붙어 있는건 매개변수나 지역변수로 생각하자고
}
