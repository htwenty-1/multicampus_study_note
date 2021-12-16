package main;

public class Main {

    public static void main(String[] args) {

        /*
            final == const?
            변수, class, method에 적용할 수 있다.

            1. 사용목적
              - 특정 숫자를 정해놓고 대입하는 용도로 사용한다.

        */

        int number1 = 10;        // 변수
        final int number2 = 10;  // 상수 ... 바뀌지 않음

        // number2 = 20; 안됨

        final int NUMBER = 20;  // 변수와 혼동이 올 수 있으니까 전부 대문자로
    }
}

/* final */ class Parent {   // 클래스에 final이 추가되면 상속금지

    public /* final */ void method() {    // 메서드에 final이 추가되면 오버라이드 금지
    }
}

class Child extends Parent {

    @Override
    public void method() {
    }
}

