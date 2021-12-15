package main;

public class MyClass {

    private int number;
    private String name;

    public MyClass() {  // 기본 생성자
        // this(0, "blank");
        System.out.println("MyClass MyClass()");
    }

    public MyClass(int number, String name) {
        this();     // this의 역할 : 멤버변수 구분 또는 생성자 구분

        this.number = number;
        this.name = name;
        System.out.println("MyClass MyClass(int number, String name)");
    }
}
