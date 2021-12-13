package com.company;

public class Main {

    public static void main(String[] args) {

        /*
            Over Load : 함수명은 같고 매개변수(parameter)의 자료형이나 개수가 다른 것을 의미한다.

            paint() 함수: drawing images, 이미지를 그려줄 때 사용하는 함수
            paint(int x, int y) : 배경을 넣어주는 함수... 위에 있는 거랑 모양은 똑같은데 매개변수의 자료형, 개수가 다름 --> 이런 관계!
        */


        method();

        method('c');

        method(1);

        method('c', 1);

        method(1, 'c');

        int sum = sumProc(90, 95, 100, 75, 80);
        System.out.println(sum);

        sum = sumProc(10, 20, 30);
        System.out.println(sum);

        sumProc("성춘향", 90, 85, 100);

    }

    public static void method() {
        System.out.println("method()");
    }

    public static void method(char c) {     // 위에 함수랑 이름은 같은데 매개변수를 주니까 에러가 안나잖어!!
        System.out.println("method(char c)");
    }

    public static void method(int i) {
        System.out.println("method(int i)");
    }

    // 매개변수의 순서만 바뀌어도 다른 함수다!!
    public static void method(char c, int i) {
        System.out.println("method(char c, int i)");
    }

    public static void method(int i, char c) {
        System.out.println("method(int i, char c)");
    }

    // 주의사항
    /* 가인수의 이름이 다르다고 해서 overload되지 않는다.
    public static void method(int n, char ch) {
        System.out.println("method(int i, char c)");
    }
    */

    /* return을 주는 함수로 바꿔도 에러가 발생함.
    public int method(int i, char c) {
        System.out.println("method(int i, char c)");
        return 1;
    }
    */

    // 가변인수
    public static int sumProc (int...num) {
        int sum = 0;

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        return sum;
    }

    // 가변인수에 규칙이 있다?
    // 가변인수를 일반적인 인수와 함께 쓸 때: 가변인수는 매개변수의 맨 끝에 쓴다!
    public static void sumProc(String name, int ... num) {
        int sum = 0;

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        System.out.println(name + "님의 합계는 " + sum + "입니다.");
    }
}
