package com.company;

public class Main {

    public static void main(String[] args) {

        /*
            Constructor : 생성자 <==> destructor : 소멸자(없어짐)

            객체 생성 시 호출
            메서드임
            클래스명과 같다
            return 값이 없다
            overload(metho 이름은 같은데 매개변수가 다른)가 가능하다
            생략이 가능하다
   다    */

        // 배열을 초기화 할 때는 이렇게 했는데
        int[] array = { 11, 22, 33 };

        // 배열을 초기화 할때는?
        // MyClass cls = { 11, "홍길동" } ---> 가능?? 불가능!!

        // 그래서 배열을 초기화 할 때는 생성자를 써줘야한다
        // MyClass cls = new MyClass(); 이렇게

        // MyClass cls = new MyClass();    // 객체가 생성되면 기본 생성자(클래스 내의 constructor) 호출
        // MyClass cls = new MyClass(1);   // 오버로드 가능
        MyClass cls = new MyClass(1, "홍길동");
        System.out.println(cls);

        MyClass t = cls.getThis();
        System.out.println(t);

    }
}
